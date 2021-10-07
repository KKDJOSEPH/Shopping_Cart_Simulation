import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReceiptTest {
  private Receipt receipt;
  @BeforeEach
  void setUp() {
    receipt = new Receipt();
  }

  @Test
  void addReceivedItem() {
    Map<Products, Integer> received = new HashMap<>();
    Products product1 = new Products("KKD", "Joseph", 100.0, 14);
    received.put(product1, 10);

    receipt.addReceivedItem(product1, 10);
    Assertions.assertTrue(receipt.getReceived().containsKey(product1));
    Assertions.assertEquals(10, receipt.getReceived().get(product1));
  }

  @Test
  void addOutofStockItem() {
    Products product1 = new Products("KKD", "Joseph", 100.0, 14);
    receipt.addOutofStockItem(product1);
    Assertions.assertTrue(receipt.getOutOfStock().contains(product1));
  }

  @Test
  void addAgeRequireItem() {
    Products product1 = new Products("KKD", "Joseph", 100.0, 14);
    receipt.addAgeRequireItem(product1);
    Assertions.assertTrue(receipt.getAgeRequire().contains(product1));
  }

  @Test
  void getTotalPrice() {
    Assertions.assertEquals(0.0, receipt.getTotalPrice());
  }

  @Test
  void getAgeRequire() {
    Products product1 = new Products("KKD", "Joseph", 100.0, 14);
    List<Products> test = new ArrayList<>();
    test.add(product1);
    receipt = new Receipt();
    receipt.addAgeRequireItem(product1);
    Assertions.assertEquals(test, receipt.getAgeRequire());
  }

  @Test
  void getOutOfStock() {
    Products product1 = new Products("KKD", "Joseph", 100.0, 14);
    List<Products> test = new ArrayList<>();
    test.add(product1);
    receipt = new Receipt();
    receipt.addOutofStockItem(product1);
    Assertions.assertEquals(test, receipt.getOutOfStock());
  }

  @Test
  void getReceived() {
    Map<Products, Integer> received = new HashMap<>();
    Products product1 = new Products("KKD", "Joseph", 100.0, 14);
    received.put(product1, 10);

    receipt.addReceivedItem(product1, 10);
    Assertions.assertEquals(received, receipt.getReceived());
  }

  @Test
  void setAgeRequire() {
    Products product1 = new Products("KKD", "Joseph", 100.0, 14);
    List<Products> test = new ArrayList<>();
    test.add(product1);
    List<Products> test2 = new ArrayList<>();
    test2.add(product1);
    receipt = new Receipt();
    receipt.setAgeRequire(test);
    Assertions.assertEquals(test2, receipt.getAgeRequire());
  }

  @Test
  void setOutOfStock() {
    Products product1 = new Products("KKD", "Joseph", 100.0, 14);
    List<Products> test = new ArrayList<>();
    test.add(product1);
    List<Products> test2 = new ArrayList<>();
    test2.add(product1);
    receipt = new Receipt();
    receipt.setOutOfStock(test);
    Assertions.assertEquals(test2, receipt.getOutOfStock());
  }

  @Test
  void setReceived() {
    Map<Products, Integer> received = new HashMap<>();
    Map<Products, Integer> received2 = new HashMap<>();
    Products product1 = new Products("KKD", "Joseph", 100.0, 14);
    received.put(product1, 10);
    received2.put(product1, 10);
    receipt.setReceived(received);
    Assertions.assertEquals(received2, receipt.getReceived());
  }

  @Test
  void setTotalPrice() {
    receipt.setTotalPrice(100.0);
    Assertions.assertEquals(100.0, receipt.getTotalPrice());
  }

  @Test
  void testEquals() {
    Assertions.assertTrue(receipt.equals(receipt));
    Products product1 = new Products("KKD", "Joseph", 100.0, 14);
    Assertions.assertFalse(receipt.equals(product1));
    List<Products> ageTest = new ArrayList<>();
    List<Products> outTest = new ArrayList<>();
    Map<Products, Integer> receiveTest = new HashMap<>();
    Double valueTest = 0.0;

    ageTest.add(product1);
    outTest.add(product1);
    receiveTest.put(product1, 10);

    Receipt receipt3 = new Receipt();
    receipt3.setAgeRequire(ageTest);
    receipt3.setOutOfStock(outTest);
    receipt3.setReceived(receiveTest);

    Receipt receipt1 = new Receipt();
    receipt1.setAgeRequire(ageTest);
    receipt1.setOutOfStock(outTest);
    receipt1.setReceived(receiveTest);

    Assertions.assertTrue(receipt1.equals(receipt3));

    Receipt receipt2 = new Receipt();
    Assertions.assertFalse(receipt1.equals(receipt2));

    Receipt receipt4 = new Receipt();
    receipt4.setAgeRequire(ageTest);
    Assertions.assertFalse(receipt1.equals(receipt4));

    Receipt receipt5 = new Receipt();
    receipt5.setAgeRequire(ageTest);
    receipt5.setOutOfStock(outTest);
    Assertions.assertFalse(receipt1.equals(receipt5));

    Receipt receipt6 = new Receipt();
    receipt6.setAgeRequire(ageTest);
    receipt6.setOutOfStock(outTest);
    Assertions.assertFalse(receipt1.equals(receipt6));

    Receipt receipt7 = new Receipt();
    receipt7.setAgeRequire(ageTest);
    receipt7.setOutOfStock(outTest);
    receipt7.setReceived(receiveTest);
    receipt7.setTotalPrice(100.0);
    Assertions.assertFalse(receipt1.equals(receipt7));

  }

  @Test
  void testHashCode() {
    int test = Objects.hash(receipt.getTotalPrice(), receipt.getReceived(), receipt.getOutOfStock(), receipt.getAgeRequire());
    Assertions.assertEquals(test, receipt.hashCode());
  }

  @Test
  void testToString() {
    String test = "Receipt{" +
        "TotalPrice=" + receipt.getTotalPrice() +
        ", received=" + receipt.getReceived() +
        ", outOfStock=" + receipt.getOutOfStock() +
        ", ageRequire=" + receipt.getAgeRequire() +
        '}';
    Assertions.assertEquals(test, receipt.toString());

  }
}