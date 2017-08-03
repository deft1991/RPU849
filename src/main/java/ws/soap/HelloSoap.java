package ws.soap;

import dataProcessing.DataProcess;
import dto.SendObj;
import hibernate.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.Util;
import ws.model.DocValues;
import ws.model.Document;

import javax.jws.WebService;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created for JavaStudy.ru on 10.06.2016.
 */
@WebService(endpointInterface = "ws.soap.WebserviceSEI",
        serviceName = "HelloSoap")
public class HelloSoap implements WebserviceSEI {


    @Override
    public String testService() {
        return "Hello from SOAP Webservice!";
    }

    @Override
    public String sayHelloTo(String text) {
        return "Hello to " + text;
    }

    //todo метод который будет возвращать документ с листом параметров
    @Override
    public Document getDocuments(String period, String mnemoCode) {
        Document doc = new Document();
        try {
            String[] dates = period.split(":");
            Date startPeriod = Util.parseStringToDateByFormat(dates[0], "yyyy-MM-dd");
            Date endPeriod = Util.parseStringToDateByFormat(dates[1], "yyyy-MM-dd");
            List<SendObj> docValues = DataProcess.getValuesForUnEmplPeriod(startPeriod, endPeriod, mnemoCode);
//            doc.setDocValues(docValues);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return doc;
    }
}
