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
import java.util.Date;

@Entity
@Table(name = "lgl_vacancy_history", schema = "public", catalog = "develop")
public class LglVacancyHistory {

    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Basic
    @Column(name = "version", nullable = false)
    private long version;

    @Basic
    @Column(name = "cur_need_no", nullable = true)
    private Integer curNeedNo;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "edit_date", nullable = true)
    private Date editDate;

    @Basic
    @Column(name = "job_no", nullable = true)
    private Integer jobNo;

    @Basic
    @Column(name = "job_send_no", nullable = true)
    private Integer jobSendNo;

    @Basic
    @Column(name = "send_no", nullable = true)
    private Integer sendNo;

    @Basic
    @Column(name = "szn_rec_id", nullable = true, length = 255)
    private String sznRecId;

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

    public Integer getCurNeedNo() {
        return curNeedNo;
    }

    public void setCurNeedNo(Integer curNeedNo) {
        this.curNeedNo = curNeedNo;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
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

    public Integer getSendNo() {
        return sendNo;
    }

    public void setSendNo(Integer sendNo) {
        this.sendNo = sendNo;
    }

    public String getSznRecId() {
        return sznRecId;
    }

    public void setSznRecId(String sznRecId) {
        this.sznRecId = sznRecId;
    }

    public SysTalon getSysTalon() {
        return sysTalon;
    }

    public void setSysTalon(SysTalon sysTalon) {
        this.sysTalon = sysTalon;
    }
}
