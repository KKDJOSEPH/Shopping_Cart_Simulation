import java.util.*;
import javafx.util.Pair;

/**
 * Class Customers contains information about a Customers, including name, age, shopping cart, receipt
 */
public class Customers {
  private String Name;
  private int Age;
  private ShoppingCart ShoppingCart;
  private Receipt receipt;
  /**
   * Constructs a new Customer, based upon all of the provided input parameters.
   *
   * @param name - the name of this Customer
   * @param age         - the age of this Customer
   * @return - object Customers
   */
  public Customers(String name, int age){
    this.Name = name;
    this.Age = age;
    this.ShoppingCart = new ShoppingCart();
    this.receipt = new Receipt();
  }
  /**
   * @return the shopping cart
   */
  public ShoppingCart getShoppingCart() {
    return ShoppingCart;
  }
  /**
   * @return the age
   */
  public int getAge() {
    return Age;
  }
  /**
   * @return the name
   */
  public String getName() {
    return Name;
  }
  /**
   * @return the receipt
   */
  public Receipt getReceipt() {
    return receipt;
  }
  /**
   * Set receipt
   */
  public void setReceipt(Receipt receipt) {
    this.receipt = receipt;
  }
  /**
   * Set the name
   */
  public void setName(String name) {
    Name = name;
  }
  /**
   * Set age
   */
  public void setAge(int age) {
    Age = age;
  }
  /**
   * Set shopping cart
   */
  public void setShoppingCart(ShoppingCart shoppingCart) {
    ShoppingCart = shoppingCart;
  }
  /**
   * Return if this Customers is equal to the other object.
   *
   * @param o the other object
   * @return true if two objects are equal
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Customers)) {
      return false;
    }
    Customers customers = (Customers) o;
    return getAge() == customers.getAge() &&
        getName().equals(customers.getName()) &&
        getShoppingCart().equals(customers.getShoppingCart()) &&
        getReceipt().equals(customers.getReceipt());
  }
  /**
   * Hash code of the Customers.
   *
   * @return hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(getName(), getAge(), getShoppingCart(), getReceipt());
  }
  /**
   * @return the Customers's string form.
   */
  @Override
  public String toString() {
    return "Customers{" +
        "Name='" + Name + '\'' +
        ", Age=" + Age +
        ", ShoppingCart=" + ShoppingCart +
        ", Receipt=" + receipt +
        '}';
  }
  /**
   * add an item to the shopping cart
   */
  public boolean addItem(Products product, Inventory inventory) {
    return ShoppingCart.addItem(product, 1, inventory);
  }
  /**
   * add items to the shopping cart with given number
   */
  public boolean addItem(Products product, int number, Inventory inventory){
    return ShoppingCart.addItem(product, number, inventory);
  }
  /**
   * Checkout the shopping cart, find whether there are some items need to be substituted first, then calculate the total price
   * @return Receipt
   */
  public Receipt checkOut(Inventory inventory){
    substitute(inventory);
    double price = 0;
    for(Products i : receipt.getReceived().keySet()){
      price += i.getPrice() * (double)receipt.getReceived().get(i);
    }
    receipt.setTotalPrice(price);
    this.ShoppingCart.emptyCart();
    return receipt;
  }
  /**
   * Find whether there are some items in the shopping cart need to be substituted
   * @return the modified inventory
   */
  public void substitute(Inventory inventory){
    Map<Grocery, StockItem> GroceryStock = inventory.getGroceryStock();
    Map<Household, StockItem> HouseholdStock = inventory.getHouseholdStock();
    Map<Products, Integer> cart = new HashMap(ShoppingCart.getCart());
    for(Products i : cart.keySet()){
      int num = cart.get(i);
      if(i instanceof Beer && i.getMinimumAge() > this.Age){
        ShoppingCart.deleteItem(i);
        receipt.addAgeRequireItem(i);
        continue;
      }

      boolean flag = i instanceof Grocery;
      int total = 0;
      if(flag) total = GroceryStock.get(i).getQuantity();
      else total = HouseholdStock.get(i).getQuantity();
      if(total >= num){
        receipt.addReceivedItem(i, num);
        if(flag){
          StockItem stockItem = inventory.getGroceryStock().get(i);
          stockItem.setQuantity(total - num);
          inventory.getGroceryStock().put((Grocery) i, stockItem);
        }
        else{
          StockItem stockItem = inventory.getHouseholdStock().get(i);
          stockItem.setQuantity(total - num);
          inventory.getHouseholdStock().put((Household) i, stockItem);
        }
        continue;
      }
      else{
        ShoppingCart.deleteItem(i);
        ShoppingCart.addItem(i, total, inventory);
        receipt.addReceivedItem(i, total);
        if(flag){
          StockItem stockItem = inventory.getGroceryStock().get(i);
          stockItem.setQuantity(0);
          inventory.getGroceryStock().put((Grocery) i, stockItem);

          boolean subsituteFlag = false;
          for(Grocery j : GroceryStock.keySet()){
            if(i.getClass().equals(j.getClass()) && GroceryStock.get(j).getQuantity() > 0
                && i.getPrice() >= j.getPrice() && ((Grocery) i).getWeight() <= j.getWeight()){
              ShoppingCart.addItem(j, Math.min(num - total, GroceryStock.get(j).getQuantity()), inventory);
              subsituteFlag = num - total <= GroceryStock.get(j).getQuantity();

              StockItem stockItem2 = inventory.getGroceryStock().get(j);
              stockItem.setQuantity(Math.min(num - total, GroceryStock.get(j).getQuantity()));
              inventory.getGroceryStock().put(j, stockItem2);
              receipt.addReceivedItem(j, Math.min(num - total, GroceryStock.get(j).getQuantity()));
              break;
            }
          }
          if(!subsituteFlag) receipt.addOutofStockItem(i);
        }
        else{
          StockItem stockItem = inventory.getHouseholdStock().get(i);
          stockItem.setQuantity(0);
          inventory.getHouseholdStock().put((Household) i, stockItem);

          boolean subsituteFlag = false;
          for(Household j : HouseholdStock.keySet()){
            if(i.getClass().equals(j.getClass()) && HouseholdStock.get(j).getQuantity() > 0
                && i.getPrice() >= j.getPrice() && ((Household) i).getUnits() <= j.getUnits()){
              ShoppingCart.addItem(j, Math.min(num - total, HouseholdStock.get(j).getQuantity()), inventory);
              subsituteFlag = num - total <= HouseholdStock.get(j).getQuantity();

              StockItem stockItem2 = inventory.getHouseholdStock().get(j);
              stockItem.setQuantity(Math.min(num - total, HouseholdStock.get(j).getQuantity()));
              inventory.getHouseholdStock().put(j, stockItem2);
              receipt.addReceivedItem(j, Math.min(num - total, HouseholdStock.get(j).getQuantity()));
              break;
            }
          }
          if(!subsituteFlag) receipt.addOutofStockItem(i);
        }
      }
    }
  }
}
