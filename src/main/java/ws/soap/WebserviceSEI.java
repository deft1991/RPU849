package ws.soap;

import ws.model.DocValues;
import ws.model.Document;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created for JavaStudy.ru on 11.06.2016.
 */

/**
 * The @WebService annotation on the implementation class lets CXF know which
 * interface to use when creating WSDL. In this case its simply our HelloWorld interface.
 */
@WebService
public interface WebserviceSEI {

    @WebMethod
    String sayHelloTo(@WebParam(name = "text") String text);

    @WebMethod
    Document getDocuments(String dateFrom, String dateTo, String mnemoCode);
}
