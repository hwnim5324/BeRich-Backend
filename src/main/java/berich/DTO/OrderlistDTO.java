package berich.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name="orderlist")
public class OrderlistDTO {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userCode;
    private int stock;
    private Date date;
    private int buyprice;
    private int sellprice;
    private int hold;

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getBuyprice() {
        return buyprice;
    }

    public void setBuyprice(int buyprice) {
        this.buyprice = buyprice;
    }

    public int getSellprice() {
        return sellprice;
    }

    public void setSellprice(int sellprice) {
        this.sellprice = sellprice;
    }

    public int getHold() {
        return hold;
    }

    public void setHold(int hold) {
        this.hold = hold;
    }
}
