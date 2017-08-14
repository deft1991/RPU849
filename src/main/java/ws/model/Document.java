package ws.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created for JavaStudy.ru on 12.06.2016.
 */
@XmlRootElement(name = "document")
public class Document implements Serializable {

    private List<DocValues> docValues;

    public Document() {
    }

    public Document(List<DocValues> docValues) {
        this.docValues = docValues;
    }

    public List<DocValues> getDocValues() {
        return docValues;
    }

    public void setDocValues(List<DocValues> docValues) {
        this.docValues = docValues;
    }


    @Override
    public String toString() {
        return "Document{" +
                "docValues=" + docValues +
                '}';
    }
}
