package ws.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created for JavaStudy.ru on 11.06.2016.
 */
@XmlRootElement(name = "goods")
public class DocValues implements Serializable {

    private String period;
    private String mnemoCode;
    private String regionCode;
    private String valueIndicator;

    public DocValues() {
    }

    public DocValues(String period, String mnemoCode, String regionCode, String valueIndicator) {
        this.period = period;
        this.mnemoCode = mnemoCode;
        this.regionCode = regionCode;
        this.valueIndicator = valueIndicator;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getMnemoCode() {
        return mnemoCode;
    }

    public void setMnemoCode(String mnemoCode) {
        this.mnemoCode = mnemoCode;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getValueIndicator() {
        return valueIndicator;
    }

    public void setValueIndicator(String valueIndicator) {
        this.valueIndicator = valueIndicator;
    }

    @Override
    public String toString() {
        return "DocValues{" +
                ", period=" + period +
                ", mnemoCode='" + mnemoCode + '\'' +
                ", regionCode='" + regionCode + '\'' +
                ", valueIndicator='" + valueIndicator + '\'' +
                '}';
    }
}
