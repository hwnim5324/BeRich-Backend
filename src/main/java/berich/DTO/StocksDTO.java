package berich.DTO;

public class StocksDTO {
    private int Stock;
    private int HGPR;   //고가
    private int LWPR;   //저가
    private int OPRC;   //시가
    private int CLPR;   //종가

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public int getHGPR() {
        return HGPR;
    }

    public void setHGPR(int HGPR) {
        this.HGPR = HGPR;
    }

    public int getLWPR() {
        return LWPR;
    }

    public void setLWPR(int LWPR) {
        this.LWPR = LWPR;
    }

    public int getOPRC() {
        return OPRC;
    }

    public void setOPRC(int OPRC) {
        this.OPRC = OPRC;
    }

    public int getCLPR() {
        return CLPR;
    }

    public void setCLPR(int CLPR) {
        this.CLPR = CLPR;
    }
}
