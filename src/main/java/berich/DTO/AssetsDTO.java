package berich.DTO;

import org.json.simple.JSONArray;

import javax.persistence.*;

@Entity(name="assets")
public class AssetsDTO {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usercode;

    @Column(name = "`deposit`")
    private int deposit;

    @Column(name = "`stocks`")
    private String stocks;

    public int getUserCode() {
        return usercode;
    }

    public void setUserCode(int userCode) {
        this.usercode = userCode;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public String getStocks() {
        return stocks;
    }

    public void setStocks(String stocks) {
        this.stocks = stocks;
    }
}
