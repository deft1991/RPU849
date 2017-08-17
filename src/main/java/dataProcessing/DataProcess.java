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
        Query query = null;
        switch (mnemoCode) {
            case "UnEmplDateFrom":
                query = getQueryForUnEmplDateFrom(startPeriod);
                break;
            case "UnEmplPeriod":
                query = getQueryForUnEmplPeriod(startPeriod, endPeriod);
                break;
            case "UnEmplDismissed":
                query = getQueryForUnEmplDismissed(startPeriod, endPeriod);
                break;
            case "UnEmplAtWillDismissed":
                query = getQueryForUnEmplAtWillDismissed(startPeriod, endPeriod);
                break;
            case "UnEmplQuitAnOrg":
                query = getQueryForUnEmplQuitAnOrg(startPeriod, endPeriod);
                break;
            case "UnEmplOkved":
                query = getQueryForUnEmplOkved(startPeriod, endPeriod);
                break;
            case "UnEmplOkvedA":
                query = getQueryForUnEmplOkvedA(startPeriod, endPeriod, "01", "Раздел А");
                break;
            case "UnEmplDateEnd":
                query = getQueryForUnEmplDateEnd(endPeriod);
                break;
            case "EmplNeed":
                query = getQueryForEmplNeed(startPeriod, endPeriod);
                break;
            case "EmplNeedDateFrom":
                query = getQueryForEmplNeedDateFromOrDateEnd(startPeriod);
                break;
            case "EmplNeedDateEnd":
                query = getQueryForEmplNeedDateFromOrDateEnd(endPeriod);
                break;

        }
        sendObjList = getSendObjs(query, startPeriod, endPeriod, mnemoCode);
        return sendObjList;
    }

    private static Query getQueryForUnEmplOkvedA(Date startPeriod, Date endPeriod, String numCode, String nameCode) throws Exception {
        if (startPeriod != null && endPeriod != null) {
            Query query = session.createSQLQuery("SELECT " +
                    "  st.rhd_region, " +
                    "  count(*) " +
                    "FROM psn_order o " +
                    "  JOIN psn_kpy kpy ON o.kpy_id = kpy.id " +
                    "  JOIN psn_prev_work work ON kpy.id = work.kpy_id " +
                    "  JOIN lgl_organization org ON work.org_id = org.id " +
                    "  LEFT JOIN ref_okved2 okved2ForOrg ON org.okved2_id = okved2ForOrg.id " +
                    "  LEFT JOIN ref_okved2 okved2ForWork ON work.okved2_id = okved2ForWork.id " +
                    "  LEFT JOIN ref_okved1 okved1ForWork ON work.okved1_id = okved1ForWork.id " +
                    "  JOIN ref_dict_line prkzLine ON o.prkz_id = prkzLine.id " +
                    "  JOIN ref_dict prkz ON prkzLine.dict_id = prkz.id " +
                    "  JOIN ref_dict_line stpLine ON o.status_id = stpLine.id " +
                    "  JOIN ref_dict stp ON stpLine.dict_id = stp.id " +
                    "  JOIN sys_talon st ON kpy.sys_id = st.sys_id " +
                    "WHERE " +
                    "  prkz.code = 'ПРКЗ' " +
                    "  AND prkzLine.code = '12' " +
                    "  AND stp.code = 'СТП' " +
                    "  AND stpLine.code = '1' " +
                    "  AND o.order_date >= :startPeriod " +
                    "  AND o.order_date <= :endPeriod " +
                    "  AND ((left(coalesce(okved2ForOrg.code, okved2ForWork.code, okved1ForWork.code), 2) IN ('01','02','03')) " +
                    "  OR (coalesce(okved2ForOrg.code, okved2ForWork.code, okved1ForWork.code) = 'Раздел А')) " +
                    "GROUP BY st.rhd_region;");
            query.setDate("startPeriod", startPeriod);
            query.setDate("endPeriod", endPeriod);
            return query;
        } else throw new Exception("startPeriod or endPeriod can be null!");
    }

    // todo переписать под hibernate - как пока хз
    //2.2
    private static Query getQueryForUnEmplOkved(Date startPeriod, Date endPeriod) throws Exception {
        if (startPeriod != null && endPeriod != null) {
            Query query = session.createSQLQuery("SELECT " +
                    "  st.rhd_region, " +
                    "  count(*) " +
                    "FROM psn_order o " +
                    "  JOIN psn_kpy kpy ON o.kpy_id = kpy.id " +
                    "  JOIN psn_prev_work work ON kpy.id = work.kpy_id " +
                    "  JOIN lgl_organization org ON work.org_id = org.id " +
                    "  LEFT JOIN ref_okved2 okved2ForOrg ON org.okved2_id = okved2ForOrg.id " +
                    "  LEFT JOIN ref_okved2 okved2ForWork ON work.okved2_id = okved2ForWork.id " +
                    "  LEFT JOIN ref_okved1 okved1ForWork ON work.okved1_id = okved1ForWork.id " +
                    "  JOIN ref_dict_line prkzLine ON o.prkz_id = prkzLine.id " +
                    "  JOIN ref_dict prkz ON prkzLine.dict_id = prkz.id " +
                    "  JOIN ref_dict_line stpLine ON o.status_id = stpLine.id " +
                    "  JOIN ref_dict stp ON stpLine.dict_id = stp.id " +
                    "  JOIN sys_talon st ON kpy.sys_id = st.sys_id " +
                    "WHERE " +
                    "  prkz.code = 'ПРКЗ' " +
                    "  AND prkzLine.code = '12' " +
                    "  AND stp.code = 'СТП' " +
                    "  AND stpLine.code = '1' " +
                    "  AND o.order_date >= :startPeriod " +
                    "  AND o.order_date <= :endPeriod " +
                    "  AND coalesce(okved2ForOrg.id, okved2ForWork.id, okved1ForWork.id) IS NOT NULL " +
                    "GROUP BY st.rhd_region;");
            query.setDate("startPeriod", startPeriod);
            query.setDate("endPeriod", endPeriod);
            return query;
        } else throw new Exception("startPeriod or endPeriod can be null!");

    }

    // todo переписать под hibernate - как пока хз
    //2.1.2
    private static Query getQueryForUnEmplQuitAnOrg(Date startPeriod, Date endPeriod) throws Exception {
        if (startPeriod != null && endPeriod != null) {
            Query query = session.createSQLQuery("SELECT " +
                    "  st.rhd_region, " +
                    "  count(*) " +
                    "FROM psn_order o " +
                    "  JOIN psn_kpy kpy ON o.kpy_id = kpy.id " +
                    "  JOIN psn_prev_work work ON kpy.id = work.kpy_id " +
                    "  JOIN ref_dict_line puvLine ON work.puv_id = puvLine.id " +
                    "  JOIN ref_dict puv ON puvLine.dict_id = puv.id " +
                    "  JOIN ref_dict_line prkzLine ON o.prkz_id = prkzLine.id " +
                    "  JOIN ref_dict prkz ON prkzLine.dict_id = prkz.id " +
                    "  JOIN ref_dict_line stpLine ON o.status_id = stpLine.id " +
                    "  JOIN ref_dict stp ON stpLine.dict_id = stp.id " +
                    "  JOIN sys_talon st ON kpy.sys_id = st.sys_id " +
                    "WHERE " +
                    "  prkz.code = 'ПРКЗ' " +
                    "  AND prkzLine.code = '12' " +
                    "  AND stp.code = 'СТП' " +
                    "  AND stpLine.code = '1' " +
                    "  AND o.order_date >= :startPeriod " +
                    "  AND o.order_date <= :endPeriod " +
                    "  AND (puvLine.code IN ('В','ВЛ','ВС','ВСК','rc') OR (puv.code = 'КНГ' AND puvLine.code = '21' )) " +
                    "GROUP BY st.rhd_region;");
            query.setDate("startPeriod", startPeriod);
            query.setDate("endPeriod", endPeriod);
            return query;
        } else throw new Exception("startPeriod or endPeriod can be null!");
    }

    // todo переписать под hibernate - как пока хз
    //2.1.1
    private static Query getQueryForUnEmplAtWillDismissed(Date startPeriod, Date endPeriod) throws Exception {
        if (startPeriod != null && endPeriod != null) {
            Query query = session.createSQLQuery("SELECT " +
                    "  st.rhd_region, " +
                    "  count(*)\n" +
                    "FROM psn_order o " +
                    "  JOIN psn_kpy kpy ON o.kpy_id = kpy.id " +
                    "  JOIN psn_prev_work work ON kpy.id = work.kpy_id " +
                    "  JOIN ref_dict_line puvLine ON work.puv_id = puvLine.id " +
                    "  JOIN ref_dict puv ON puvLine.dict_id = puv.id " +
                    "  JOIN ref_dict_line prkzLine ON o.prkz_id = prkzLine.id " +
                    "  JOIN ref_dict prkz ON prkzLine.dict_id = prkz.id " +
                    "  JOIN ref_dict_line stpLine ON o.status_id = stpLine.id " +
                    "  JOIN ref_dict stp ON stpLine.dict_id = stp.id " +
                    "  JOIN sys_talon st ON kpy.sys_id = st.sys_id " +
                    "WHERE " +
                    "  prkz.code = 'ПРКЗ' " +
                    "  AND prkzLine.code = '12' " +
                    "  AND stp.code = 'СТП' " +
                    "  AND stpLine.code = '1' " +
                    "  AND o.order_date >= :startPeriod " +
                    "  AND o.order_date <= :endPeriod " +
                    "  AND puvLine.code IN ('ЛЖ','С','СН','СУ','СУБ','СУД','СУИ','СУП,СУР','СУС','СУУ','СУЧ') " +
                    "GROUP BY st.rhd_region;");
            query.setDate("startPeriod", startPeriod);
            query.setDate("endPeriod", endPeriod);
            return query;
        } else throw new Exception("startPeriod or endPeriod can be null!");
    }

    // todo переписать под hibernate - как пока хз
    //2.1
    private static Query getQueryForUnEmplDismissed(Date startPeriod, Date endPeriod) throws Exception {
        if (startPeriod != null && endPeriod != null) {
            Query query = session.createSQLQuery(
                    "SELECT st.rhd_region, COUNT (*) " +
                            "FROM psn_order o " +
                            "  JOIN psn_kpy kpy ON o.kpy_id = kpy.id " +
                            "  JOIN psn_prev_work WORK ON kpy.id = WORK.kpy_id " +
                            "  JOIN ref_dict_line puvLine ON WORK.puv_id = puvLine.id " +
                            "  JOIN ref_dict puv ON puvLine.dict_id = puv.id " +
                            "  JOIN ref_dict_line prkzLine ON o.prkz_id = prkzLine.id " +
                            "  JOIN ref_dict prkz ON prkzLine.dict_id = prkz.id " +
                            "  JOIN ref_dict_line stpLine ON o.status_id = stpLine.id " +
                            "  JOIN ref_dict stp ON stpLine.dict_id = stp.id " +
                            "  JOIN sys_talon st ON kpy.sys_id = st.sys_id " +
                            "WHERE prkz.code = 'ПРКЗ' " +
                            "      AND prkzLine.code = '12' " +
                            "      AND stp.code = 'СТП' " +
                            "      AND stpLine.code = '1' " +
                            "      AND o.order_date >= :startPeriod " +
                            "      AND o.order_date <= :endPeriod " +
                            "      AND (WORK.puv_id IS NOT NULL " +
                            "           OR (puv.code ='КНГ' " +
                            "               AND puvLine.code IN ('17', '18', '19', '21', '22', '23', '24', '25', '26', '16', '28'))) " +
                            "GROUP BY st.rhd_region;");
            query.setDate("startPeriod", startPeriod);
            query.setDate("endPeriod", endPeriod);
            return query;
        } else throw new Exception("startPeriod or endPeriod can be null!");
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

    private static Query getQueryForEmplNeedDateFromOrDateEnd(Date date) throws Exception {
        if (date != null) {
            Query query = session.createQuery("" +
                    "select his.sysTalon.rhdRegion, " +
                    "count(his.curNeedNo) - count(his.jobNo) " +
                    "from LglVacancyHistory his " +
                    "where his.vacancy.regDate <= :date " +
                    "and (his.vacancy.closeDate is null or his.vacancy.closeDate > :date) " +
                    "and   his.editDate <= :date " +
                    "group by his.sysTalon.rhdRegion");
            query.setDate("date", date);
            return query;
        } else throw new Exception("startPeriod can be null");
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

}
