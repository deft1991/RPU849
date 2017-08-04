package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "sys_talon", schema = "public", catalog = "develop")
public class SysTalon {
    private long id;
    private long version;
    private Date fdate;
    private String ftime;
    private Long npart;
    private Long parts;
    private String person;
    private Long rhdBgyear;
    private String rhdFilial;
    private String rhdOkato;
    private String rhdRegion;
    private String rhdSchema;
    private String rhdUser;
    private Timestamp sysCreated;
    private String sysId;
    private Long sysStatus;
    private Timestamp sysUpdated;
    private Date tdate;
    private String ttime;
    private String txtFilial;
    private String txtSchema;
    private Date vdate;
    private String vers;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "version", nullable = false)
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Basic
    @Column(name = "fdate", nullable = true)
    @Temporal(TemporalType.DATE)
    public Date getFdate() {
        return fdate;
    }

    public void setFdate(Date fdate) {
        this.fdate = fdate;
    }

    @Basic
    @Column(name = "ftime", nullable = true, length = 100)
    public String getFtime() {
        return ftime;
    }

    public void setFtime(String ftime) {
        this.ftime = ftime;
    }

    @Basic
    @Column(name = "npart", nullable = true)
    public Long getNpart() {
        return npart;
    }

    public void setNpart(Long npart) {
        this.npart = npart;
    }

    @Basic
    @Column(name = "parts", nullable = true)
    public Long getParts() {
        return parts;
    }

    public void setParts(Long parts) {
        this.parts = parts;
    }

    @Basic
    @Column(name = "person", nullable = true, length = 100)
    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    @Basic
    @Column(name = "rhd_bgyear", nullable = true)
    public Long getRhdBgyear() {
        return rhdBgyear;
    }

    public void setRhdBgyear(Long rhdBgyear) {
        this.rhdBgyear = rhdBgyear;
    }

    @Basic
    @Column(name = "rhd_filial", nullable = true, length = 100)
    public String getRhdFilial() {
        return rhdFilial;
    }

    public void setRhdFilial(String rhdFilial) {
        this.rhdFilial = rhdFilial;
    }

    @Basic
    @Column(name = "rhd_okato", nullable = true, length = 100)
    public String getRhdOkato() {
        return rhdOkato;
    }

    public void setRhdOkato(String rhdOkato) {
        this.rhdOkato = rhdOkato;
    }

    @Basic
    @Column(name = "rhd_region", nullable = true, length = 100)
    public String getRhdRegion() {
        return rhdRegion;
    }

    public void setRhdRegion(String rhdRegion) {
        this.rhdRegion = rhdRegion;
    }

    @Basic
    @Column(name = "rhd_schema", nullable = true, length = 100)
    public String getRhdSchema() {
        return rhdSchema;
    }

    public void setRhdSchema(String rhdSchema) {
        this.rhdSchema = rhdSchema;
    }

    @Basic
    @Column(name = "rhd_user", nullable = true, length = 100)
    public String getRhdUser() {
        return rhdUser;
    }

    public void setRhdUser(String rhdUser) {
        this.rhdUser = rhdUser;
    }

    @Basic
    @Column(name = "sys_created", nullable = true)
    public Timestamp getSysCreated() {
        return sysCreated;
    }

    public void setSysCreated(Timestamp sysCreated) {
        this.sysCreated = sysCreated;
    }

    @Basic
    @Column(name = "sys_id", nullable = true, length = 100)
    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    @Basic
    @Column(name = "sys_status", nullable = true)
    public Long getSysStatus() {
        return sysStatus;
    }

    public void setSysStatus(Long sysStatus) {
        this.sysStatus = sysStatus;
    }

    @Basic
    @Column(name = "sys_updated", nullable = true)
    public Timestamp getSysUpdated() {
        return sysUpdated;
    }

    public void setSysUpdated(Timestamp sysUpdated) {
        this.sysUpdated = sysUpdated;
    }

    @Basic
    @Column(name = "tdate", nullable = true)
    @Temporal(TemporalType.DATE)
    public Date getTdate() {
        return tdate;
    }

    public void setTdate(Date tdate) {
        this.tdate = tdate;
    }

    @Basic
    @Column(name = "ttime", nullable = true, length = 100)
    public String getTtime() {
        return ttime;
    }

    public void setTtime(String ttime) {
        this.ttime = ttime;
    }

    @Basic
    @Column(name = "txt_filial", nullable = true, length = 100)
    public String getTxtFilial() {
        return txtFilial;
    }

    public void setTxtFilial(String txtFilial) {
        this.txtFilial = txtFilial;
    }

    @Basic
    @Column(name = "txt_schema", nullable = true, length = 100)
    public String getTxtSchema() {
        return txtSchema;
    }

    public void setTxtSchema(String txtSchema) {
        this.txtSchema = txtSchema;
    }

    @Basic
    @Column(name = "vdate", nullable = true)
    @Temporal(TemporalType.DATE)
    public Date getVdate() {
        return vdate;
    }

    public void setVdate(Date vdate) {
        this.vdate = vdate;
    }

    @Basic
    @Column(name = "vers", nullable = true, length = 100)
    public String getVers() {
        return vers;
    }

    public void setVers(String vers) {
        this.vers = vers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysTalon sysTalon = (SysTalon) o;

        if (id != sysTalon.id) return false;
        if (version != sysTalon.version) return false;
        if (fdate != null ? !fdate.equals(sysTalon.fdate) : sysTalon.fdate != null) return false;
        if (ftime != null ? !ftime.equals(sysTalon.ftime) : sysTalon.ftime != null) return false;
        if (npart != null ? !npart.equals(sysTalon.npart) : sysTalon.npart != null) return false;
        if (parts != null ? !parts.equals(sysTalon.parts) : sysTalon.parts != null) return false;
        if (person != null ? !person.equals(sysTalon.person) : sysTalon.person != null) return false;
        if (rhdBgyear != null ? !rhdBgyear.equals(sysTalon.rhdBgyear) : sysTalon.rhdBgyear != null) return false;
        if (rhdFilial != null ? !rhdFilial.equals(sysTalon.rhdFilial) : sysTalon.rhdFilial != null) return false;
        if (rhdOkato != null ? !rhdOkato.equals(sysTalon.rhdOkato) : sysTalon.rhdOkato != null) return false;
        if (rhdRegion != null ? !rhdRegion.equals(sysTalon.rhdRegion) : sysTalon.rhdRegion != null) return false;
        if (rhdSchema != null ? !rhdSchema.equals(sysTalon.rhdSchema) : sysTalon.rhdSchema != null) return false;
        if (rhdUser != null ? !rhdUser.equals(sysTalon.rhdUser) : sysTalon.rhdUser != null) return false;
        if (sysCreated != null ? !sysCreated.equals(sysTalon.sysCreated) : sysTalon.sysCreated != null) return false;
        if (sysId != null ? !sysId.equals(sysTalon.sysId) : sysTalon.sysId != null) return false;
        if (sysStatus != null ? !sysStatus.equals(sysTalon.sysStatus) : sysTalon.sysStatus != null) return false;
        if (sysUpdated != null ? !sysUpdated.equals(sysTalon.sysUpdated) : sysTalon.sysUpdated != null) return false;
        if (tdate != null ? !tdate.equals(sysTalon.tdate) : sysTalon.tdate != null) return false;
        if (ttime != null ? !ttime.equals(sysTalon.ttime) : sysTalon.ttime != null) return false;
        if (txtFilial != null ? !txtFilial.equals(sysTalon.txtFilial) : sysTalon.txtFilial != null) return false;
        if (txtSchema != null ? !txtSchema.equals(sysTalon.txtSchema) : sysTalon.txtSchema != null) return false;
        if (vdate != null ? !vdate.equals(sysTalon.vdate) : sysTalon.vdate != null) return false;
        if (vers != null ? !vers.equals(sysTalon.vers) : sysTalon.vers != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (version ^ (version >>> 32));
        result = 31 * result + (fdate != null ? fdate.hashCode() : 0);
        result = 31 * result + (ftime != null ? ftime.hashCode() : 0);
        result = 31 * result + (npart != null ? npart.hashCode() : 0);
        result = 31 * result + (parts != null ? parts.hashCode() : 0);
        result = 31 * result + (person != null ? person.hashCode() : 0);
        result = 31 * result + (rhdBgyear != null ? rhdBgyear.hashCode() : 0);
        result = 31 * result + (rhdFilial != null ? rhdFilial.hashCode() : 0);
        result = 31 * result + (rhdOkato != null ? rhdOkato.hashCode() : 0);
        result = 31 * result + (rhdRegion != null ? rhdRegion.hashCode() : 0);
        result = 31 * result + (rhdSchema != null ? rhdSchema.hashCode() : 0);
        result = 31 * result + (rhdUser != null ? rhdUser.hashCode() : 0);
        result = 31 * result + (sysCreated != null ? sysCreated.hashCode() : 0);
        result = 31 * result + (sysId != null ? sysId.hashCode() : 0);
        result = 31 * result + (sysStatus != null ? sysStatus.hashCode() : 0);
        result = 31 * result + (sysUpdated != null ? sysUpdated.hashCode() : 0);
        result = 31 * result + (tdate != null ? tdate.hashCode() : 0);
        result = 31 * result + (ttime != null ? ttime.hashCode() : 0);
        result = 31 * result + (txtFilial != null ? txtFilial.hashCode() : 0);
        result = 31 * result + (txtSchema != null ? txtSchema.hashCode() : 0);
        result = 31 * result + (vdate != null ? vdate.hashCode() : 0);
        result = 31 * result + (vers != null ? vers.hashCode() : 0);
        return result;
    }
}
