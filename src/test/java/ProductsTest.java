import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductsTest {
  private Products products;
  @BeforeEach
  void setUp() {
    this.products = new Products("KKD", "Joseph", 10.0, 14);
  }

  @Test
  void getManufacturer() {
    Assertions.assertEquals("KKD", products.getManufacturer());
  }

  @Test
  void getName() {
    Assertions.assertEquals("Joseph", products.getName());
  }

  @Test
  void getPrice() {
    Assertions.assertEquals(10.0, products.getPrice());
  }

  @Test
  void getMinimumAge() {
    Assertions.assertEquals(14, products.getMinimumAge());
  }

  @Test
  void setName() {
    products.setName("123");
    Assertions.assertEquals("123", products.getName());
  }

  @Test
  void setManufacturer() {
    products.setManufacturer("1234");
    Assertions.assertEquals("1234", products.getManufacturer());
  }

  @Test
  void setMinimumAge() {
    products.setMinimumAge(12);
    Assertions.assertEquals(12, products.getMinimumAge());
  }

  @Test
  void setPrice() {
    products.setPrice(12.0);
    Assertions.assertEquals(12.0, products.getPrice());
  }

  @Test
  void testEquals() {
    Products product1 = new Products("KKD", "Joseph", 100.0, 14);
    products = new Products("KKD", "Joseph", 100.0, 14);
    Assertions.assertTrue(products.equals(product1));
    Products product2 = new Products("KKDD", "Joseph", 100.0, 14);
    Assertions.assertFalse(products.equals(product2));
    Products product3 = new Products("KKD", "JosephD", 100.0, 14);
    Assertions.assertFalse(products.equals(product3));
    Products product4 = new Products("KKD", "Joseph", 1001.0, 14);
    Assertions.assertFalse(products.equals(product4));
    Products product5 = new Products("KKD", "Joseph", 100.0, 141);
    Assertions.assertFalse(products.equals(product5));
  }

  @Test
  void testHashCode() {
    int test = Objects.hash(products.getManufacturer(), products.getName(), products.getPrice(), products.getMinimumAge());
    Assertions.assertEquals(test, products.hashCode());
  }

  @Test
  void testToString() {
    String test = "Products{" +
        "Manufacturer='" + products.getManufacturer() + '\'' +
        ", Name='" + products.getName() + '\'' +
        ", Price=" + products.getPrice() +
        ", MinimumAge=" + products.getMinimumAge() +
        '}';
    Assertions.assertEquals(test, products.toString());
  }
}