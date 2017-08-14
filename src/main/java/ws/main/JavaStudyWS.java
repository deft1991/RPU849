package ws.main;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import ws.model.Document;
import ws.soap.WebserviceSEI;

import javax.xml.ws.BindingProvider;

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
//        String soapServiceUrl = "http://192.168.1.195/soap/webserviceSEI?period=2017-08-03&mnemoCode=UnEmplPeriod";
        String soapServiceUrl = "http://192.168.1.195:8080/soap/webserviceSEI";
//        String soapServiceUrl = "http://localhost:8080/soap/webserviceSEI";
//        String wsdl = "http://localhost:8080/soap/webserviceSEI?wsdl";

        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(WebserviceSEI.class);
        factoryBean.setAddress(soapServiceUrl);

        WebserviceSEI webserviceSEI = (WebserviceSEI) factoryBean.create();

        Client cl = ClientProxy.getClient(webserviceSEI);
        HTTPConduit http = (HTTPConduit) cl.getConduit();

        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        httpClientPolicy.setConnectionTimeout(6000000);
        httpClientPolicy.setReceiveTimeout(6000000);

        http.setClient(httpClientPolicy);
        ((BindingProvider) webserviceSEI).getRequestContext().put("com.sun.xml.ws.request.timeout", 3 * 60 * 10000);
        Document result = webserviceSEI.getDocuments("","2017-10-10", "UnEmplPeriod");
        webserviceSEI.sayHelloTo("Golitsyn");
        System.out.println("Result: " + result);
    }

}
