package hs.productOrder;

import hs.store.Product;
import java.util.ArrayList;
import java.util.List;

public class Cart { /** Az osztály a kosár tételeit kezeli **/
private List<CartItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }
    /** Tétel hozzáadása a kosárhoz **/
    public void addItem(Product product, int quantity) {
        for (CartItem item : items) {
            if (item.getProduct().getProductName().equals(product.getProductName())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new CartItem(product, quantity));
    }

    /** Tétel eltávolítása a kosárból **/
    public void removeItem(Product product) {
        items.removeIf(item -> item.getProduct().getProductName().equals(product.getProductName()));
    }

    /** A kosár összértékének kiszámítása **/
    public double getTotalPrice() {
        double total = 0;
        for (CartItem item : items) {
            total = item.getTotalPrice();
        }
        return total;
    }


    public List<CartItem> getItems() {
        return items;
    }
}
