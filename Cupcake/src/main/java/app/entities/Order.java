package app.entities;

public class Order {
    private int orderId;
    private int antal;
    private double sum;
    private int userId;

    public Order(int orderId, int antal, double sum) {
        this.orderId = orderId;
        this.antal = antal;
        this.sum = sum;
    }
    public Order(int orderId, int antal, double sum, int userId) {
        this.orderId = orderId;
        this.antal = antal;
        this.sum = sum;
        this.userId = userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", antal=" + antal +
                ", sum=" + sum +
                ", userId=" + userId +
                '}';
    }
}

