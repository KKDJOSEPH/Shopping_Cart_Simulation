import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InventoryTest {
  private Inventory inventory;
  @BeforeEach
  void setUp() {
    Beer beer = new Beer("KKD", "Joseph", 10.0, 14, 100.0);
    PaperTowels paperTowels = new PaperTowels("KKD", "Joseph", 10.0, 14, 10);
    StockItem beerr = new StockItem(beer, 10);
    StockItem paperTowelss = new StockItem(paperTowels, 10);
    Map<Grocery, StockItem> groceryStock = new HashMap<>();
    Map<Household, StockItem> householdStock = new HashMap<>();
    groceryStock.put(beer, beerr);
    householdStock.put(paperTowels, paperTowelss);
    inventory = new Inventory(groceryStock, householdStock);
  }

  @Test
  void getGroceryStock() {
    Beer beer = new Beer("KKD", "Joseph", 10.0, 14, 100.0);
    PaperTowels paperTowels = new PaperTowels("KKD", "Joseph", 10.0, 14, 10);
    StockItem beerr = new StockItem(beer, 10);
    StockItem paperTowelss = new StockItem(paperTowels, 10);
    Map<Grocery, StockItem> groceryStock = new HashMap<>();
    Map<Household, StockItem> householdStock = new HashMap<>();
    groceryStock.put(beer, beerr);
    householdStock.put(paperTowels, paperTowelss);
    Assertions.assertEquals(groceryStock, inventory.getGroceryStock());
  }

  @Test
  void getHouseholdStock() {
    Beer beer = new Beer("KKD", "Joseph", 10.0, 14, 100.0);
    PaperTowels paperTowels = new PaperTowels("KKD", "Joseph", 10.0, 14, 10);
    StockItem beerr = new StockItem(beer, 10);
    StockItem paperTowelss = new StockItem(paperTowels, 10);
    Map<Grocery, StockItem> groceryStock = new HashMap<>();
    Map<Household, StockItem> householdStock = new HashMap<>();
    groceryStock.put(beer, beerr);
    householdStock.put(paperTowels, paperTowelss);
    Assertions.assertEquals(householdStock, inventory.getHouseholdStock());
  }

  @Test
  void setGroceryStock() {
    Beer beer = new Beer("KKD", "Joseph", 10.0, 14, 101.0);
    PaperTowels paperTowels = new PaperTowels("KKD", "Joseph", 10.0, 14, 101);
    StockItem beerr = new StockItem(beer, 10);
    StockItem paperTowelss = new StockItem(paperTowels, 10);
    Map<Grocery, StockItem> groceryStock = new HashMap<>();
    Map<Household, StockItem> householdStock = new HashMap<>();
    groceryStock.put(beer, beerr);
    householdStock.put(paperTowels, paperTowelss);
    inventory.setGroceryStock(groceryStock);
    Assertions.assertEquals(groceryStock, inventory.getGroceryStock());
  }

  @Test
  void setHouseholdStock() {
    Beer beer = new Beer("KKD", "Joseph", 10.0, 14, 100.0);
    PaperTowels paperTowels = new PaperTowels("KKD", "Joseph", 10.0, 124, 10);
    StockItem beerr = new StockItem(beer, 10);
    StockItem paperTowelss = new StockItem(paperTowels, 10);
    Map<Grocery, StockItem> groceryStock = new HashMap<>();
    Map<Household, StockItem> householdStock = new HashMap<>();
    groceryStock.put(beer, beerr);
    householdStock.put(paperTowels, paperTowelss);
    inventory.setHouseholdStock(householdStock);
    Assertions.assertEquals(householdStock, inventory.getHouseholdStock());
  }

  @Test
  void totalRetailValue() {
    Beer beer = new Beer("KKD", "Joseph", 10.0, 14, 100.0);
    PaperTowels paperTowels = new PaperTowels("KKD", "Joseph", 10.0, 14, 10);
    StockItem beerr = new StockItem(beer, 10);
    StockItem paperTowelss = new StockItem(paperTowels, 10);
    Map<Grocery, StockItem> groceryStock = new HashMap<>();
    Map<Household, StockItem> householdStock = new HashMap<>();
    groceryStock.put(beer, beerr);
    householdStock.put(paperTowels, paperTowelss);
    inventory = new Inventory(groceryStock, householdStock);
    Assertions.assertEquals(200.0, inventory.totalRetailValue());
  }

  @Test
  void testEquals() {
    Assertions.assertTrue(inventory.equals(inventory));

    Beer beer = new Beer("KKD", "Joseph", 10.0, 14, 100.0);
    PaperTowels paperTowels = new PaperTowels("KKD", "Joseph", 10.0, 14, 10);
    StockItem beerr = new StockItem(beer, 10);
    StockItem paperTowelss = new StockItem(paperTowels, 10);
    Map<Grocery, StockItem> groceryStock = new HashMap<>();
    Map<Grocery, StockItem> groceryStock2 = new HashMap<>();
    Map<Household, StockItem> householdStock = new HashMap<>();
    Map<Household, StockItem> householdStock2 = new HashMap<>();
    groceryStock.put(beer, beerr);
    householdStock.put(paperTowels, paperTowelss);
    groceryStock2.put(beer, beerr);
    householdStock2.put(paperTowels, paperTowelss);
    Inventory inventory1 = new Inventory(groceryStock2, householdStock2);
    inventory = new Inventory(groceryStock, householdStock);
    Assertions.assertTrue(inventory.equals(inventory1));

    StockItem beer2 = new StockItem(beer, 100);
    StockItem paper2 = new StockItem(paperTowels, 100);
    Map<Grocery, StockItem> groceryStock3 = new HashMap<>();
    Map<Household, StockItem> householdStock3 = new HashMap<>();
    groceryStock3.put(beer, beer2);
    householdStock3.put(paperTowels, paper2);
    Inventory inventory2 = new Inventory(groceryStock3, householdStock3);
    Assertions.assertFalse(inventory1.equals(inventory2));
  }

  @Test
  void testHashCode() {
    int test = Objects.hash(inventory.getGroceryStock(), inventory.getHouseholdStock());
    Assertions.assertEquals(test, inventory.hashCode());
  }

  @Test
  void testToString() {
    String test = "Inventory{" +
        "GroceryStock=" + inventory.getGroceryStock() +
        ", HouseholdStock=" + inventory.getHouseholdStock() +
        '}';
    Assertions.assertEquals(test, inventory.toString());
  }
}