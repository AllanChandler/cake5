package app.entities;

public class Bund {

    private int bundId;
    private String bundName;
    private double bundPrice;

    public Bund(int bundId, String bundName, double bundPrice) {
        this.bundId = bundId;
        this.bundName = bundName;
        this.bundPrice = bundPrice;
    }

    public int getBundId() {
        return bundId;
    }
    public void setBundId(int bundId) {
        this.bundId = bundId;
    }
    public String getBundName() {
        return bundName;
    }

    public void setBundName(String bundName) {
        this.bundName = bundName;
    }

    public double getBundPrice() {
        return bundPrice;
    }

    public void setBundPrice(double bundPrice) {
        this.bundPrice = bundPrice;
    }

    public String toString() {
        return "Bund{" +
                ", bundId=" + bundId + '\'' +
                ", bundName='" + bundName + '\'' +
                ", bundPrice=" + bundPrice +
                '}';
    }

}
