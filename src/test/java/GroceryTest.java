import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GroceryTest {
  private Grocery grocery;
  @BeforeEach
  void setUp() {
    this.grocery = new Grocery("KKD", "Joseph", 10.0, 14, 100.0);
  }

  @Test
  void getWeight() {
    Assertions.assertEquals(100.0, grocery.getWeight());
  }

  @Test
  void setWeight() {
    grocery.setWeight(200.0);
    Assertions.assertEquals(200.0, grocery.getWeight());
  }

  @Test
  void testToString() {
    Assertions.assertEquals("Grocery{Weight=100.0} Products{Manufacturer='KKD', Name='Joseph', Price=10.0, MinimumAge=14}", grocery.toString());
  }

  @Test
  void testEquals() {
    grocery = new Grocery("KKD", "Joseph", 10.0, 14, 100.0);
    Assertions.assertTrue(grocery.equals(grocery));
    Grocery grocery1 = new Grocery("KKD", "Joseph", 10.0, 14, 100.0);
    Assertions.assertTrue(grocery.equals(grocery1));
    Grocery grocery2 = new Grocery("KKDD", "Joseph", 10.0, 14, 100.0);
    Assertions.assertFalse(grocery.equals(grocery2));
    Grocery grocery3 = new Grocery("KKD", "JoseDph", 10.0, 14, 100.0);
    Assertions.assertFalse(grocery.equals(grocery3));
    Grocery grocery4 = new Grocery("KKD", "JosephD", 110.0, 14, 100.0);
    Assertions.assertFalse(grocery.equals(grocery4));
    Grocery grocery5 = new Grocery("KKD", "Joseph", 10.0, 114, 100.0);
    Assertions.assertFalse(grocery.equals(grocery5));
    Grocery grocery6 = new Grocery("KKD", "Joseph", 10.0, 14, 1001.0);
    Assertions.assertFalse(grocery.equals(grocery6));
  }

  @Test
  void testHashCode() {
    Assertions.assertEquals(1760108007, grocery.hashCode());
  }
}