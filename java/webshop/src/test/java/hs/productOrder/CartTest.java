package hs.productOrder;
import hs.store.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest {
    private Cart cart;
    private Product product1;
    private Product product2;

    @BeforeEach
    public void setUp() {
        cart = new Cart();
        product1 = new Product("Product1", "Description", 10.0);
        product2 = new Product("Product2", "Description", 20.0);
    }

    @Test
    public void testAddItem() {
        // Given
        int quantityToAdd = 2;

        // When
        cart.addItem(product1, quantityToAdd);

        //Then
        List<CartItem> items = cart.getItems();
        assertEquals(1, items.size());
        assertEquals(2, items.get(0).getQuantity());
        assertEquals(20.0, cart.getTotalPrice(), 0.01);
    }

    @Test
    public void testRemoveItem() {
        //Given
        cart.addItem(product1, 2);
        cart.addItem(product2, 1);

        // When
        cart.removeItem(product1);

        // Then
        List<CartItem> items = cart.getItems();
        assertEquals(1, items.size());
        assertEquals(20.0, cart.getTotalPrice(), 0.01);
    }

    @Test
    public void testGetTotalPrice() {
        // Given
        cart.addItem(product1, 2);
        cart.addItem(product2, 1);

        // When
        double totalPrice = cart.getTotalPrice();

        // Then
        assertEquals(40.0, totalPrice, 0.01);
    }
}
