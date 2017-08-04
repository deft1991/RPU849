package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "psn_kpy", schema = "public", catalog = "develop")
public class PsnKpy {

    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Basic
    @Column(name = "version", nullable = false)
    private long version;

    @Basic
    @Column(name = "doc_date", nullable = true)
    private Date docDate;

    @Basic
    @Column(name = "num", nullable = true, length = 100)
    private String num;

    @Basic
    @Column(name = "obr_date", nullable = true)
    private Date obrDate;

    @Basic
    @Column(name = "pz_close_date", nullable = true)
    private Date pzCloseDate;

    @Basic
    @Column(name = "szn_rec_id", nullable = true, length = 100)
    private String sznRecId;

    @Basic
    @Column(name = "close_date", nullable = true)
    private Date closeDate;

    @Basic
    @Column(name = "sys_id", nullable = true, length = 100)
    private String sysId;

    @Basic
    @Column(name = "unempl_date", nullable = true)
    private Date unemplDate;

    @Basic
    @Column(name = "is_ref_direct", nullable = true)
    private Boolean isRefDirect;

    @Basic
    @Column(name = "sent_by", nullable = true, length = 255)
    private String sentBy;

    @Basic
    @Column(name = "fio", nullable = true, length = 300)
    private String fio;

    @Basic
    @Column(name = "order_date", nullable = true)
    private Date orderDate;

    @Basic
    @Column(name = "rgn", nullable = true, length = 255)
    private String rgn;

    @Basic
    @Column(name = "rgn_id", nullable = true)
    private Long rgnId;

    @Basic
    @Column(name = "szn", nullable = true, length = 255)
    private String szn;

    @Basic
    @Column(name = "end_date", nullable = true)
    private Date endDate;

    @Basic
    @Column(name = "kzf_name", nullable = true, length = 255)
    private String kzfName;

    @Basic
    @Column(name = "rgn_name", nullable = true, length = 255)
    private String rgnName;

    @Basic
    @Column(name = "szn_name", nullable = true, length = 255)
    private String sznName;

    @Basic
    @Column(name = "tpr_name", nullable = true, length = 255)
    private String tprName;

    @Basic
    @Column(name = "duration", nullable = true)
    private Long duration;

    @Basic
    @Column(name = "job_period", nullable = true, length = 100)
    private String jobPeriod;

    @Basic
    @Column(name = "kzf", nullable = true, length = 100)
    private String kzf;

    @Basic
    @Column(name = "otm_period", nullable = true, length = 100)
    private String otmPeriod;

    @Basic
    @Column(name = "period", nullable = true, length = 100)
    private String period;

    @Basic
    @Column(name = "rgnid", nullable = true)
    private Long rgnid;

    @Basic
    @Column(name = "tpr", nullable = true, length = 100)
    private String tpr;

    @ManyToOne(targetEntity = SysTalon.class)
    @JoinColumn(name = "sys_id", insertable = false, updatable = false)
    private SysTalon sysTalon;

    public SysTalon getTalon() {
        return sysTalon;
    }

