import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShoppingCartTest {
  private ShoppingCart shoppingCart;
  @BeforeEach
  void setUp() {
    this.shoppingCart = new ShoppingCart();
  }

  @Test
  void setCart() {
    Map<Products, Integer> cart = new HashMap<>();
    Products product1 = new Products("KKD", "Joseph", 100.0, 14);
    cart.put(product1, 10);
    shoppingCart.setCart(cart);
    Assertions.assertEquals(cart, shoppingCart.getCart());
  }

  @Test
  void getCart() {
    Map<Products, Integer> cart = new HashMap<>();
    Products product1 = new Products("KKD", "Joseph", 100.0, 14);
    cart.put(product1, 10);
    shoppingCart.setCart(cart);
    Assertions.assertEquals(cart, shoppingCart.getCart());
  }

  @Test
  void getTotalPrice() {
    Assertions.assertEquals(0, shoppingCart.getTotalPrice());
  }

  @Test
  void setTotalPrice() {
    shoppingCart.setTotalPrice(100.0);
    Assertions.assertEquals(100.0, shoppingCart.getTotalPrice());
  }


  @Test
  void testToString() {
    String test = "ShoppingCart{" +
        "cart=" + shoppingCart.getCart() +
        ", totalPrice=" + shoppingCart.getTotalPrice() +
        '}';
    Assertions.assertEquals(test, shoppingCart.toString());
  }

  @Test
  void testEquals() {
    Map<Products, Integer> cart = new HashMap<>();
    Products product1 = new Products("KKD", "Joseph", 100.0, 14);
    cart.put(product1, 10);

    ShoppingCart shoppingCart1 = new ShoppingCart();
    ShoppingCart shoppingCart2 = new ShoppingCart();
    shoppingCart1.setCart(cart);
    shoppingCart2.setCart(cart);

    Assertions.assertTrue(shoppingCart1.equals(shoppingCart2));
    ShoppingCart shoppingCart3 = new ShoppingCart();
    Assertions.assertFalse(shoppingCart1.equals(shoppingCart3));
  }

  @Test
  void testHashCode() {
    int test = Objects.hash(shoppingCart.getCart(), shoppingCart.getTotalPrice());
    Assertions.assertEquals(test, shoppingCart.hashCode());
  }

  @Test
  void addItem() {
    Beer beer = new Beer("KKD", "Joseph", 10.0, 14, 100.0);
    PaperTowels paperTowels = new PaperTowels("KKD", "Joseph", 10.0, 14, 10);
    StockItem beerr = new StockItem(beer, 10);
    StockItem paperTowelss = new StockItem(paperTowels, 10);
    Map<Grocery, StockItem> groceryStock = new HashMap<>();
    Map<Household, StockItem> householdStock = new HashMap<>();
    groceryStock.put(beer, beerr);
    householdStock.put(paperTowels, paperTowelss);
    Inventory inventory = new Inventory(groceryStock, householdStock);

    Assertions.assertTrue(shoppingCart.addItem(beer, 10, inventory));
    Assertions.assertFalse(shoppingCart.addItem(beer, 100, inventory));
    Assertions.assertTrue(shoppingCart.addItem(paperTowels, 10, inventory));
    Assertions.assertFalse(shoppingCart.addItem(paperTowels, 100, inventory));

  }

  @Test
  void deleteItem() {
    Products product1 = new Products("KKD", "Joseph", 100.0, 14);
    Products product2 = new Products("KKD", "Joseph", 100.0, 140);
    shoppingCart.getCart().put(product1, 100);
    shoppingCart.getCart().put(product2, 100);
    shoppingCart.deleteItem(product1);
    Assertions.assertFalse(shoppingCart.getCart().containsKey(product1));
  }

  @Test
  void emptyCart() {
    shoppingCart.emptyCart();
    Assertions.assertTrue(shoppingCart.getCart().size() == 0);
    Assertions.assertTrue(shoppingCart.getTotalPrice() == 0.0);
  }

  @Test
  void calculatePrice() {
    Products product1 = new Products("KKD", "Joseph", 1.0, 14);
    Products product2 = new Products("KKD", "Joseph", 1.0, 140);
    shoppingCart.getCart().put(product1, 100);
    shoppingCart.getCart().put(product2, 100);
    shoppingCart.calculatePrice();
    Assertions.assertEquals(200.0, shoppingCart.getTotalPrice());
  }
}