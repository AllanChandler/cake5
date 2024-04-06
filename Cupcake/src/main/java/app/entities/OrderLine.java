package app.entities;

public class OrderLine {
    private int orderLineId;
    private int antal;
    private int price;
    private int toppingId;
    private int bundId;
    private int orderId;

    // Constructor
    public OrderLine(int orderLineId, int antal, int price, int toppingId, int bundId, int orderId) {
        this.orderLineId = orderLineId;
        this.antal = antal;
        this.price = price;
        this.toppingId = toppingId;
        this.bundId = bundId;
        this.orderId = orderId;
    }

    // Getter and setter methods
    public int getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(int orderLineId) {
        this.orderLineId = orderLineId;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getToppingId() {
        return toppingId;
    }

    public void setToppingId(int toppingId) {
        this.toppingId = toppingId;
    }

    public int getBundId() {
        return bundId;
    }

    public void setBundId(int bundId) {
        this.bundId = bundId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String toString() {
        return "OrderLine{" +
                "orderLineId=" + orderLineId +
                ", antal=" + antal +
                ", price=" + price +
                ", toppingId=" + toppingId +
                ", bundId=" + bundId +
                ", orderId=" + orderId +
                '}';

    }
}
