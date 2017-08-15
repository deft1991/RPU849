package ws.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created for JavaStudy.ru on 11.06.2016.
 */
@XmlRootElement(name = "goods")
public class DocValues implements Serializable {

    private String dateFrom;
    private String dateTo;
    private String mnemoCode;
    private int regionCode;
    private int valueIndicator;

    public DocValues() {
    }

    public DocValues(String dateFrom, String dateTo, String mnemoCode, int regionCode, int valueIndicator) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.mnemoCode = mnemoCode;
        this.regionCode = regionCode;
        this.valueIndicator = valueIndicator;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public Integer getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(Integer regionCode) {
        this.regionCode = regionCode;
    }

    public String getMnemoCode() {
        return mnemoCode;
    }

    public void setMnemoCode(String mnemoCode) {
        this.mnemoCode = mnemoCode;
    }

    public Integer getValueIndicator() {
        return valueIndicator;
    }

    public void setValueIndicator(Integer valueIndicator) {
        this.valueIndicator = valueIndicator;
    }

    @Override
    public String toString() {
        return "DocValues{" +
                " dateFrom=" + dateFrom +
                " dateTo=" + dateTo +
                ", mnemoCode='" + mnemoCode + '\'' +
                ", regionCode='" + regionCode + '\'' +
                ", valueIndicator='" + valueIndicator + '\'' +
                '}';
    }
}
