package berich.DTO;

import org.json.simple.JSONArray;

public class AssetsDTO {
    private int userCode;
    private int cash;
    private JSONArray holdList = new JSONArray();

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public JSONArray getHoldList() {
        return holdList;
    }

    public void setHoldList(JSONArray holdList) {
        this.holdList = holdList;
    }
}
