package hs.productOrder;

import hs.store.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A rendelés osztály  tesztelésére szolgáló osztály.
 */
public class OrderTest {
    private Order order;
    private List<CartItem> items;
    private Product product1;
    private Product product2;

    /**
     * Inicializálja a teszteléshez szükséges objektumokat.
     * Minden teszt előtt lefut.
     */
    @BeforeEach
    public void setUp() {
        product1 = new Product("Product1", "Description1", 10.0);
        product2 = new Product("Product2", "Description2", 20.0);

        /**
         * Létrehozunk CartItem példányokat.
         */
        CartItem item1 = new CartItem(product1, 2);
        CartItem item2 = new CartItem(product2, 1);

        /**
         * Hozzáadjuk a CartItemeket egy listához.
         */
        items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

/**
 * Létrehozzuk az Order példányt.
 */
        order = new Order(1L, items);
    }

    /**
     * Ellenőrzi, hogy a rendelés azonosítója helyesen van beállítva.
     */
    @Test
    public void testOrder() {
        assertEquals(1L, order.getOrderId());
    }
}


