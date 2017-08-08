package dto;

import java.util.Date;

public class SendObj {
    String mnemocode;
    Date startDate;
    Date endDate;
    int region;
    int count;

    public SendObj() {
    }

    public SendObj(String mnemocode, Date startDate, Date endDate, int region, int count) {
        this.mnemocode = mnemocode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.region = region;
        this.count = count;
    }

    public String getMnemocode() {
        return mnemocode;
    }

    public void setMnemocode(String mnemocode) {
        this.mnemocode = mnemocode;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
