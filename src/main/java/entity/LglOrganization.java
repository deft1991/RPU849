package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "lgl_organization", schema = "public", catalog = "develop")
public class LglOrganization {
    private long id;
    private long version;
    private String abbrName;
    private Date certDate;
    private String certNum;
    private String certSeria;
    private String email;
    private String fax;
    private String firmName;
    private String fullName;
    private String grn;
    private String inn;
    private Boolean signCityForming;
    private Boolean isEgrip;
    private Boolean isEgrul;
    private Boolean isLocal;
    private String kpp;
    private String ogrn;
    private Date ogrnDate;
    private String okogu;
    private String okpo;
    private String oktmo;
    private String path;
    private String phone;
    private String reestrCode;
    private Date regDate;
    private String separUlCode;
    private Date setDate;
    private String shortName;
    private String sznRecId;
    private String web;
    private String sysId;
    private Long quotedInvWpCount;
    private Long occupiedInvWpCount;

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
    @Column(name = "abbr_name", nullable = true, length = 500)
    public String getAbbrName() {
        return abbrName;
    }

    public void setAbbrName(String abbrName) {
        this.abbrName = abbrName;
    }

    @Basic
    @Column(name = "cert_date", nullable = true)
    public Date getCertDate() {
        return certDate;
    }

    public void setCertDate(Date certDate) {
        this.certDate = certDate;
    }

    @Basic
    @Column(name = "cert_num", nullable = true, length = 9)
    public String getCertNum() {
        return certNum;
    }

    public void setCertNum(String certNum) {
        this.certNum = certNum;
    }

    @Basic
    @Column(name = "cert_seria", nullable = true, length = 2)
    public String getCertSeria() {
        return certSeria;
    }

