package test.com.yuan;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by IntelliJ IDEA.
 * User:YuanXiaolei
 * Date:2016/11/12
 * Time:20:06
 */
@Entity
@Table(name = "orders", schema = "test", catalog = "")
public class OrdersEntity {
    private int oid;
    private Double total;
    private Timestamp ordertime;
    private Integer state;
    private String name;
    private String phone;
    private String addr;

    @Id
    @Column(name = "oid")
    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    @Basic
    @Column(name = "total")
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Basic
    @Column(name = "ordertime")
    public Timestamp getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Timestamp ordertime) {
        this.ordertime = ordertime;
    }

    @Basic
    @Column(name = "state")
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "addr")
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersEntity that = (OrdersEntity) o;

        if (oid != that.oid) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;
        if (ordertime != null ? !ordertime.equals(that.ordertime) : that.ordertime != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (addr != null ? !addr.equals(that.addr) : that.addr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = oid;
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (ordertime != null ? ordertime.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (addr != null ? addr.hashCode() : 0);
        return result;
    }
}