    public void setTalon(SysTalon sysTalon) {
        this.sysTalon = sysTalon;
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

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Date getObrDate() {
        return obrDate;
    }

    public void setObrDate(Date obrDate) {
        this.obrDate = obrDate;
    }

    public Date getPzCloseDate() {
        return pzCloseDate;
    }

    public void setPzCloseDate(Date pzCloseDate) {
        this.pzCloseDate = pzCloseDate;
    }

    public String getSznRecId() {
        return sznRecId;
    }

    public void setSznRecId(String sznRecId) {
        this.sznRecId = sznRecId;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    public Date getUnemplDate() {
        return unemplDate;
    }

    public void setUnemplDate(Date unemplDate) {
        this.unemplDate = unemplDate;
    }

    public Boolean getRefDirect() {
        return isRefDirect;
    }

    public void setRefDirect(Boolean refDirect) {
        isRefDirect = refDirect;
    }

    public String getSentBy() {
        return sentBy;
    }

    public void setSentBy(String sentBy) {
        this.sentBy = sentBy;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getRgn() {
        return rgn;
    }

    public void setRgn(String rgn) {
        this.rgn = rgn;
    }

    public Long getRgnId() {
        return rgnId;
    }

    public void setRgnId(Long rgnId) {
        this.rgnId = rgnId;
    }

    public String getSzn() {
        return szn;
    }

    public void setSzn(String szn) {
        this.szn = szn;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getKzfName() {
        return kzfName;
    }

    public void setKzfName(String kzfName) {
        this.kzfName = kzfName;
    }

    public String getRgnName() {
        return rgnName;
    }

    public void setRgnName(String rgnName) {
        this.rgnName = rgnName;
    }

    public String getSznName() {
        return sznName;
    }

    public void setSznName(String sznName) {
        this.sznName = sznName;
    }

    public String getTprName() {
        return tprName;
    }

    public void setTprName(String tprName) {
        this.tprName = tprName;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getJobPeriod() {
        return jobPeriod;
    }

    public void setJobPeriod(String jobPeriod) {
        this.jobPeriod = jobPeriod;
    }

    public String getKzf() {
        return kzf;
    }

    public void setKzf(String kzf) {
        this.kzf = kzf;
    }

    public String getOtmPeriod() {
        return otmPeriod;
    }

    public void setOtmPeriod(String otmPeriod) {
        this.otmPeriod = otmPeriod;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Long getRgnid() {
        return rgnid;
    }

    public void setRgnid(Long rgnid) {
        this.rgnid = rgnid;
    }

    public String getTpr() {
        return tpr;
    }

    public void setTpr(String tpr) {
        this.tpr = tpr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PsnKpy psnKpy = (PsnKpy) o;

        if (id != psnKpy.id) return false;
        if (version != psnKpy.version) return false;
        if (docDate != null ? !docDate.equals(psnKpy.docDate) : psnKpy.docDate != null) return false;
        if (num != null ? !num.equals(psnKpy.num) : psnKpy.num != null) return false;
        if (obrDate != null ? !obrDate.equals(psnKpy.obrDate) : psnKpy.obrDate != null) return false;
        if (pzCloseDate != null ? !pzCloseDate.equals(psnKpy.pzCloseDate) : psnKpy.pzCloseDate != null) return false;
        if (sznRecId != null ? !sznRecId.equals(psnKpy.sznRecId) : psnKpy.sznRecId != null) return false;
        if (closeDate != null ? !closeDate.equals(psnKpy.closeDate) : psnKpy.closeDate != null) return false;
        if (sysId != null ? !sysId.equals(psnKpy.sysId) : psnKpy.sysId != null) return false;
        if (unemplDate != null ? !unemplDate.equals(psnKpy.unemplDate) : psnKpy.unemplDate != null) return false;
        if (isRefDirect != null ? !isRefDirect.equals(psnKpy.isRefDirect) : psnKpy.isRefDirect != null) return false;
        if (sentBy != null ? !sentBy.equals(psnKpy.sentBy) : psnKpy.sentBy != null) return false;
        if (fio != null ? !fio.equals(psnKpy.fio) : psnKpy.fio != null) return false;
        if (orderDate != null ? !orderDate.equals(psnKpy.orderDate) : psnKpy.orderDate != null) return false;
        if (rgn != null ? !rgn.equals(psnKpy.rgn) : psnKpy.rgn != null) return false;
        if (rgnId != null ? !rgnId.equals(psnKpy.rgnId) : psnKpy.rgnId != null) return false;
        if (szn != null ? !szn.equals(psnKpy.szn) : psnKpy.szn != null) return false;
        if (endDate != null ? !endDate.equals(psnKpy.endDate) : psnKpy.endDate != null) return false;
        if (kzfName != null ? !kzfName.equals(psnKpy.kzfName) : psnKpy.kzfName != null) return false;
        if (rgnName != null ? !rgnName.equals(psnKpy.rgnName) : psnKpy.rgnName != null) return false;
        if (sznName != null ? !sznName.equals(psnKpy.sznName) : psnKpy.sznName != null) return false;
        if (tprName != null ? !tprName.equals(psnKpy.tprName) : psnKpy.tprName != null) return false;
        if (duration != null ? !duration.equals(psnKpy.duration) : psnKpy.duration != null) return false;
        if (jobPeriod != null ? !jobPeriod.equals(psnKpy.jobPeriod) : psnKpy.jobPeriod != null) return false;
        if (kzf != null ? !kzf.equals(psnKpy.kzf) : psnKpy.kzf != null) return false;
        if (otmPeriod != null ? !otmPeriod.equals(psnKpy.otmPeriod) : psnKpy.otmPeriod != null) return false;
        if (period != null ? !period.equals(psnKpy.period) : psnKpy.period != null) return false;
        if (rgnid != null ? !rgnid.equals(psnKpy.rgnid) : psnKpy.rgnid != null) return false;
        if (tpr != null ? !tpr.equals(psnKpy.tpr) : psnKpy.tpr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (version ^ (version >>> 32));
        result = 31 * result + (docDate != null ? docDate.hashCode() : 0);
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (obrDate != null ? obrDate.hashCode() : 0);
        result = 31 * result + (pzCloseDate != null ? pzCloseDate.hashCode() : 0);
        result = 31 * result + (sznRecId != null ? sznRecId.hashCode() : 0);
        result = 31 * result + (closeDate != null ? closeDate.hashCode() : 0);
        result = 31 * result + (sysId != null ? sysId.hashCode() : 0);
        result = 31 * result + (unemplDate != null ? unemplDate.hashCode() : 0);
        result = 31 * result + (isRefDirect != null ? isRefDirect.hashCode() : 0);
        result = 31 * result + (sentBy != null ? sentBy.hashCode() : 0);
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (rgn != null ? rgn.hashCode() : 0);
        result = 31 * result + (rgnId != null ? rgnId.hashCode() : 0);
        result = 31 * result + (szn != null ? szn.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (kzfName != null ? kzfName.hashCode() : 0);
        result = 31 * result + (rgnName != null ? rgnName.hashCode() : 0);
        result = 31 * result + (sznName != null ? sznName.hashCode() : 0);
        result = 31 * result + (tprName != null ? tprName.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (jobPeriod != null ? jobPeriod.hashCode() : 0);
        result = 31 * result + (kzf != null ? kzf.hashCode() : 0);
        result = 31 * result + (otmPeriod != null ? otmPeriod.hashCode() : 0);
        result = 31 * result + (period != null ? period.hashCode() : 0);
        result = 31 * result + (rgnid != null ? rgnid.hashCode() : 0);
        result = 31 * result + (tpr != null ? tpr.hashCode() : 0);
        return result;
    }
}
