package dataProcessing;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Date;

public class QueryesForMnemoCodes {

    public static Query getQueryForUnEmplDiffOkved(Session session, Date startPeriod, Date endPeriod, Object[] arrCode, String nameCode) throws Exception {
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
                    "  AND ((left(coalesce(okved2ForOrg.code, okved2ForWork.code, okved1ForWork.code), 2) IN (:arrCode)) " +
                    "  OR (coalesce(okved2ForOrg.code, okved2ForWork.code, okved1ForWork.code) = :nameCode)) " +
                    "GROUP BY st.rhd_region;");
            query.setDate("startPeriod", startPeriod);
            query.setDate("endPeriod", endPeriod);
            query.setString("nameCode", nameCode);
            query.setParameterList("arrCode", arrCode);
            return query;
        } else throw new Exception("startPeriod or endPeriod can be null!");
    }

    // todo переписать под hibernate - как пока хз
    //2.2
    public static Query getQueryForUnEmplOkved(Session session, Date startPeriod, Date endPeriod) throws Exception {
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
    public static Query getQueryForUnEmplQuitAnOrg(Session session, Date startPeriod, Date endPeriod) throws Exception {
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
    public static Query getQueryForUnEmplAtWillDismissed(Session session, Date startPeriod, Date endPeriod) throws Exception {
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
    public static Query getQueryForUnEmplDismissed(Session session, Date startPeriod, Date endPeriod) throws Exception {
        if (startPeriod != null && endPeriod != null) {
//            Query query = session.createQuery("" +
//                    "SELECT po.kpy.sysTalon.rhdRegion, COUNT (*)  " +
//                    "from PsnOrder po join po.kpy.psnPrevWorkList work " +
//                    "where " +
//                    "po.prkz.prkzCode.code = 'ПРКЗ' " +
//                    "and po.prkz.code = '12' " +
//                    "and po.status.statusCode.code = 'СТП' " +
//                    "and po.status.code = '1' " +
//                    "and po.orderDate >= :startPeriod " +
//                    "and po.orderDate <= :endPeriod " +
//                    "and (work.puvLine.id is not null " +
//                    "or (work.puvLine.code ='КНГ' " +
//                    "and work.puvLine.puvCode.code in ('17', '18', '19', '21', '22', '23', '24', '25', '26', '16', '28'))) " +
//                    "GROUP BY po.kpy.sysTalon.rhdRegion");
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

    public static Query getQueryForUnEmplDateEnd(Session session, Date endPeriod) {
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

    public static String createHQLStringForUnEmplDateEnd(Date endPeriod) {
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

    public static Query getQueryForUnEmplDateFrom(Session session, Date startPeriod) throws Exception {
        if (startPeriod != null) {
            Query query = session.createQuery("select po.kpy.sysTalon.rhdRegion " +
                    ", count (*) " +
                    "from PsnOrder po " +
                    "where " +
                    "po.prkz.prkzCode.code = :prkzCode " +
                    "and po.status.statusCode.code = :statusCode " +
                    "and  status.code = :codeOne " +
                    "and (( " +
                    " po.prkz.code = :codeTwelve " +
                    "and po.startDate <= :startPeriod " +
                    "and po.endDate >= :startPeriod ) " +
                    " or ( prkz.code = :codeEight  and po.startDate > :startPeriod )) " +
                    "group by po.kpy.sysTalon.rhdRegion");
            query.setDate("startPeriod", startPeriod);
            query.setString("codeTwelve", "12");
            query.setString("codeEight", "8");
            query.setString("prkzCode", "ПРКЗ");
            query.setString("statusCode", "СТП");
            query.setString("codeOne", "1");
            return query;
        } else throw new Exception("startPeriod can be null!");
    }

    public static String createHQLStringForUnEmplDateFrom(Date startPeriod) {
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

    public static Query getQueryForUnEmplPeriod(Session session, Date startPeriod, Date endPeriod) throws Exception {
        if (startPeriod != null && endPeriod != null) {
            Query query = session.createQuery("" +
                    "select po.kpy.sysTalon.rhdRegion, " +
                    "count (*) " +
                    "from PsnOrder po " +
                    "where " +
                    "po.orderDate >= :startPeriod " +
                    "and po.orderDate <= :endPeriod " +
                    "and po.prkz.prkzCode.code = 'ПРКЗ' " +
                    "and po.prkz.code = '12' " +
                    "and po.status.statusCode.code = 'СТП' " +
                    "and po.status.code = '1' " +
                    "group by po.kpy.sysTalon.rhdRegion");
            query.setDate("startPeriod", startPeriod);
            query.setDate("endPeriod", endPeriod);
            return query;
        } else throw new Exception("startPeriod or endPeriod can be null!");
    }

    public static Query getQueryForEmplNeed(Session session, Date startPeriod, Date endPeriod) throws Exception {
        if (startPeriod != null && endPeriod != null) {
            Query query = session.createQuery("" +
                    "select his.sysTalon.rhdRegion, " +
                    "count (his.curNeedNo) " +
                    "from LglVacancyHistory his " +
                    "where " +
                    "his.editDate >= :startPeriod " +
                    "and his.editDate <= :endPeriod " +
                    "group by his.sysTalon.rhdRegion ");
            query.setDate("startPeriod", startPeriod);
            query.setDate("endPeriod", endPeriod);
            return query;
        } else throw new Exception("startPeriod or endPeriod can be null!");
    }

    public static Query getQueryForEmplNeedDateFromOrDateEnd(Session session, Date date) throws Exception {
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
}
