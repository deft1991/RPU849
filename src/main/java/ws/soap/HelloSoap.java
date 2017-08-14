package ws.soap;

import dataProcessing.DataProcess;
import dto.SendObj;
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
    public String sayHelloTo(String text) {
        return "Hello to " + text;
    }

    //todo метод который будет возвращать документ с листом параметров
    @Override
    public Document getDocuments(String dateFrom, String dateTo, String mnemoCode) {
        Document doc = new Document();
        try {
            Date startPeriod = modifyDateFromClient(dateFrom);
            Date endPeriod = modifyDateFromClient(dateTo);
            List<SendObj> docValues = DataProcess.getValuesForUnEmplPeriod(startPeriod, endPeriod, mnemoCode);
            List<DocValues> forSend = new ArrayList<>();
            for (SendObj docValue : docValues) {
                forSend.add(new DocValues(dateFrom, dateTo, mnemoCode, docValue.getRegion(), docValue.getCount()));
            }

            doc.setDocValues(forSend);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return doc;
    }

    private Date modifyDateFromClient(String dateFromClient) throws ParseException {
         Date date = null;
        if (!"".equalsIgnoreCase(dateFromClient) && dateFromClient != null) {
            date = Util.parseStringToDateByFormat(dateFromClient, "yyyy-MM-dd");
        }
        return date;
    }
}
