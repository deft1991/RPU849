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
import java.util.Date;

@Entity
@Table(name = "psn_prev_work", schema = "public", catalog = "develop")
public class PsnPrevWork {

    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Basic
    @Column(name = "version", nullable = false)
    private long version;

    @Basic
    @Column(name = "dop_info", nullable = true, length = 250)
    private String dopInfo;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date", nullable = true)
    private Date endDate;

    @Basic
    @Column(name = "is_last", nullable = true)
    private Boolean isLast;

    @Basic
    @Column(name = "org_name", nullable = true, length = 250)
    private String orgName;

    @Basic
    @Column(name = "roles", nullable = true, length = 100)
    private String roles;

    @Basic
    @Column(name = "staj", nullable = true, precision = 2)
    private BigDecimal staj;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date", nullable = true)
    private Date startDate;

    @Basic
    @Column(name = "szn_rec_id", nullable = true, length = 100)
    private String sznRecId;

    @Basic
    @Column(name = "sys_id", nullable = true, length = 100)
    private String sysId;

    @Basic
    @Column(name = "prof_name", nullable = true, length = 255)
    private String profName;

    @Basic
    @Column(name = "last_work_progress", nullable = true, length = 255)
    private String lastWorkProgress;

    // Причина увольнения
    @ManyToOne(targetEntity = RefDictLine.class)
    @JoinColumn(name = "puv_id")
    private RefDictLine dismissal;

    @ManyToOne(targetEntity = PsnKpy.class)
    @JoinColumn(name = "kpy_id")
    private PsnKpy psnKpy;

    @ManyToOne(targetEntity = SysTalon.class)
    @JoinColumn(name = "sys_id", referencedColumnName = "sys_id", insertable = false, updatable = false)
    private SysTalon sysTalon;

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

    public String getDopInfo() {
        return dopInfo;
    }

    public void setDopInfo(String dopInfo) {
        this.dopInfo = dopInfo;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Boolean getLast() {
        return isLast;
    }

    public void setLast(Boolean last) {
        isLast = last;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public BigDecimal getStaj() {
        return staj;
    }

    public void setStaj(BigDecimal staj) {
        this.staj = staj;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getSznRecId() {
        return sznRecId;
    }

    public void setSznRecId(String sznRecId) {
        this.sznRecId = sznRecId;
    }

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    public String getProfName() {
        return profName;
    }

    public void setProfName(String profName) {
        this.profName = profName;
    }

    public String getLastWorkProgress() {
        return lastWorkProgress;
    }

    public void setLastWorkProgress(String lastWorkProgress) {
        this.lastWorkProgress = lastWorkProgress;
    }

    public RefDictLine getDismissal() {
        return dismissal;
    }

    public void setDismissal(RefDictLine dismissal) {
        this.dismissal = dismissal;
    }
}
