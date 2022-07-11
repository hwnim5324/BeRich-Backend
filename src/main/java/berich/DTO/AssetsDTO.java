package berich.DTO;

import org.json.simple.JSONArray;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="assets")
public class AssetsDTO {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usercode;
    private int deposit;
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
