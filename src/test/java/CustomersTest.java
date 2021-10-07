import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomersTest {
  private Customers customers;
  @BeforeEach
  void setUp() {
    customers = new Customers("KKD", 18);
    Map<Products, Integer> cart = new HashMap<>();
    Products product1 = new Products("KKD", "Joseph", 100.0, 14);
    cart.put(product1, 10);
    ShoppingCart shoppingCart = new ShoppingCart();
    shoppingCart.setCart(cart);
    customers.setShoppingCart(shoppingCart);
  }

  @Test
  void getShoppingCart() {
    Map<Products, Integer> cart = new HashMap<>();
    Products product1 = new Products("KKD", "Joseph", 100.0, 14);
    cart.put(product1, 10);
    ShoppingCart shoppingCart = new ShoppingCart();
    shoppingCart.setCart(cart);
    Assertions.assertEquals(shoppingCart, customers.getShoppingCart());
  }

  @Test
  void getAge() {
    Assertions.assertEquals(18, customers.getAge());
  }

  @Test
  void getName() {
    Assertions.assertEquals("KKD", customers.getName());
  }

  @Test
  void getReceipt() {
    Products product1 = new Products("KKD", "Joseph", 100.0, 14);
    List<Products> ageTest = new ArrayList<>();
    List<Products> outTest = new ArrayList<>();
    Map<Products, Integer> receiveTest = new HashMap<>();
    Double valueTest = 0.0;

    ageTest.add(product1);
    outTest.add(product1);
    receiveTest.put(product1, 10);

    Receipt receipt = new Receipt();
    receipt.setAgeRequire(ageTest);
    receipt.setOutOfStock(outTest);
    receipt.setReceived(receiveTest);

    customers.setReceipt(receipt);
    Receipt receipt2 = new Receipt();
    receipt2.setAgeRequire(ageTest);
    receipt2.setOutOfStock(outTest);
    receipt2.setReceived(receiveTest);
    Assertions.assertEquals(receipt2, customers.getReceipt());

  }

  @Test
  void setReceipt() {
    Products product1 = new Products("KKD", "Joseph", 100.0, 14);
    List<Products> ageTest = new ArrayList<>();
    List<Products> outTest = new ArrayList<>();
    Map<Products, Integer> receiveTest = new HashMap<>();
    Double valueTest = 0.0;

    ageTest.add(product1);
    outTest.add(product1);
    receiveTest.put(product1, 10);

    Receipt receipt = new Receipt();
    receipt.setAgeRequire(ageTest);
    receipt.setOutOfStock(outTest);
    receipt.setReceived(receiveTest);

    customers.setReceipt(receipt);
    Receipt receipt2 = new Receipt();
    receipt2.setAgeRequire(ageTest);
    receipt2.setOutOfStock(outTest);
    receipt2.setReceived(receiveTest);
    Assertions.assertEquals(receipt2, customers.getReceipt());
  }

  @Test
  void setName() {
    customers.setName("123");
    Assertions.assertEquals("123", customers.getName());
  }

  @Test
  void setAge() {
    customers.setAge(100);
    Assertions.assertEquals(100, customers.getAge());
  }

  @Test
  void setShoppingCart() {
    Map<Products, Integer> cart = new HashMap<>();
    Products product1 = new Products("KKD", "Joseph", 100.0, 14);
    cart.put(product1, 10);
    ShoppingCart shoppingCart = new ShoppingCart();
    shoppingCart.setCart(cart);
    Assertions.assertEquals(shoppingCart, customers.getShoppingCart());
  }

  @Test
  void testEquals() {
    customers = new Customers("KKD", 18);
    Assertions.assertTrue(customers.equals(customers));

    Map<Products, Integer> cart = new HashMap<>();
    Products product1 = new Products("KKD", "Joseph", 100.0, 14);
    cart.put(product1, 10);
    ShoppingCart shoppingCart = new ShoppingCart();
    shoppingCart.setCart(cart);
    customers.setShoppingCart(shoppingCart);
    List<Products> ageTest = new ArrayList<>();
    List<Products> outTest = new ArrayList<>();
    Map<Products, Integer> receiveTest = new HashMap<>();
    Double valueTest = 0.0;

    ageTest.add(product1);
    outTest.add(product1);
    receiveTest.put(product1, 10);

    Receipt receipt = new Receipt();
    receipt.setAgeRequire(ageTest);
    receipt.setOutOfStock(outTest);
    receipt.setReceived(receiveTest);

    customers.setReceipt(receipt);

    Customers customer1 = new Customers("123", 18);
    Customers customer2 = new Customers("KKD", 118);
    Assertions.assertFalse(customer1.equals(customers));
    Assertions.assertFalse(customers.equals(customer2));

    Customers customer3 = new Customers("KKD", 18);
    Customers customer4 = new Customers("KKD", 18);
    Customers customer5 = new Customers("KKD", 18);
    customer3.setShoppingCart(shoppingCart);
    customer4.setReceipt(receipt);
    Assertions.assertFalse(customers.equals(customer3));
    Assertions.assertFalse(customers.equals(customer4));

    customer5.setShoppingCart(shoppingCart);
    customer5.setReceipt(receipt);
    Assertions.assertTrue(customers.equals(customer5));
  }

  @Test
  void testHashCode() {
    Assertions.assertEquals(-2055852353, customers.hashCode());
  }

  @Test
  void testToString() {
    Assertions.assertEquals("Customers{Name='KKD', Age=18, ShoppingCart=ShoppingCart{cart={Products{Manufacturer='KKD', Name='Joseph', Price=100.0, MinimumAge=14}=10}, totalPrice=0.0}, Receipt=Receipt{TotalPrice=0.0, received={}, outOfStock=[], ageRequire=[]}}", customers.toString());
  }

  @Test
  void addItem() {
    Beer beer = new Beer("KKD", "Joseph", 10.0, 14, 100.0);
    Salmon salmon = new Salmon("KKD", "Joseph", 10.0, 14, 100.0);
    Beer beer2 = new Beer("KKD", "Joseph", 10.0, 14111, 100.0);
    PaperTowels paperTowels = new PaperTowels("KKD", "Joseph", 10.0, 14, 10);
    StockItem beerr = new StockItem(beer, 10);
    StockItem beerr2 = new StockItem(beer2, 10);
    StockItem paperTowelss = new StockItem(paperTowels, 10);
    Map<Grocery, StockItem> groceryStock = new HashMap<>();
    Map<Household, StockItem> householdStock = new HashMap<>();
    groceryStock.put(beer, beerr);
    groceryStock.put(beer2, beerr2);
    householdStock.put(paperTowels, paperTowelss);
    Inventory inventory = new Inventory(groceryStock, householdStock);

    Assertions.assertTrue(customers.addItem(beer, inventory));
    Assertions.assertFalse(customers.addItem(beer, 200, inventory));
    Assertions.assertTrue(customers.addItem(beer2, inventory));

  }

  @Test
  void testAddItem() {
    Beer beer = new Beer("KKD", "Joseph", 10.0, 14, 100.0);
    Beer beer2 = new Beer("KKD", "Joseph", 10.0, 14111, 100.0);
    PaperTowels paperTowels = new PaperTowels("KKD", "Joseph", 10.0, 14, 10);
    StockItem beerr = new StockItem(beer, 10);
    StockItem beerr2 = new StockItem(beer2, 10);
    StockItem paperTowelss = new StockItem(paperTowels, 10);
    Map<Grocery, StockItem> groceryStock = new HashMap<>();
    Map<Household, StockItem> householdStock = new HashMap<>();
    groceryStock.put(beer, beerr);
    groceryStock.put(beer2, beerr2);
    householdStock.put(paperTowels, paperTowelss);
    Inventory inventory = new Inventory(groceryStock, householdStock);

    Assertions.assertTrue(customers.addItem(beer, inventory));
    Assertions.assertFalse(customers.addItem(beer, 200, inventory));
    Assertions.assertTrue(customers.addItem(beer2, inventory));
  }

  @Test
  void checkOut() {
    customers = new Customers("KKD", 18);
    Beer beer = new Beer("KKD", "beer1", 10.0, 14, 100.0);
    Beer beer2 = new Beer("KKD", "beer2", 10.0, 14111, 100.0);

    PaperTowels paperTowels = new PaperTowels("KKD", "paper1", 10.0, 14, 10);
    StockItem beerr = new StockItem(beer, 10);
    StockItem beerr2 = new StockItem(beer2, 10);
    StockItem paperTowelss = new StockItem(paperTowels, 10);
    Map<Grocery, StockItem> groceryStock = new HashMap<>();
    Map<Household, StockItem> householdStock = new HashMap<>();
    groceryStock.put(beer, beerr);
    groceryStock.put(beer2, beerr2);
    householdStock.put(paperTowels, paperTowelss);
    Inventory inventory = new Inventory(groceryStock, householdStock);

    customers.addItem(beer2, inventory);
    customers.checkOut(inventory);
    Assertions.assertEquals(0.0, customers.getReceipt().getTotalPrice());

    Cheese cheese = new Cheese("KKD", "cheese1", 10.0, 1, 100.0);
    Cheese cheese2 = new Cheese("KKD", "cheese2", 10.0, 1, 100.0);
    Shampoo shampoo = new Shampoo("KKD", "shampoo1", 10.0, 14, 10);
    Shampoo shampoo2 = new Shampoo("KKD", "shampoo2", 10.0, 14, 10);
    StockItem ch1 = new StockItem(cheese, 10);
    StockItem ch2 = new StockItem(cheese2, 1);
    StockItem sh1 = new StockItem(shampoo, 10);
    StockItem sh2 = new StockItem(shampoo2, 1);
    groceryStock.put(cheese, ch1);
    groceryStock.put(cheese2, ch2);
    householdStock.put(shampoo, sh1);
    householdStock.put(shampoo2, sh2);
    inventory.setGroceryStock(groceryStock);
    inventory.setHouseholdStock(householdStock);

    customers.addItem(cheese, 5, inventory);
    customers.addItem(paperTowels, 5, inventory);
    customers.checkOut(inventory);
    Assertions.assertEquals(100.0, customers.getReceipt().getTotalPrice());
  }

  @Test
  void substitute() {
    customers = new Customers("KKD", 18);
    Beer beer = new Beer("KKD", "beer1", 10.0, 14, 100.0);
    Beer beer2 = new Beer("KKD", "beer2", 10.0, 14111, 100.0);

    PaperTowels paperTowels = new PaperTowels("KKD", "paper1", 10.0, 14, 10);
    StockItem beerr = new StockItem(beer, 10);
    StockItem beerr2 = new StockItem(beer2, 10);
    StockItem paperTowelss = new StockItem(paperTowels, 10);
    Map<Grocery, StockItem> groceryStock = new HashMap<>();
    Map<Household, StockItem> householdStock = new HashMap<>();
    groceryStock.put(beer, beerr);
    groceryStock.put(beer2, beerr2);
    householdStock.put(paperTowels, paperTowelss);
    Inventory inventory = new Inventory(groceryStock, householdStock);

    customers.addItem(beer2, inventory);
    customers.substitute(inventory);
    Assertions.assertFalse(customers.getShoppingCart().getCart().containsKey(beer2));
    Assertions.assertTrue(customers.getReceipt().getAgeRequire().contains(beer2));

    Cheese cheese = new Cheese("KKD", "cheese1", 10.0, 1, 100.0);
    Cheese cheese2 = new Cheese("KKD", "cheese2", 10.0, 1, 100.0);
    Shampoo shampoo = new Shampoo("KKD", "shampoo1", 10.0, 14, 10);
    Shampoo shampoo2 = new Shampoo("KKD", "shampoo2", 10.0, 14, 10);
    StockItem ch1 = new StockItem(cheese, 10);
    StockItem ch2 = new StockItem(cheese2, 1);
    StockItem sh1 = new StockItem(shampoo, 10);
    StockItem sh2 = new StockItem(shampoo2, 1);
    groceryStock.put(cheese, ch1);
    groceryStock.put(cheese2, ch2);
    householdStock.put(shampoo, sh1);
    householdStock.put(shampoo2, sh2);
    inventory.setGroceryStock(groceryStock);
    inventory.setHouseholdStock(householdStock);


    customers.addItem(cheese, 5, inventory);
    customers.addItem(paperTowels, 5, inventory);

    customers.substitute(inventory);
    Assertions.assertTrue(customers.getReceipt().getReceived().containsKey(cheese));
    Assertions.assertTrue(customers.getReceipt().getReceived().get(cheese) == 5);
    Assertions.assertTrue(customers.getShoppingCart().getCart().containsKey(cheese));
    Assertions.assertTrue(customers.getReceipt().getReceived().containsKey(paperTowels));
    Assertions.assertTrue(customers.getReceipt().getReceived().get(paperTowels) == 5);
    Assertions.assertTrue(customers.getShoppingCart().getCart().containsKey(paperTowels));
    Assertions.assertTrue(inventory.getGroceryStock().get(cheese).getQuantity() == 5);
    Assertions.assertTrue(inventory.getHouseholdStock().get(paperTowels).getQuantity() == 5);

    inventory.getGroceryStock().get(cheese).setQuantity(10);
    customers.addItem(cheese, 10, inventory);
    customers.addItem(paperTowels, 4, inventory);
    inventory.getGroceryStock().get(cheese).setQuantity(5);
    customers.substitute(inventory);
    Assertions.assertTrue(customers.getShoppingCart().getCart().containsKey(cheese));
    Assertions.assertTrue(customers.getShoppingCart().getCart().containsKey(cheese2));
    Assertions.assertTrue(customers.getShoppingCart().getCart().containsKey(paperTowels));
    Assertions.assertTrue(customers.getReceipt().getReceived().get(cheese) == 5);
    Assertions.assertTrue(customers.getReceipt().getReceived().get(cheese2) == 1);
    Assertions.assertTrue(customers.getReceipt().getOutOfStock().contains(cheese));
    Assertions.assertTrue(customers.getReceipt().getReceived().get(paperTowels) == 5);
  }
}