import java.util.Objects;

/**
 * Class Grocery contains information about a Grocery, including the manufacturer, name, price, minimum age, weight
 */
public class Grocery extends Products{
  private Double Weight;
  /**
   * Constructs a new Grocery, based upon all of the provided input parameters.
   *
   * @param manufacturer - the manufacturer of this Grocery
   * @param name         - the name of this Grocery
   * @param price        - the price of this Grocery
   * @param minimumAge   - the minimum age limit to buy this Grocery
   * @param weight       - the weight of this Grocery
   * @return - object Grocery
   */
  public Grocery(String manufacturer, String name, Double price, int minimumAge, Double weight) {
    super(manufacturer, name, price, minimumAge);
    this.Weight = weight;
  }
  /**
   * @return the weight
   */
  public Double getWeight() {
    return Weight;
  }
  /**
   * Set weight
   */
  public void setWeight(Double weight) {
    Weight = weight;
  }
  /**
   * @return the Grocery's string form.
   */
  @Override
  public String toString() {
    return "Grocery{" +
        "Weight=" + Weight +
        "} " + super.toString();
  }
  /**
   * Return if this Grocery is equal to the other object.
   *
   * @param o the other object
   * @return true if two objects are equal
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Grocery)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Grocery grocery = (Grocery) o;
    return getWeight().equals(grocery.getWeight());
  }
  /**
   * Hash code of the Grocery.
   *
   * @return hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getWeight());
  }
}