    public void setCertSeria(String certSeria) {
        this.certSeria = certSeria;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 250)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "fax", nullable = true, length = 350)
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Basic
    @Column(name = "firm_name", nullable = true, length = 500)
    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    @Basic
    @Column(name = "full_name", nullable = true, length = 1000)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "grn", nullable = true, length = 13)
    public String getGrn() {
        return grn;
    }

    public void setGrn(String grn) {
        this.grn = grn;
    }

    @Basic
    @Column(name = "inn", nullable = true, length = 12)
    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    @Basic
    @Column(name = "sign_city_forming", nullable = true)
    public Boolean getSignCityForming() {
        return signCityForming;
    }

    public void setSignCityForming(Boolean signCityForming) {
        this.signCityForming = signCityForming;
    }

    @Basic
    @Column(name = "is_egrip", nullable = true)
    public Boolean getEgrip() {
        return isEgrip;
    }

    public void setEgrip(Boolean egrip) {
        isEgrip = egrip;
    }

    @Basic
    @Column(name = "is_egrul", nullable = true)
    public Boolean getEgrul() {
        return isEgrul;
    }

    public void setEgrul(Boolean egrul) {
        isEgrul = egrul;
    }

    @Basic
    @Column(name = "is_local", nullable = true)
    public Boolean getLocal() {
        return isLocal;
    }

    public void setLocal(Boolean local) {
        isLocal = local;
    }

    @Basic
    @Column(name = "kpp", nullable = true, length = 9)
    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    @Basic
    @Column(name = "ogrn", nullable = true, length = 15)
    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    @Basic
    @Column(name = "ogrn_date", nullable = true)
    public Date getOgrnDate() {
        return ogrnDate;
    }

    public void setOgrnDate(Date ogrnDate) {
        this.ogrnDate = ogrnDate;
    }

    @Basic
    @Column(name = "okogu", nullable = true, length = -1)
    public String getOkogu() {
        return okogu;
    }

    public void setOkogu(String okogu) {
        this.okogu = okogu;
    }

    @Basic
    @Column(name = "okpo", nullable = true, length = 10)
    public String getOkpo() {
        return okpo;
    }

    public void setOkpo(String okpo) {
        this.okpo = okpo;
    }

    @Basic
    @Column(name = "oktmo", nullable = true, length = 11)
    public String getOktmo() {
        return oktmo;
    }

    public void setOktmo(String oktmo) {
        this.oktmo = oktmo;
    }

    @Basic
    @Column(name = "path", nullable = true, length = 2000)
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 250)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "reestr_code", nullable = true, length = 9)
    public String getReestrCode() {
        return reestrCode;
    }

    public void setReestrCode(String reestrCode) {
        this.reestrCode = reestrCode;
    }

    @Basic
    @Column(name = "reg_date", nullable = true)
    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    @Basic
    @Column(name = "separ_ul_code", nullable = true, length = 9)
    public String getSeparUlCode() {
        return separUlCode;
    }

    public void setSeparUlCode(String separUlCode) {
        this.separUlCode = separUlCode;
    }

    @Basic
    @Column(name = "set_date", nullable = true)
    public Date getSetDate() {
        return setDate;
    }

    public void setSetDate(Date setDate) {
        this.setDate = setDate;
    }

    @Basic
    @Column(name = "short_name", nullable = true, length = 160)
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Basic
    @Column(name = "szn_rec_id", nullable = true, length = 255)
    public String getSznRecId() {
        return sznRecId;
    }

    public void setSznRecId(String sznRecId) {
        this.sznRecId = sznRecId;
    }

    @Basic
    @Column(name = "web", nullable = true, length = 250)
    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
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
    @Column(name = "quoted_inv_wp_count", nullable = true)
    public Long getQuotedInvWpCount() {
        return quotedInvWpCount;
    }

    public void setQuotedInvWpCount(Long quotedInvWpCount) {
        this.quotedInvWpCount = quotedInvWpCount;
    }

    @Basic
    @Column(name = "occupied_inv_wp_count", nullable = true)
    public Long getOccupiedInvWpCount() {
        return occupiedInvWpCount;
    }

    public void setOccupiedInvWpCount(Long occupiedInvWpCount) {
        this.occupiedInvWpCount = occupiedInvWpCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LglOrganization that = (LglOrganization) o;

        if (id != that.id) return false;
        if (version != that.version) return false;
        if (abbrName != null ? !abbrName.equals(that.abbrName) : that.abbrName != null) return false;
        if (certDate != null ? !certDate.equals(that.certDate) : that.certDate != null) return false;
        if (certNum != null ? !certNum.equals(that.certNum) : that.certNum != null) return false;
        if (certSeria != null ? !certSeria.equals(that.certSeria) : that.certSeria != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (fax != null ? !fax.equals(that.fax) : that.fax != null) return false;
        if (firmName != null ? !firmName.equals(that.firmName) : that.firmName != null) return false;
        if (fullName != null ? !fullName.equals(that.fullName) : that.fullName != null) return false;
        if (grn != null ? !grn.equals(that.grn) : that.grn != null) return false;
        if (inn != null ? !inn.equals(that.inn) : that.inn != null) return false;
        if (signCityForming != null ? !signCityForming.equals(that.signCityForming) : that.signCityForming != null)
            return false;
        if (isEgrip != null ? !isEgrip.equals(that.isEgrip) : that.isEgrip != null) return false;
        if (isEgrul != null ? !isEgrul.equals(that.isEgrul) : that.isEgrul != null) return false;
        if (isLocal != null ? !isLocal.equals(that.isLocal) : that.isLocal != null) return false;
        if (kpp != null ? !kpp.equals(that.kpp) : that.kpp != null) return false;
        if (ogrn != null ? !ogrn.equals(that.ogrn) : that.ogrn != null) return false;
        if (ogrnDate != null ? !ogrnDate.equals(that.ogrnDate) : that.ogrnDate != null) return false;
        if (okogu != null ? !okogu.equals(that.okogu) : that.okogu != null) return false;
        if (okpo != null ? !okpo.equals(that.okpo) : that.okpo != null) return false;
        if (oktmo != null ? !oktmo.equals(that.oktmo) : that.oktmo != null) return false;
        if (path != null ? !path.equals(that.path) : that.path != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (reestrCode != null ? !reestrCode.equals(that.reestrCode) : that.reestrCode != null) return false;
        if (regDate != null ? !regDate.equals(that.regDate) : that.regDate != null) return false;
        if (separUlCode != null ? !separUlCode.equals(that.separUlCode) : that.separUlCode != null) return false;
        if (setDate != null ? !setDate.equals(that.setDate) : that.setDate != null) return false;
        if (shortName != null ? !shortName.equals(that.shortName) : that.shortName != null) return false;
        if (sznRecId != null ? !sznRecId.equals(that.sznRecId) : that.sznRecId != null) return false;
        if (web != null ? !web.equals(that.web) : that.web != null) return false;
        if (sysId != null ? !sysId.equals(that.sysId) : that.sysId != null) return false;
        if (quotedInvWpCount != null ? !quotedInvWpCount.equals(that.quotedInvWpCount) : that.quotedInvWpCount != null)
            return false;
        if (occupiedInvWpCount != null ? !occupiedInvWpCount.equals(that.occupiedInvWpCount) : that.occupiedInvWpCount != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (version ^ (version >>> 32));
        result = 31 * result + (abbrName != null ? abbrName.hashCode() : 0);
        result = 31 * result + (certDate != null ? certDate.hashCode() : 0);
        result = 31 * result + (certNum != null ? certNum.hashCode() : 0);
        result = 31 * result + (certSeria != null ? certSeria.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        result = 31 * result + (firmName != null ? firmName.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (grn != null ? grn.hashCode() : 0);
        result = 31 * result + (inn != null ? inn.hashCode() : 0);
        result = 31 * result + (signCityForming != null ? signCityForming.hashCode() : 0);
        result = 31 * result + (isEgrip != null ? isEgrip.hashCode() : 0);
        result = 31 * result + (isEgrul != null ? isEgrul.hashCode() : 0);
        result = 31 * result + (isLocal != null ? isLocal.hashCode() : 0);
        result = 31 * result + (kpp != null ? kpp.hashCode() : 0);
        result = 31 * result + (ogrn != null ? ogrn.hashCode() : 0);
        result = 31 * result + (ogrnDate != null ? ogrnDate.hashCode() : 0);
        result = 31 * result + (okogu != null ? okogu.hashCode() : 0);
        result = 31 * result + (okpo != null ? okpo.hashCode() : 0);
        result = 31 * result + (oktmo != null ? oktmo.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (reestrCode != null ? reestrCode.hashCode() : 0);
        result = 31 * result + (regDate != null ? regDate.hashCode() : 0);
        result = 31 * result + (separUlCode != null ? separUlCode.hashCode() : 0);
        result = 31 * result + (setDate != null ? setDate.hashCode() : 0);
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + (sznRecId != null ? sznRecId.hashCode() : 0);
        result = 31 * result + (web != null ? web.hashCode() : 0);
        result = 31 * result + (sysId != null ? sysId.hashCode() : 0);
        result = 31 * result + (quotedInvWpCount != null ? quotedInvWpCount.hashCode() : 0);
        result = 31 * result + (occupiedInvWpCount != null ? occupiedInvWpCount.hashCode() : 0);
        return result;
    }
}
