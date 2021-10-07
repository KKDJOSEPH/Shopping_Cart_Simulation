import java.util.*;

/**
 * Class Inventory contains information about the inventory, including the grocery stock map and the household stock map
 */
public class Inventory {
  private Map<Grocery, StockItem> GroceryStock;
  private Map<Household, StockItem> HouseholdStock;
  /**
   * Constructs a new Inventory, based upon all of the provided input parameters.
   *
   * @param groceryStock - the grocery stock
   * @param householdStock - the household stock
   * @return - object Inventory
   */
  public Inventory(Map<Grocery, StockItem> groceryStock, Map<Household, StockItem> householdStock){
    this.GroceryStock = groceryStock;
    this.HouseholdStock = householdStock;
  }
  /**
   * @return the grocery stock
   */
  public Map<Grocery, StockItem> getGroceryStock() {
    return GroceryStock;
  }
  /**
   * @return the household stock
   */
  public Map<Household, StockItem> getHouseholdStock() {
    return HouseholdStock;
  }
  /**
   * Set grocery stock
   */
  public void setGroceryStock(Map<Grocery, StockItem> groceryStock) {
    GroceryStock = groceryStock;
  }
  /**
   * Set household stock
   */
  public void setHouseholdStock(Map<Household, StockItem> householdStock) {
    HouseholdStock = householdStock;
  }
  /**
   * @return the total retail value
   */
  public int totalRetailValue(){
    int answer = 0;
    for(StockItem i : GroceryStock.values()) answer += i.getProduct().getPrice() * i.getQuantity();
    for(StockItem i : HouseholdStock.values()) answer += i.getProduct().getPrice() * i.getQuantity();
    return answer;
  }
  /**
   * Return if this Inventory is equal to the other object.
   *
   * @param o the other object
   * @return true if two objects are equal
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Inventory)) {
      return false;
    }
    Inventory inventory = (Inventory) o;
    return getGroceryStock().equals(inventory.getGroceryStock()) &&
        getHouseholdStock().equals(inventory.getHouseholdStock());
  }
  /**
   * Hash code of the Inventory.
   *
   * @return hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(getGroceryStock(), getHouseholdStock());
  }
  /**
   * @return the Inventory's string form.
   */
  @Override
  public String toString() {
    return "Inventory{" +
        "GroceryStock=" + GroceryStock +
        ", HouseholdStock=" + HouseholdStock +
        '}';
  }
}
