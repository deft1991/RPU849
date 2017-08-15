package ws.main;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import ws.model.Document;
import ws.soap.WebserviceSEI;

import javax.xml.ws.BindingProvider;

public class JavaStudyWS {

    public static void main(String[] args) {
        testSOAPFromClient();
    }

    /**
     * create client and test soap service
     */
    private static void testSOAPFromClient() {
        String soapServiceUrl = "http://192.168.1.195:8080/soap/webserviceSEI";
//        String soapServiceUrl = "http://localhost:8080/soap/webserviceSEI";

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
//        Document result = webserviceSEI.getDocuments("2017-09-10","2017-10-10", "UnEmplDateFrom"); // 1
//        Document result = webserviceSEI.getDocuments("2012-09-10","2012-10-10", "UnEmplPeriod"); // 2
        Document result = webserviceSEI.getDocuments("2017-09-10","2017-10-10", "UnEmplDateEnd"); // 3
        webserviceSEI.sayHelloTo("Golitsyn");
        System.out.println("Result: " + result);
    }

}
