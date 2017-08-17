package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ref_dict_line", schema = "public", catalog = "develop")
public class RefDictLine {

    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Basic
    @Column(name = "version", nullable = false)
    private long version;

    @Basic
    @Column(name = "code", nullable = true, length = 100)
    private String code;

    @Basic
    @Column(name = "name", nullable = true, length = 500)
    private String name;

    @Basic
    @Column(name = "parent", nullable = true)
    private Long parent;

    @Basic
    @Column(name = "ordinal", nullable = true)
    private Long ordinal;

    @ManyToOne(targetEntity = RefDict.class)
    @JoinColumn(name = "dict_id", insertable = false, updatable = false)
    private RefDict prkzCode;

    @ManyToOne(targetEntity = RefDict.class)
    @JoinColumn(name = "dict_id", insertable = false, updatable = false)
    private RefDict statusCode;

    @ManyToOne(targetEntity = RefDict.class)
    @JoinColumn(name = "dict_id", insertable = false, updatable = false)
    private RefDict puvCode;

    public RefDict getPuvCode() {
        return puvCode;
    }

    public void setPuvCode(RefDict puvCode) {
        this.puvCode = puvCode;
    }

    public RefDict getPrkzCode() {
        return prkzCode;
    }

    public void setPrkzCode(RefDict prkzCode) {
        this.prkzCode = prkzCode;
    }

    public RefDict getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(RefDict statusCode) {
        this.statusCode = statusCode;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public Long getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Long ordinal) {
        this.ordinal = ordinal;
    }
}
