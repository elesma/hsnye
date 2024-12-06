package hs.productOrder;


import hs.store.Product;

public class CartItem { /** A kosárban található terméket és mennyiségét kezeli **/
private Product product; /** A kosár tételének mennyisége **/
private int quantity; /** A tétel mennyiségét tárolja **/

public CartItem(Product product, int quantity) {
    this.product = product;
    this.quantity = quantity;
}

    /** Getter és setter metódus a termék eléréséhez és beállításához **/
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    /** Getter és setter metódus a mennyiség eléréséhez és beállításához **/
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /** Metódus a tétel összértékének kiszámításához**/
    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
}