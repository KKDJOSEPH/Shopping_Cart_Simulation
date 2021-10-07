import java.util.*;
/**
 * Class Receipt contains information about a Receipt, including the total price, received product list, out of stock product list, didn't meet minimum age requirement product list
 */
public class Receipt {
  private Double TotalPrice;
  private Map<Products, Integer> received;
  private List<Products> outOfStock;
  private List<Products> ageRequire;
  /**
   * Constructs a new Receipt
   * @return - object Receipt
   */
  public Receipt(){
    received = new HashMap<>();
    outOfStock = new ArrayList<>();
    ageRequire = new ArrayList<>();
    TotalPrice = 0.0;
  }
  /**
   * add an item to the received list
   */
  public void addReceivedItem(Products products, int num){
    received.put(products, num);
  }
  /**
   * add an item to the out of stock list
   */
  public void addOutofStockItem(Products products){
    outOfStock.add(products);
  }
  /**
   * add an item to the age require item list
   */
  public void addAgeRequireItem(Products products){
    ageRequire.add(products);
  }
  /**
   * @return the total price
   */
  public Double getTotalPrice() {
    return TotalPrice;
  }
  /**
   * @return the age require list
   */
  public List<Products> getAgeRequire() {
    return ageRequire;
  }
  /**
   * @return the out of stock list
   */
  public List<Products> getOutOfStock() {
    return outOfStock;
  }
  /**
   * @return the received list
   */
  public Map<Products, Integer> getReceived() {
    return received;
  }
  /**
   * Set age require list
   */
  public void setAgeRequire(List<Products> ageRequire) {
    this.ageRequire = ageRequire;
  }
  /**
   * Set out of stock list
   */
  public void setOutOfStock(List<Products> outOfStock) {
    this.outOfStock = outOfStock;
  }
  /**
   * Set received list
   */
  public void setReceived(Map<Products, Integer> received) {
    this.received = received;
  }

  public void setTotalPrice(Double totalPrice) {
    TotalPrice = totalPrice;
  }
  /**
   * Return if this Receipt is equal to the other object.
   *
   * @param o the other object
   * @return true if two objects are equal
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Receipt)) {
      return false;
    }
    Receipt receipt = (Receipt) o;
    return getTotalPrice().equals(receipt.getTotalPrice()) &&
        getReceived().equals(receipt.getReceived()) &&
        getOutOfStock().equals(receipt.getOutOfStock()) &&
        getAgeRequire().equals(receipt.getAgeRequire());
  }
  /**
   * Hash code of the Receipt.
   *
   * @return hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(getTotalPrice(), getReceived(), getOutOfStock(), getAgeRequire());
  }
  /**
   * @return the Receipt's string form.
   */
  @Override
  public String toString() {
    return "Receipt{" +
        "TotalPrice=" + TotalPrice +
        ", received=" + received +
        ", outOfStock=" + outOfStock +
        ", ageRequire=" + ageRequire +
        '}';
  }

}
