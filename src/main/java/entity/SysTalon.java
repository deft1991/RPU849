package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "sys_talon", schema = "public", catalog = "develop")
public class SysTalon {

    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Basic
    @Column(name = "version", nullable = false)
    private long version;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "fdate", nullable = true)
    private Date fdate;

    @Basic
    @Column(name = "ftime", nullable = true, length = 100)
    private String ftime;

    @Basic
    @Column(name = "npart", nullable = true)
    private Long npart;

    @Basic
    @Column(name = "parts", nullable = true)
    private Long parts;

    @Basic
    @Column(name = "person", nullable = true, length = 100)
    private String person;

    @Basic
    @Column(name = "rhd_bgyear", nullable = true)
    private Long rhdBgyear;

    @Basic
    @Column(name = "rhd_filial", nullable = true, length = 100)
    private String rhdFilial;

    @Basic
    @Column(name = "rhd_okato", nullable = true, length = 100)
    private String rhdOkato;

    @Basic
    @Column(name = "rhd_region", nullable = true, length = 100)
    private String rhdRegion;

    @Basic
    @Column(name = "rhd_schema", nullable = true, length = 100)
    private String rhdSchema;

    @Basic
    @Column(name = "rhd_user", nullable = true, length = 100)
    private String rhdUser;

    @Basic
    @Column(name = "sys_created", nullable = true)
    private Timestamp sysCreated;

    @Basic
    @Column(name = "sys_id", nullable = true, length = 100)
    private String sysId;

    @Basic
    @Column(name = "sys_status", nullable = true)
    private Long sysStatus;

    @Basic
    @Column(name = "sys_updated", nullable = true)
    private Timestamp sysUpdated;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "tdate", nullable = true)
    private Date tdate;

    @Basic
    @Column(name = "ttime", nullable = true, length = 100)
    private String ttime;

    @Basic
    @Column(name = "txt_filial", nullable = true, length = 100)
    private String txtFilial;

    @Basic
    @Column(name = "txt_schema", nullable = true, length = 100)
    private String txtSchema;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "vdate", nullable = true)
    private Date vdate;

    @Basic
    @Column(name = "vers", nullable = true, length = 100)
    private String vers;

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

    public Date getFdate() {
        return fdate;
    }

    public void setFdate(Date fdate) {
        this.fdate = fdate;
    }

    public String getFtime() {
        return ftime;
    }

    public void setFtime(String ftime) {
        this.ftime = ftime;
    }

    public Long getNpart() {
        return npart;
    }

    public void setNpart(Long npart) {
        this.npart = npart;
    }

    public Long getParts() {
        return parts;
    }

    public void setParts(Long parts) {
        this.parts = parts;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public Long getRhdBgyear() {
        return rhdBgyear;
    }

    public void setRhdBgyear(Long rhdBgyear) {
        this.rhdBgyear = rhdBgyear;
    }

    public String getRhdFilial() {
        return rhdFilial;
    }

    public void setRhdFilial(String rhdFilial) {
        this.rhdFilial = rhdFilial;
    }

    public String getRhdOkato() {
        return rhdOkato;
    }

    public void setRhdOkato(String rhdOkato) {
        this.rhdOkato = rhdOkato;
    }

    public String getRhdRegion() {
        return rhdRegion;
    }

    public void setRhdRegion(String rhdRegion) {
        this.rhdRegion = rhdRegion;
    }

    public String getRhdSchema() {
        return rhdSchema;
    }

    public void setRhdSchema(String rhdSchema) {
        this.rhdSchema = rhdSchema;
    }

    public String getRhdUser() {
        return rhdUser;
    }

    public void setRhdUser(String rhdUser) {
        this.rhdUser = rhdUser;
    }

    public Timestamp getSysCreated() {
        return sysCreated;
    }

    public void setSysCreated(Timestamp sysCreated) {
        this.sysCreated = sysCreated;
    }

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    public Long getSysStatus() {
        return sysStatus;
    }

    public void setSysStatus(Long sysStatus) {
        this.sysStatus = sysStatus;
    }

    public Timestamp getSysUpdated() {
        return sysUpdated;
    }

    public void setSysUpdated(Timestamp sysUpdated) {
        this.sysUpdated = sysUpdated;
    }

    @Temporal(TemporalType.DATE)
    public Date getTdate() {
        return tdate;
    }

    public void setTdate(Date tdate) {
        this.tdate = tdate;
    }

    public String getTtime() {
        return ttime;
    }

    public void setTtime(String ttime) {
        this.ttime = ttime;
    }

    public String getTxtFilial() {
        return txtFilial;
    }

    public void setTxtFilial(String txtFilial) {
        this.txtFilial = txtFilial;
    }

    public String getTxtSchema() {
        return txtSchema;
    }

    public void setTxtSchema(String txtSchema) {
        this.txtSchema = txtSchema;
    }

    public Date getVdate() {
        return vdate;
    }

    public void setVdate(Date vdate) {
        this.vdate = vdate;
    }

    public String getVers() {
        return vers;
    }

    public void setVers(String vers) {
        this.vers = vers;
    }
}
