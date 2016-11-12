package test.com.yuan;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User:YuanXiaolei
 * Date:2016/11/12
 * Time:20:06
 */
@Entity
@Table(name = "orderitem", schema = "test", catalog = "")
public class OrderitemEntity {
    private int itemid;
    private Integer count;
    private Double subtotal;

    @Id
    @Column(name = "itemid")
    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    @Basic
    @Column(name = "count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Basic
    @Column(name = "subtotal")
    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderitemEntity that = (OrderitemEntity) o;

        if (itemid != that.itemid) return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;
        if (subtotal != null ? !subtotal.equals(that.subtotal) : that.subtotal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = itemid;
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (subtotal != null ? subtotal.hashCode() : 0);
        return result;
    }
}
