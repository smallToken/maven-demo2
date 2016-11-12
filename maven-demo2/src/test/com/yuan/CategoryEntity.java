package test.com.yuan;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User:YuanXiaolei
 * Date:2016/11/12
 * Time:20:06
 */
@Entity
@Table(name = "category", schema = "test", catalog = "")
public class CategoryEntity {
    private int cid;
    private String cname;

    @Id
    @Column(name = "cid")
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "cname")
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryEntity that = (CategoryEntity) o;

        if (cid != that.cid) return false;
        if (cname != null ? !cname.equals(that.cname) : that.cname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cid;
        result = 31 * result + (cname != null ? cname.hashCode() : 0);
        return result;
    }
}
