import java.util.*;
/**
 * Class ShoppingCart contains information about a ShoppingCart, including the cart map
 */
public class ShoppingCart {
  private Map<Products, Integer> cart;
  private Double totalPrice;
  /**
   * Constructs a new ShoppingCart
   * @return - object ShoppingCart
   */
  public ShoppingCart(){
    this.cart = new HashMap<>();
    this.totalPrice = 0.0;
  }

  /**
   * Set cart
   */
  public void setCart(Map<Products, Integer> map) {
    this.cart = map;
  }

  /**
   * @return - total price
   */
  public Double getTotalPrice() {
    return totalPrice;
  }
  /**
   * Set total price
   */
  public void setTotalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
  }

  /**
   * @return the cart
   */
  public Map<Products, Integer> getCart() {
    return cart;
  }
  /**
   * @return the ShoppingCart's string form.
   */
  @Override
  public String toString() {
    return "ShoppingCart{" +
        "cart=" + cart +
        ", totalPrice=" + totalPrice +
        '}';
  }

  /**
   * Return if this ShoppingCart is equal to the other object.
   *
   * @param o the other object
   * @return true if two objects are equal
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ShoppingCart)) {
      return false;
    }
    ShoppingCart that = (ShoppingCart) o;
    return getTotalPrice().equals(that.getTotalPrice()) &&
        getCart().equals(that.getCart());
  }

  /**
   * Hash code of the ShoppingCart.
   *
   * @return hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(getCart(), getTotalPrice());
  }

  /**
   * @return whether this item has been added successfully
   */
  public boolean addItem(Products products, int number, Inventory inventory){
    boolean flag = products instanceof Grocery;
    if(flag && inventory.getGroceryStock().get(products).getQuantity() < number){
      Exception e = new NoEnoughInventory("The product " + products.getClass().toString() + " " + products.getName() + " only has " +
          inventory.getGroceryStock().get(products).getQuantity() + " left");
      e.printStackTrace();
      return false;
    }

    if(!flag && inventory.getHouseholdStock().get(products).getQuantity() < number){
      Exception e =  new NoEnoughInventory("The product " + products.getClass().toString() + " " + products.getName() + " only has " +
          inventory.getHouseholdStock().get(products).getQuantity() + " left");
      e.printStackTrace();
      return false;
    }
    cart.put(products, cart.getOrDefault(products, 0) + number);
    return true;
  }


  /**
   * Delete an item from the cart
   */
  public void deleteItem(Products products){
    cart.remove(products);
  }

  public void emptyCart(){
    this.cart.clear();
    this.totalPrice = 0.0;
  }
  /**
   * Calculate the total price for the cart
   */
  public void calculatePrice(){
    Double price = 0.0;
    for(Products i : cart.keySet()){
      price += i.getPrice() * (double)cart.get(i);
    }
    this.totalPrice = price;
  }

}
