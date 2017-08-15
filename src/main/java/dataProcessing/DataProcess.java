package dataProcessing;

import dto.SendObj;
import hibernate.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;

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

    public static List<SendObj> getValuesForMnemoCode(Date startPeriod, Date endPeriod, String mnemoCode) throws Exception {
        List<SendObj> sendObjList = null;
        createBDConnection();
        switch (mnemoCode) {
            case "UnEmplDateFrom": {
                Query query = getQueryForUnEmplDateFrom(startPeriod);
                sendObjList = getSendObjs(query, startPeriod, endPeriod, mnemoCode);
                break;
            }
            case "UnEmplPeriod": {
                Query query = getQueryForUnEmplPeriod(startPeriod, endPeriod);
                sendObjList = getSendObjs(query, startPeriod, endPeriod, mnemoCode);
                break;
            }
            case "UnEmplDateEnd": {
                Query query = getQueryForUnEmplDateEnd(endPeriod);
                sendObjList = getSendObjs(query, startPeriod, endPeriod, mnemoCode);
                break;
            }
            case "EmplNeed": {
                Query query = getQueryForEmplNeed(startPeriod, endPeriod);
                sendObjList = getSendObjs(query, startPeriod, endPeriod, mnemoCode);
                break;
            }
            case "EmplNeedDateFrom": {
                Query query = getQueryForEmplNeedDateFrom(startPeriod);
                sendObjList = getSendObjs(query, startPeriod, endPeriod, mnemoCode);
                break;
            }
        }
        return sendObjList;
    }

    private static List<SendObj> getSendObjs(Query query, Date startPeriod, Date endPeriod, String mnemoCode) {
        List<SendObj> sendObjList = new ArrayList<>();
        List<Object[]> objList;
        objList = query.list();
        for (Object[] o : objList) {
            SendObj sendObj = new SendObj(mnemoCode, startPeriod, endPeriod, Integer.parseInt(o[0].toString()), Integer.parseInt(o[1].toString()));
            sendObjList.add(sendObj);
        }
        return sendObjList;
    }


    private static Query getQueryForUnEmplDateEnd(Date endPeriod) {
        String hql = createHQLStringForUnEmplDateEnd(endPeriod);
        Query query = session.createQuery(hql);
        if (hql.contains("endPeriod")) {
            query.setDate("endPeriod", endPeriod);
        }
        query.setString("codeTwelve", "12");
        query.setString("codeEight", "8");
        query.setString("prkzCode", "ПРКЗ");
        query.setString("statusCode", "СТП");
        query.setString("codeOne", "1");
        return query;
    }

    private static String createHQLStringForUnEmplDateEnd(Date endPeriod) {
        StringBuilder hql = new StringBuilder()
                .append("select po.kpy.sysTalon.rhdRegion ")
                .append(", count (*) ")
                .append("from PsnOrder po ")
                .append("where prkz.prkzCode.code = :prkzCode ")
                .append("and status.statusCode.code = :statusCode ")
                .append("and  status.code = :codeOne and (( ")
                .append(" prkz.code = :codeTwelve ");
        if (endPeriod != null) {
            hql.append("and po.startDate <= :endPeriod ")
                    .append("and po.endDate >= :endPeriod )");
        }
        hql.append(" or ( ")
                .append("prkz.code = :codeEight ");
        if (endPeriod != null) {
            hql.append(" and po.startDate > :endPeriod )) ");
        }
        hql.append("group by po.kpy.sysTalon.rhdRegion");
        return hql.toString();
    }

    private static Query getQueryForUnEmplDateFrom(Date startPeriod) {
        String hql = createHQLStringForUnEmplDateFrom(startPeriod);
        Query query = session.createQuery(hql);
        if (hql.contains("startPeriod")) {
            query.setDate("startPeriod", startPeriod);
        }
        query.setString("codeTwelve", "12");
        query.setString("codeEight", "8");
        query.setString("prkzCode", "ПРКЗ");
        query.setString("statusCode", "СТП");
        query.setString("codeOne", "1");
        return query;
    }

    private static String createHQLStringForUnEmplDateFrom(Date startPeriod) {
        StringBuilder hql = new StringBuilder()
                .append("select po.kpy.sysTalon.rhdRegion ")
                .append(", count (*) ")
                .append("from PsnOrder po ")
                .append("where prkz.prkzCode.code = :prkzCode ")
                .append("and status.statusCode.code = :statusCode ")
                .append("and  status.code = :codeOne and (( ")
                .append(" prkz.code = :codeTwelve ");
        if (startPeriod != null) {
            hql.append("and po.startDate <= :startPeriod ")
                    .append("and po.endDate >= :startPeriod )");
        }
        hql.append(" or ( ")
                .append("prkz.code = :codeEight ");
        if (startPeriod != null) {
            hql.append(" and po.startDate > :startPeriod )) ");
        }
        hql.append("group by po.kpy.sysTalon.rhdRegion");

        return hql.toString();
    }

    private static Query getQueryForUnEmplPeriod(Date startPeriod, Date endPeriod) {
        String hql = createHQLStringForUnEmplPeriod(startPeriod, endPeriod);
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

    private static String createHQLStringForUnEmplPeriod(Date startPeriod, Date endPeriod) {
        StringBuilder hql = new StringBuilder()
                .append("select po.kpy.sysTalon.rhdRegion ")
                .append(", count (*) ")
                .append("from PsnOrder po ")
                .append("where ");
        if (startPeriod != null)
            hql.append("po.orderDate >= :startPeriod ");
        if (startPeriod != null && endPeriod != null)
            hql.append("and po.orderDate <= :endPeriod ");
        else if (startPeriod == null && endPeriod != null)
            hql.append(" po.orderDate <= :endPeriod ");

        hql.append("and prkz.prkzCode.code = :prkzCode ")
                .append("and prkz.code = :codeTvelve ")
                .append("and status.statusCode.code = :statusCode ")
                .append("and  status.code = :codeOne ")
                .append("group by po.kpy.sysTalon.rhdRegion");
        return hql.toString();
    }


    private static Query getQueryForEmplNeed(Date startPeriod, Date endPeriod) {
        String hql = createHQLStringForEmplNeed(startPeriod, endPeriod);
        Query query = session.createQuery(hql);
        if (hql.contains("startPeriod"))
            query.setDate("startPeriod", startPeriod);
        if (hql.contains("endPeriod"))
            query.setDate("endPeriod", endPeriod);
        return query;
    }

    private static String createHQLStringForEmplNeed(Date startPeriod, Date endPeriod) {
        StringBuilder hql = new StringBuilder()
                .append("select his.sysTalon.rhdRegion, ")
                .append("count (his.curNeedNo) ")
                .append("from LglVacancyHistory his ")
                .append("where");
        if (startPeriod != null) {
            hql.append(" his.editDate >= :startPeriod ");
        }
        if (startPeriod != null && endPeriod != null)
            hql.append("and his.editDate <= :endPeriod ");
        else if (endPeriod != null)
            hql.append(" his.editDate <= :endPeriod ");
        hql.append(" group by his.sysTalon.rhdRegion ");
        return hql.toString();
    }

    private static Query getQueryForEmplNeedDateFrom(Date startPeriod) throws Exception {
        if (startPeriod != null) {
            Query query = session.createQuery("" +
                    "select his.sysTalon.rhdRegion, " +
                    "count(his.curNeedNo) - count(his.jobNo) " +
                    "from LglVacancyHistory his " +
                    "where his.vacancy.regDate <= :startPeriod " +
                    "and (his.vacancy.closeDate is null or his.vacancy.closeDate > :startPeriod) " +
                    "and   his.editDate <= :startPeriod " +
                    "group by his.sysTalon.rhdRegion");
            query.setDate("startPeriod",startPeriod);
            return query;
        } else throw new Exception("startPeriod can be null");
    }
}
