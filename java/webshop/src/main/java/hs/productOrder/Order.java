package hs.productOrder;

import java.util.List;

/**
 * Tárolja a rendelés azonosítóját, tételeit és az összeget
 */

public class Order {
private Long orderId;
    private List<CartItem> items;
    private double totalAmount;

    public Order(Long orderId, List<CartItem> items) {
        this.orderId = orderId;
        this.items = items;
        this.totalAmount = calculateTotalAmount();
    }

    /** Összeg kiszámítása **/
    private double calculateTotalAmount() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
