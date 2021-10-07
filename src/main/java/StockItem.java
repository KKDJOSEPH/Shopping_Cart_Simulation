import java.util.Objects;

/**
 * Class StockItem contains information about an StockItem, including product and quantity
 */
public class StockItem {
  private Products Product;
  private int Quantity;
  /**
   * Constructs a new StockItem, based upon all of the provided input parameters.
   *
   * @param product - the product of this stock item
   * @param quantity         - the quantity of this stock item
   * @return - object StockItem
   */
  public StockItem(Products product, int quantity){
    this.Product = product;
    this.Quantity = quantity;
  }
  /**
   * @return the product
   */
  public Products getProduct() {
    return Product;
  }
  /**
   * @return the quantity
   */
  public int getQuantity() {
    return Quantity;
  }
  /**
   * Set product
   */
  public void setProduct(Products product) {
    Product = product;
  }
  /**
   * Set quantity
   */
  public void setQuantity(int quantity) {
    Quantity = quantity;
  }

  public boolean checkQuantity(int num){
    return Quantity >= num;
  }
  /**
   * @return the StockItem's string form.
   */
  @Override
  public String toString() {
    return "StockItem{" +
        "Product=" + Product +
        ", Quantity=" + Quantity +
        '}';
  }
  /**
   * Return if this StockItem is equal to the other object.
   *
   * @param o the other object
   * @return true if two objects are equal
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof StockItem)) {
      return false;
    }
    StockItem stockItem = (StockItem) o;
    return getQuantity() == stockItem.getQuantity() &&
        getProduct().equals(stockItem.getProduct());
  }
  /**
   * Hash code of the StockItem.
   *
   * @return hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(getProduct(), getQuantity());
  }
}
