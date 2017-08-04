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

    static {
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
                List<?> objList = new ArrayList<>();
                Query query = session.createQuery("" +
                        "select kpy.sysTalon.rhdRegion, count (*) " +
                        "from PsnOrder " +
                        "where startDate >= :startPeriod " +
                        "and endDate <= :endPeriod " +
                        "and prkz.prkzCode.code = :prkzCode " +
                        "and prkz.code = :codeTvelve " +
                        "and status.statusCode.code = :statusCode " +
                        "and  status.code = :codeOne " +
                        "group by kpy.sysTalon.rhdRegion");
                query.setDate("startPeriod", startPeriod);
                query.setDate("endPeriod", startPeriod);
                query.setString("prkzCode", "ПРКЗ");
                query.setString("statusCode", "СТП");
                query.setString("codeTvelve", "12");
                query.setString("codeOne", "1");
                query.setMaxResults(10);
                tx = session.beginTransaction();
                objList = query.list();
                for (Object o : objList) {
                    SendObj sendObj = (SendObj) o;
                    sendObjList.add(sendObj);
                }
            } catch (Exception e) {
                if (tx != null) {
                    tx.rollback();
                    tx.commit();
                }
            }
            return sendObjList;
        }
        return null;
    }
}
