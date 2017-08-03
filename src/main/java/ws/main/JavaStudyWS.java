package ws.main;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import ws.model.Document;
import ws.soap.WebserviceSEI;

/**
 * Created for JavaStudy.ru on 09.06.2016.
 */
public class JavaStudyWS {

    public static void main(String[] args) {
        testSOAPFromClient();
    }

    /**
     * create client and test soap service
     */
    private static void testSOAPFromClient() {
//        String soapServiceUrl = "http://localhost:8080/soap/webserviceSEI?period=2017-08-03&mnemoCode=UnEmplPeriod";
        String soapServiceUrl = "http://localhost:8080/soap/webserviceSEI";
        String wsdl = "http://localhost:8080/soap/webserviceSEI?wsdl";

        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(WebserviceSEI.class);
        factoryBean.setAddress(soapServiceUrl);

        WebserviceSEI webserviceSEI = (WebserviceSEI) factoryBean.create();

        Document result = webserviceSEI.getDocuments("2016-08-03:2017-10-10", "UnEmplPeriod");
        webserviceSEI.sayHelloTo("Golitsyn");
        System.out.println("Result: " + result);
    }

}
