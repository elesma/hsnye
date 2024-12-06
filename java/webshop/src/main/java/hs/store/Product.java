package hs.store;

/**
 * Az osztály a termék adatait tartalmazza.
 */
public  class Product {
    /**
     * A termék neve.
     */
    private String productName;
    /**
     * A termék leírása.
     */
    private String description;
    /**
     * A termák ára.
     */
    private double price;

    /**
     *  Létrehoz egy új termák példányt a megadott paraméterekkel:
     *  A termék neve, leírása, ára.
     */
    public Product(String productName, String description, double price) {
        this.productName = productName;
        this.description = description;
        this.price = price;
}

    /**
     * Visszaadja a termék nevét.
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Beállítja a termék nevét.
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Visszaadja a termék leírását.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Beállítja a termék leírását.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Visszaadja a termék árát.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Beállítja a termék leírását.
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
