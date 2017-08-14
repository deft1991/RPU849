package dataProcessing;

import dto.SendObj;
import hibernate.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataProcess {
    private static Session session;

    private static void createBDConnection() {
        // создаем коннект к БД (сессию для хибера)
        System.out.println("Try create connection to BD");
        session = HibernateSessionFactory.getSessionFactory().openSession();
        System.out.println("Connection success");
    }

    public static List<SendObj> getValuesForUnEmplPeriod(Date startPeriod, Date endPeriod, String mnemoCode) {
        if ("UnEmplPeriod".equalsIgnoreCase(mnemoCode)) {
            List<SendObj> sendObjList = new ArrayList<>();
            Transaction tx = null;
            try {
                // создаем коннект к БД (сессию для хибера)
                createBDConnection();
                List<Object[]> objList;
                Query query = getQueryForUnEmplPeriod(startPeriod, endPeriod);
                objList = query.list();
                for (Object[] o : objList) {
                    SendObj sendObj = new SendObj(mnemoCode, startPeriod, endPeriod, Integer.parseInt(o[0].toString()), Integer.parseInt(o[1].toString()));
                    sendObjList.add(sendObj);
                }
                return sendObjList;
            } catch (Exception e) {
                if (session != null) {
                    session.getTransaction().begin();
                    session.getTransaction().rollback();
                    session.flush();
                    session.close();
                }
            } finally {
                HibernateSessionFactory.shutdown();
            }
        }
        return null;
    }

    private static Query getQueryForUnEmplPeriod(Date startPeriod, Date endPeriod) {
        String hql = createHQLString(startPeriod, endPeriod);
        Query query = session.createQuery(hql);
        if (hql.contains(":startPeriod"))
            query.setDate("startPeriod", startPeriod);
        if (hql.contains(":endPeriod"))
            query.setDate("endPeriod", endPeriod);
        query.setString("prkzCode", "ПРКЗ");
        query.setString("codeTvelve", "12");
        query.setString("statusCode", "СТП");
        query.setString("codeOne", "1");
        return query;
    }

    private static String createHQLString(Date startPeriod, Date endPeriod) {
        StringBuilder hql = new StringBuilder()
                .append("select po.kpy.sysTalon.rhdRegion ")
                .append(", count (*) ")
                .append("from PsnOrder po ")
                .append("where ");
        if (startPeriod != null)
            hql.append("po.startDate >= :startPeriod ");
        if (startPeriod != null && endPeriod != null)
            hql.append("and po.endDate <= :endPeriod ");
        else if (startPeriod == null && endPeriod != null)
            hql.append(" po.endDate <= :endPeriod ");

        hql.append("and prkz.prkzCode.code = :prkzCode ")
                .append("and prkz.code = :codeTvelve ")
                .append("and status.statusCode.code = :statusCode ")
                .append("and  status.code = :codeOne ")
                .append("group by po.kpy.sysTalon.rhdRegion");

        return hql.toString();
    }
}
