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
        String[] arrCode;
        switch (mnemoCode) {
            case "UnEmplDateFrom":
                query = QueryesForMnemoCodes.getQueryForUnEmplDateFrom(session, startPeriod);
                break;
            case "UnEmplPeriod":
                query = QueryesForMnemoCodes.getQueryForUnEmplPeriod(session, startPeriod, endPeriod);
                break;
            case "UnEmplDismissed":
                query = QueryesForMnemoCodes.getQueryForUnEmplDismissed(session, startPeriod, endPeriod);
                break;
            case "UnEmplAtWillDismissed":
                query = QueryesForMnemoCodes.getQueryForUnEmplAtWillDismissed(session, startPeriod, endPeriod);
                break;
            case "UnEmplQuitAnOrg":
                query = QueryesForMnemoCodes.getQueryForUnEmplQuitAnOrg(session, startPeriod, endPeriod);
                break;
            case "UnEmplOkved":
                query = QueryesForMnemoCodes.getQueryForUnEmplOkved(session, startPeriod, endPeriod);
                break;
            case "UnEmplOkvedA":
                arrCode = new String[]{"01", "02", "03"};
                query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел А");
                break;
            case "UnEmplOkvedB":
                arrCode = new String[]{"05", "06", "07", "08", "09"};
                query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел B");
                break;
            case "UnEmplOkvedC":
                arrCode = new String[]{"10", "11", "12", "13", "14",
                        "15", "16", "17", "18", "19",
                        "20", "21", "22", "23", "24",
                        "25", "26", "27", "28", "29",
                        "30", "31", "32", "33"};
                query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел C");
                break;
            case "UnEmplOkvedD":
                arrCode = new String[]{"35"};
                query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел D");
                break;
            case "UnEmplOkvedE":
                arrCode = new String[]{"36", "37", "38", "39"};
                query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел E");
                break;
            case "UnEmplOkvedF":
                arrCode = new String[]{"41", "42", "43"};
                query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел F");
                break;
            case "UnEmplOkvedG":
                arrCode = new String[]{"45", "46", "47"};
                query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел G");
                break;
            case "UnEmplOkvedH":
                arrCode = new String[]{"49", "50", "51", "52", "53"};
                query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел H");
                break;
            case "UnEmplOkvedI":
                arrCode = new String[]{"55", "56"};
                query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел I");
                break;
            case "UnEmplOkvedJ":
                arrCode = new String[]{"58", "59", "60", "61", "62", "63"};
                query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел J");
                break;
            case "UnEmplOkvedK":
                arrCode = new String[]{"64", "65", "66"};
                query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел K");
                break;
            case "UnEmplOkvedL":
                arrCode = new String[]{"68"};
                query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел L");
                break;
            case "UnEmplOkvedM":
                arrCode = new String[]{"69", "70", "71", "72", "73", "74", "75"};
                query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел M");
                break;
            case "UnEmplOkvedN":
                arrCode = new String[]{"77", "78", "79", "80", "81", "82"};
                query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел N");
                break;
            case "UnEmplOkvedO":
                arrCode = new String[]{"84"};
                query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел O");
                break;
            case "UnEmplOkvedP":
                arrCode = new String[]{"85"};
                query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел P");
                break;
            case "UnEmplOkvedQ":
                arrCode = new String[]{"86", "87", "88"};
                query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел Q");
                break;
            case "UnEmplOkvedR":
                arrCode = new String[]{"90", "91", "92", "93"};
                query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел R");
                break;
            case "UnEmplOkvedS":
                arrCode = new String[]{"94", "95", "96"};
                query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел S");
                break;
            case "UnEmplOkvedT":
                arrCode = new String[]{"97", "98"};
                query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел T");
                break;
            case "UnEmplOkvedU":
                arrCode = new String[]{"99"};
                query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел U");
                break;
            case "UnEmplDateEnd":
                query = QueryesForMnemoCodes.getQueryForUnEmplDateEnd(session, endPeriod);
                break;
            case "EmplNeed":
                query = QueryesForMnemoCodes.getQueryForEmplNeed(session, startPeriod, endPeriod);
                break;
            case "EmplNeedDateFrom":
                query = QueryesForMnemoCodes.getQueryForEmplNeedDateFromOrDateEnd(session, startPeriod);
                break;
            case "EmplNeedDateEnd":
                query = QueryesForMnemoCodes.getQueryForEmplNeedDateFromOrDateEnd(session, endPeriod);
                break;
            default: {
                sendObjList = getSendObjsForAllMnemoCodes(startPeriod, endPeriod);
                return sendObjList;
            }

        }
        sendObjList = getSendObjs(query, startPeriod, endPeriod, mnemoCode);
        return sendObjList;
    }

    private static List<SendObj> getSendObjsForAllMnemoCodes(Date startPeriod, Date endPeriod) throws Exception {
        Query query;
        List<SendObj> sendObjList;
        String[] arrCode;
        query = QueryesForMnemoCodes.getQueryForUnEmplDateFrom(session, startPeriod);
        sendObjList = getSendObjs(query, startPeriod, endPeriod, "UnEmplDateFrom");
        query = QueryesForMnemoCodes.getQueryForUnEmplPeriod(session, startPeriod, endPeriod);
        sendObjList.addAll(getSendObjs(query, startPeriod, endPeriod, "UnEmplPeriod"));
        query = QueryesForMnemoCodes.getQueryForUnEmplDismissed(session, startPeriod, endPeriod);
        sendObjList.addAll(getSendObjs(query, startPeriod, endPeriod, "UnEmplDismissed"));
        query = QueryesForMnemoCodes.getQueryForUnEmplAtWillDismissed(session, startPeriod, endPeriod);
        sendObjList.addAll(getSendObjs(query, startPeriod, endPeriod, "UnEmplAtWillDismissed"));
        query = QueryesForMnemoCodes.getQueryForUnEmplQuitAnOrg(session, startPeriod, endPeriod);
        sendObjList.addAll(getSendObjs(query, startPeriod, endPeriod, "UnEmplQuitAnOrg"));
        query = QueryesForMnemoCodes.getQueryForUnEmplOkved(session, startPeriod, endPeriod);
        sendObjList.addAll(getSendObjs(query, startPeriod, endPeriod, "UnEmplOkved"));
        arrCode = new String[]{"01", "02", "03"};
        query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел А");
        sendObjList.addAll(getSendObjs(query, startPeriod, endPeriod, "UnEmplOkvedA"));
        arrCode = new String[]{"05", "06", "07", "08", "09"};
        query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел B");
        sendObjList.addAll(getSendObjs(query, startPeriod, endPeriod, "UnEmplOkvedB"));
        arrCode = new String[]{"10", "11", "12", "13", "14",
                "15", "16", "17", "18", "19",
                "20", "21", "22", "23", "24",
                "25", "26", "27", "28", "29",
                "30", "31", "32", "33"};
        query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел C");
        sendObjList.addAll(getSendObjs(query, startPeriod, endPeriod, "UnEmplOkvedC"));
        arrCode = new String[]{"35"};
        query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел D");
        sendObjList.addAll(getSendObjs(query, startPeriod, endPeriod, "UnEmplOkvedD"));
        arrCode = new String[]{"36", "37", "38", "39"};
        query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел E");
        sendObjList.addAll(getSendObjs(query, startPeriod, endPeriod, "UnEmplOkvedE"));
        arrCode = new String[]{"41", "42", "43"};
        query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел F");
        sendObjList.addAll(getSendObjs(query, startPeriod, endPeriod, "UnEmplOkvedF"));
        arrCode = new String[]{"45", "46", "47"};
        query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел G");
        sendObjList.addAll(getSendObjs(query, startPeriod, endPeriod, "UnEmplOkvedG"));
        arrCode = new String[]{"49", "50", "51", "52", "53"};
        query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел H");
        sendObjList.addAll(getSendObjs(query, startPeriod, endPeriod, "UnEmplOkvedH"));
        arrCode = new String[]{"55", "56"};
        query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел I");
        sendObjList.addAll(getSendObjs(query, startPeriod, endPeriod, "UnEmplOkvedI"));
        arrCode = new String[]{"58", "59", "60", "61", "62", "63"};
        query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел J");
        sendObjList.addAll(getSendObjs(query, startPeriod, endPeriod, "UnEmplOkvedJ"));
        arrCode = new String[]{"64", "65", "66"};
        query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел K");
        sendObjList.addAll(getSendObjs(query, startPeriod, endPeriod, "UnEmplOkvedK"));
        arrCode = new String[]{"68"};
        query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел L");
        sendObjList.addAll(getSendObjs(query, startPeriod, endPeriod, "UnEmplOkvedL"));
        arrCode = new String[]{"69", "70", "71", "72", "73", "74", "75"};
        query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел M");
        sendObjList.addAll(getSendObjs(query, startPeriod, endPeriod, "UnEmplOkvedM"));
        arrCode = new String[]{"77", "78", "79", "80", "81", "82"};
        query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел N");
        sendObjList.addAll(getSendObjs(query, startPeriod, endPeriod, "UnEmplOkvedN"));
        arrCode = new String[]{"84"};
        query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел O");
        sendObjList.addAll(getSendObjs(query, startPeriod, endPeriod, "UnEmplOkvedO"));
        arrCode = new String[]{"85"};
        query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел P");
        sendObjList.addAll(getSendObjs(query, startPeriod, endPeriod, "UnEmplOkvedP"));
        arrCode = new String[]{"86", "87", "88"};
        query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел Q");
        sendObjList.addAll(getSendObjs(query, startPeriod, endPeriod, "UnEmplOkvedQ"));
        arrCode = new String[]{"90", "91", "92", "93"};
        query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел R");
        sendObjList.addAll(getSendObjs(query, startPeriod, endPeriod, "UnEmplOkvedR"));
        arrCode = new String[]{"94", "95", "96"};
        query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел S");
        sendObjList.addAll(getSendObjs(query, startPeriod, endPeriod, "UnEmplOkvedS"));
        arrCode = new String[]{"97", "98"};
        query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел T");
        sendObjList.addAll(getSendObjs(query, startPeriod, endPeriod, "UnEmplOkvedT"));
        arrCode = new String[]{"99"};
        query = QueryesForMnemoCodes.getQueryForUnEmplDiffOkved(session, startPeriod, endPeriod, arrCode, "Раздел U");
        sendObjList.addAll(getSendObjs(query, startPeriod, endPeriod, "UnEmplOkvedU"));
        query = QueryesForMnemoCodes.getQueryForUnEmplDateEnd(session, endPeriod);
        sendObjList.addAll(getSendObjs(query, startPeriod, endPeriod, "UnEmplDateEnd"));
        query = QueryesForMnemoCodes.getQueryForEmplNeed(session, startPeriod, endPeriod);
        sendObjList.addAll(getSendObjs(query, startPeriod, endPeriod, "EmplNeed"));
        query = QueryesForMnemoCodes.getQueryForEmplNeedDateFromOrDateEnd(session, startPeriod);
        sendObjList.addAll(getSendObjs(query, startPeriod, endPeriod, "EmplNeedDateFrom"));
        query = QueryesForMnemoCodes.getQueryForEmplNeedDateFromOrDateEnd(session, endPeriod);
        sendObjList.addAll(getSendObjs(query, startPeriod, endPeriod, "EmplNeedDateEnd"));
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

}
