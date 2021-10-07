import java.util.Objects;

/**
 * Class Products contains information about a Products, including the manufacturer, name, price, minimum age
 */

public class Products {

  private String Manufacturer;
  private String Name;
  private Double Price;
  private int MinimumAge;
  /**
   * Constructs a new Product, based upon all of the provided input parameters.
   *
   * @param manufacturer - the manufacturer of this Product
   * @param name         - the name of this Product
   * @param price        - the price of this Product
   * @param minimumAge   - the minimum age limit to buy this Product
   * @return - object Product
   */
  public Products(String manufacturer, String name, Double price, int minimumAge){
    this.Manufacturer = manufacturer;
    this.MinimumAge = minimumAge;
    this.Name = name;
    this.Price = price;
  }
  /**
   * @return the manufacturer
   */
  public String getManufacturer(){
    return this.Manufacturer;
  }
  /**
   * @return the name
   */
  public String getName() {
    return Name;
  }
  /**
   * @return the price
   */
  public Double getPrice() {
    return Price;
  }
  /**
   * @return the minimum age
   */
  public int getMinimumAge() {
    return MinimumAge;
  }
  /**
   * Set name
   */
  public void setName(String name) {
    Name = name;
  }
  /**
   * Set manufacturer
   */
  public void setManufacturer(String manufacturer) {
    Manufacturer = manufacturer;
  }
  /**
   * Set minimum age
   */
  public void setMinimumAge(int minimumAge) {
    MinimumAge = minimumAge;
  }
  /**
   * Set price
   */
  public void setPrice(Double price) {
    Price = price;
  }
  /**
   * Return if this Products is equal to the other object.
   *
   * @param o the other object
   * @return true if two objects are equal
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Products)) {
      return false;
    }
    Products products = (Products) o;
    return getMinimumAge() == products.getMinimumAge() &&
        Objects.equals(getManufacturer(), products.getManufacturer()) &&
        Objects.equals(getName(), products.getName()) &&
        Objects.equals(getPrice(), products.getPrice());
  }
  /**
   * Hash code of the Products.
   *
   * @return hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(getManufacturer(), getName(), getPrice(), getMinimumAge());
  }
  /**
   * @return the Product's string form.
   */
  @Override
  public String toString() {
    return "Products{" +
        "Manufacturer='" + Manufacturer + '\'' +
        ", Name='" + Name + '\'' +
        ", Price=" + Price +
        ", MinimumAge=" + MinimumAge +
        '}';
  }
}
