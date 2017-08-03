package ws.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created for JavaStudy.ru on 12.06.2016.
 */
@XmlRootElement(name = "document")
public class Document implements Serializable {

    private DocValues docValues;

    public Document() {
    }

    public Document(DocValues docValues) {
        this.docValues = docValues;
    }

    public DocValues getDocValues() {
        return docValues;
    }

    public void setDocValues(DocValues docValues) {
        this.docValues = docValues;
    }


    @Override
    public String toString() {
        return "Document{" +
                ", docValues=" + docValues +
                '}';
    }
}
