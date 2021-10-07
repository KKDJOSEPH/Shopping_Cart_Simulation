import java.util.Objects;

/**
 * Class Household contains information about a Household, including the manufacturer, name, price, minimum age, units
 */
public class Household extends Products{
  private int Units;
  /**
   * Constructs a new Household, based upon all of the provided input parameters.
   *
   * @param manufacturer - the manufacturer of this Household
   * @param name         - the name of this Household
   * @param price        - the price of this Household
   * @param minimumAge   - the minimum age limit to buy this Household
   * @param units       - the unit of this Household
   * @return - object Household
   */
  public Household(String manufacturer, String name, Double price, int minimumAge, int units) {
    super(manufacturer, name, price, minimumAge);
    this.Units = units;
  }
  /**
   * @return the unit
   */
  public int getUnits() {
    return Units;
  }
  /**
   * Set units
   */
  public void setUnits(int units) {
    Units = units;
  }
  /**
   * Return if this Household is equal to the other object.
   *
   * @param o the other object
   * @return true if two objects are equal
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Household)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Household household = (Household) o;
    return getUnits() == household.getUnits();
  }
  /**
   * Hash code of the Household.
   *
   * @return hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getUnits());
  }
  /**
   * @return the Household's string form.
   */
  @Override
  public String toString() {
    return "Household{" +
        "Units=" + Units +
        "} " + super.toString();
  }
}
