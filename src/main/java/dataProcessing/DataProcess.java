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
                Query query = session.createQuery("" +
                        "select po.kpy.sysTalon.rhdRegion " +
                        ", count (*) " +
                        "from PsnOrder po " +
                        "where po.startDate >= :startPeriod " +
                        "and po.endDate <= :endPeriod " +
                        "and prkz.prkzCode.code = :prkzCode " +
                        "and prkz.code = :codeTvelve " +
                        "and status.statusCode.code = :statusCode " +
                        "and  status.code = :codeOne " +
                        "group by po.kpy.sysTalon.rhdRegion");
                query.setDate("startPeriod", startPeriod);
                query.setDate("endPeriod", endPeriod);
                query.setString("prkzCode", "ПРКЗ");
                query.setString("codeTvelve", "12");
                query.setString("statusCode", "СТП");
                query.setString("codeOne", "1");
                objList = query.list();
                for (Object[] o : objList) {
                    SendObj sendObj = new SendObj(mnemoCode,startPeriod,endPeriod,Integer.parseInt(o[0].toString()),Integer.parseInt(o[1].toString()));
                    sendObjList.add(sendObj);
                }

            } catch (Exception e) {
                if (session != null) {
                    session.getTransaction().begin();
                    session.getTransaction().rollback();
                    session.flush();
                    session.close();
                }
            }finally {
                    HibernateSessionFactory.shutdown();
            }
            return sendObjList;
        }
        return null;
    }
}
