package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "lgl_vacancy", schema = "public", catalog = "develop")
public class LglVacancy {

    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Basic
    @Column(name = "version", nullable = false)
    private long version;

    @Basic
    @Column(name = "actual_date", nullable = true)
    private Date actualDate;

    @Basic
    @Column(name = "close_date", nullable = true)
    private Date closeDate;

    @Basic
    @Column(name = "cur_need_no", nullable = true)
    private Integer curNeedNo;

    @Basic
    @Column(name = "dop_info", nullable = true, length = 2000)
    private String dopInfo;

    @Basic
    @Column(name = "duties", nullable = true, length = 2000)
    private String duties;

    @Basic
    @Column(name = "email", nullable = true, length = 250)
    private String email;

    @Basic
    @Column(name = "fax", nullable = true, length = 250)
    private String fax;

    @Basic
    @Column(name = "init_need_no", nullable = true)
    private Integer initNeedNo;

    @Basic
    @Column(name = "is_show_org", nullable = true)
    private Boolean isShowOrg;

    @Basic
    @Column(name = "job_no", nullable = true)
    private Integer jobNo;

    @Basic
    @Column(name = "job_send_no", nullable = true)
    private Integer jobSendNo;

    @Basic
    @Column(name = "note", nullable = true, length = 2000)
    private String note;

    @Basic
    @Column(name = "num", nullable = true, length = 20)
    private String num;

    @Basic
    @Column(name = "phone", nullable = true, length = 250)
    private String phone;

    @Basic
    @Column(name = "reg_date", nullable = true)
    private Date regDate;

    @Basic
    @Column(name = "requirement", nullable = true, length = 2000)
    private String requirement;

    @Basic
    @Column(name = "send_no", nullable = true)
    private Integer sendNo;

    @Basic
    @Column(name = "staj_month", nullable = true)
    private Integer stajMonth;

    @Basic
    @Column(name = "staj_year", nullable = true)
    private Integer stajYear;

    @Basic
    @Column(name = "szn_rec_id", nullable = true, length = 255)
    private String sznRecId;

    @Basic
    @Column(name = "zp_from", nullable = true, precision = 2)
    private BigDecimal zpFrom;

    @Basic
    @Column(name = "zp_to", nullable = true, precision = 2)
    private BigDecimal zpTo;

    @Basic
    @Column(name = "sfd_id", nullable = true)
    private Long sfdId;

    @Basic
    @Column(name = "prof_name", nullable = true, length = 255)
    private String profName;

    @Basic
    @Column(name = "sys_id", nullable = true, length = 100)
    private String sysId;

    @Basic
    @Column(name = "age_from", nullable = true)
    private Integer ageFrom;

    @Basic
    @Column(name = "age_to", nullable = true)
    private Integer ageTo;

    @Basic
    @Column(name = "fio", nullable = true, length = 250)
    private String fio;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Date getActualDate() {
        return actualDate;
    }

    public void setActualDate(Date actualDate) {
        this.actualDate = actualDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public Integer getCurNeedNo() {
        return curNeedNo;
    }

    public void setCurNeedNo(Integer curNeedNo) {
        this.curNeedNo = curNeedNo;
    }

    public String getDopInfo() {
        return dopInfo;
    }

    public void setDopInfo(String dopInfo) {
        this.dopInfo = dopInfo;
    }

    public String getDuties() {
        return duties;
    }

    public void setDuties(String duties) {
        this.duties = duties;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Integer getInitNeedNo() {
        return initNeedNo;
    }

    public void setInitNeedNo(Integer initNeedNo) {
        this.initNeedNo = initNeedNo;
    }

    public Boolean getShowOrg() {
        return isShowOrg;
    }

    public void setShowOrg(Boolean showOrg) {
        isShowOrg = showOrg;
    }

    public Integer getJobNo() {
        return jobNo;
    }

    public void setJobNo(Integer jobNo) {
        this.jobNo = jobNo;
    }

    public Integer getJobSendNo() {
        return jobSendNo;
    }

    public void setJobSendNo(Integer jobSendNo) {
        this.jobSendNo = jobSendNo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public Integer getSendNo() {
        return sendNo;
    }

    public void setSendNo(Integer sendNo) {
        this.sendNo = sendNo;
    }

    public Integer getStajMonth() {
        return stajMonth;
    }

    public void setStajMonth(Integer stajMonth) {
        this.stajMonth = stajMonth;
    }

    public Integer getStajYear() {
        return stajYear;
    }

    public void setStajYear(Integer stajYear) {
        this.stajYear = stajYear;
    }

    public String getSznRecId() {
        return sznRecId;
    }

    public void setSznRecId(String sznRecId) {
        this.sznRecId = sznRecId;
    }

    public BigDecimal getZpFrom() {
        return zpFrom;
    }

    public void setZpFrom(BigDecimal zpFrom) {
        this.zpFrom = zpFrom;
    }

    public BigDecimal getZpTo() {
        return zpTo;
    }

    public void setZpTo(BigDecimal zpTo) {
        this.zpTo = zpTo;
    }

    public Long getSfdId() {
        return sfdId;
    }

    public void setSfdId(Long sfdId) {
        this.sfdId = sfdId;
    }

    public String getProfName() {
        return profName;
    }

    public void setProfName(String profName) {
        this.profName = profName;
    }

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    public Integer getAgeFrom() {
        return ageFrom;
    }

    public void setAgeFrom(Integer ageFrom) {
        this.ageFrom = ageFrom;
    }

    public Integer getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(Integer ageTo) {
        this.ageTo = ageTo;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }
}
