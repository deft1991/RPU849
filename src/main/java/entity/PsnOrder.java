package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "psn_order", schema = "public", catalog = "develop")
public class PsnOrder {
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Basic
    @Column(name = "version", nullable = false)
    private long version;

    @Basic
    @Column(name = "cancel_date", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date cancelDate;

    @Basic
    @Column(name = "dop_info", nullable = true, length = 100)
    private String dopInfo;

    @Basic
    @Column(name = "duration", nullable = true, precision = 2)
    private BigDecimal duration;

    @Basic
    @Column(name = "end_date", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Basic
    @Column(name = "form_date", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date formDate;

    @Basic
    @Column(name = "is_keep", nullable = true)
    private Boolean isKeep;

    @Basic
    @Column(name = "is_money_help", nullable = true)
    private Boolean isMoneyHelp;

    @Basic
    @Column(name = "note_date", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date noteDate;

    @Basic
    @Column(name = "order_date", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @Basic
    @Column(name = "order_num", nullable = true, length = 100)
    private String orderNum;

    @Basic
    @Column(name = "reg_date", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date regDate;

    @Basic
    @Column(name = "region_coeff", nullable = true, precision = 2)
    private BigDecimal regionCoeff;

    @Basic
    @Column(name = "staj_last_year", nullable = true)
    private Long stajLastYear;

    @Basic
    @Column(name = "start_date", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Basic
    @Column(name = "summ", nullable = true, precision = 2)
    private BigDecimal summ;

    @Basic
    @Column(name = "szn_rec_id", nullable = true, length = 100)
    private String sznRecId;

    @Basic
    @Column(name = "total_staj_days", nullable = true)
    private Long totalStajDays;

    @Basic
    @Column(name = "total_staj_month", nullable = true)
    private Long totalStajMonth;

    @Basic
    @Column(name = "total_staj_years", nullable = true)
    private Long totalStajYears;

    @Basic
    @Column(name = "zp", nullable = true, precision = 2)
    private BigDecimal zp;

    @Basic
    @Column(name = "opv_id", nullable = true)
    private Long opvId;

    @Basic
    @Column(name = "sys_id", nullable = true, length = 100)
    private String sysId;

    @ManyToOne
    @JoinColumn(name = "prkz_id")
    private RefDictLine prkz;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private RefDictLine status;

    // личное дело
    @ManyToOne
    @JoinColumn(name = "kpy_id")
    private PsnKpy kpy;

    public PsnKpy getKpy() {
        return kpy;
    }

    public void setKpy(PsnKpy kpy) {
        this.kpy = kpy;
    }

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

    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    public String getDopInfo() {
        return dopInfo;
    }

    public void setDopInfo(String dopInfo) {
        this.dopInfo = dopInfo;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getFormDate() {
        return formDate;
    }

    public void setFormDate(Date formDate) {
        this.formDate = formDate;
    }

    public Boolean getKeep() {
        return isKeep;
    }

    public void setKeep(Boolean keep) {
        isKeep = keep;
    }

    public Boolean getMoneyHelp() {
        return isMoneyHelp;
    }

    public void setMoneyHelp(Boolean moneyHelp) {
        isMoneyHelp = moneyHelp;
    }

    public Date getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(Date noteDate) {
        this.noteDate = noteDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public BigDecimal getRegionCoeff() {
        return regionCoeff;
    }

    public void setRegionCoeff(BigDecimal regionCoeff) {
        this.regionCoeff = regionCoeff;
    }

    public Long getStajLastYear() {
        return stajLastYear;
    }

    public void setStajLastYear(Long stajLastYear) {
        this.stajLastYear = stajLastYear;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public BigDecimal getSumm() {
        return summ;
    }

    public void setSumm(BigDecimal summ) {
        this.summ = summ;
    }

    public String getSznRecId() {
        return sznRecId;
    }

    public void setSznRecId(String sznRecId) {
        this.sznRecId = sznRecId;
    }

    public Long getTotalStajDays() {
        return totalStajDays;
    }

    public void setTotalStajDays(Long totalStajDays) {
        this.totalStajDays = totalStajDays;
    }

    public Long getTotalStajMonth() {
        return totalStajMonth;
    }

    public void setTotalStajMonth(Long totalStajMonth) {
        this.totalStajMonth = totalStajMonth;
    }

    public Long getTotalStajYears() {
        return totalStajYears;
    }

    public void setTotalStajYears(Long totalStajYears) {
        this.totalStajYears = totalStajYears;
    }

    public BigDecimal getZp() {
        return zp;
    }

    public void setZp(BigDecimal zp) {
        this.zp = zp;
    }

    public Long getOpvId() {
        return opvId;
    }

    public void setOpvId(Long opvId) {
        this.opvId = opvId;
    }

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    public RefDictLine getPrkz() {
        return prkz;
    }

    public void setPrkz(RefDictLine prkz) {
        this.prkz = prkz;
    }

    public RefDictLine getStatus() {
        return status;
    }

    public void setStatus(RefDictLine status) {
        this.status = status;
    }
}
