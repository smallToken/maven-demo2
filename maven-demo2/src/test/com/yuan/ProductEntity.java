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
@Table(name = "product", schema = "test", catalog = "")
public class ProductEntity {
    private int pid;
    private String pname;
    private Double marketPrice;
    private Double shopPrice;
    private String image;
    private String pdesc;
    private Integer isHot;
    private Timestamp pdate;

    @Id
    @Column(name = "pid")
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "pname")
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Basic
    @Column(name = "market_price")
    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    @Basic
    @Column(name = "shop_price")
    public Double getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(Double shopPrice) {
        this.shopPrice = shopPrice;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "pdesc")
    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    @Basic
    @Column(name = "is_hot")
    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    @Basic
    @Column(name = "pdate")
    public Timestamp getPdate() {
        return pdate;
    }

    public void setPdate(Timestamp pdate) {
        this.pdate = pdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductEntity that = (ProductEntity) o;

        if (pid != that.pid) return false;
        if (pname != null ? !pname.equals(that.pname) : that.pname != null) return false;
        if (marketPrice != null ? !marketPrice.equals(that.marketPrice) : that.marketPrice != null) return false;
        if (shopPrice != null ? !shopPrice.equals(that.shopPrice) : that.shopPrice != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (pdesc != null ? !pdesc.equals(that.pdesc) : that.pdesc != null) return false;
        if (isHot != null ? !isHot.equals(that.isHot) : that.isHot != null) return false;
        if (pdate != null ? !pdate.equals(that.pdate) : that.pdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pid;
        result = 31 * result + (pname != null ? pname.hashCode() : 0);
        result = 31 * result + (marketPrice != null ? marketPrice.hashCode() : 0);
        result = 31 * result + (shopPrice != null ? shopPrice.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (pdesc != null ? pdesc.hashCode() : 0);
        result = 31 * result + (isHot != null ? isHot.hashCode() : 0);
        result = 31 * result + (pdate != null ? pdate.hashCode() : 0);
        return result;
    }
}
