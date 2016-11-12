package test.com.yuan;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User:YuanXiaolei
 * Date:2016/11/12
 * Time:20:06
 */
@Entity
@Table(name = "categorysecond", schema = "test", catalog = "")
public class CategorysecondEntity {
    private int csid;
    private String csname;

    @Id
    @Column(name = "csid")
    public int getCsid() {
        return csid;
    }

    public void setCsid(int csid) {
        this.csid = csid;
    }

    @Basic
    @Column(name = "csname")
    public String getCsname() {
        return csname;
    }

    public void setCsname(String csname) {
        this.csname = csname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategorysecondEntity that = (CategorysecondEntity) o;

        if (csid != that.csid) return false;
        if (csname != null ? !csname.equals(that.csname) : that.csname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = csid;
        result = 31 * result + (csname != null ? csname.hashCode() : 0);
        return result;
    }
}
