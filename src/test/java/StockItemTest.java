import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StockItemTest {
  private StockItem stockItem;
  private Products products;
  @BeforeEach
  void setUp() {
    this.products = new Products("KKD", "Joseph", 10.0, 14);
    this.stockItem = new StockItem(products, 10);
  }

  @Test
  void getProduct() {
    Assertions.assertEquals(products, stockItem.getProduct());
  }

  @Test
  void getQuantity() {
    Assertions.assertEquals(10, stockItem.getQuantity());
  }

  @Test
  void setProduct() {
    Products product2 = new Products("KKD", "Joseph", 10.0, 14);
    stockItem.setProduct(product2);
    Assertions.assertEquals(product2, stockItem.getProduct());
  }

  @Test
  void setQuantity() {
    stockItem.setQuantity(20);
    Assertions.assertEquals(20, stockItem.getQuantity());
  }

  @Test
  void checkQuantity() {
    Assertions.assertTrue(stockItem.checkQuantity(0));
    Assertions.assertFalse(stockItem.checkQuantity(100));
  }

  @Test
  void testToString() {
    String test = "StockItem{" +
        "Product=" + stockItem.getProduct() +
        ", Quantity=" + stockItem.getQuantity() +
        '}';
    Assertions.assertEquals(test, stockItem.toString());
  }

  @Test
  void testEquals() {
    Products product1 = new Products("KKD", "Joseph", 100.0, 14);
    this.stockItem = new StockItem(product1, 10);
    StockItem stockItem1 = new StockItem(product1, 10);
    Assertions.assertTrue(stockItem.equals(stockItem1));
    Products product2 = new Products("KKDD", "Joseph", 100.0, 14);
    StockItem stockItem2 = new StockItem(product2, 10);
    Assertions.assertFalse(stockItem.equals(stockItem2));
    Products product3 = new Products("KKD", "JosephD", 100.0, 14);
    StockItem stockItem3 = new StockItem(product3, 10);
    Assertions.assertFalse(stockItem.equals(stockItem3));
    Products product4 = new Products("KKD", "Joseph", 1001.0, 14);
    StockItem stockItem4 = new StockItem(product4, 10);
    Assertions.assertFalse(stockItem.equals(stockItem4));
    Products product5 = new Products("KKD", "Joseph", 100.0, 141);
    StockItem stockItem5 = new StockItem(product5, 10);
    Assertions.assertFalse(stockItem.equals(stockItem5));
    StockItem stockItem6 = new StockItem(product1, 100);
    Assertions.assertFalse(stockItem.equals(stockItem6));
  }

  @Test
  void testHashCode() {
    int test = Objects.hash(stockItem.getProduct(), stockItem.getQuantity());
    Assertions.assertEquals(test, stockItem.hashCode());
  }
}