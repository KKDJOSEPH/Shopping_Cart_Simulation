/**
 * Class Shampoo contains information about a Shampoo, including the manufacturer, name, price, minimum age, units
 */
public class Shampoo extends Household{
  /**
   * Constructs a new Shampoo, based upon all of the provided input parameters.
   *
   * @param manufacturer - the manufacturer of this Shampoo
   * @param name         - the name of this Shampoo
   * @param price        - the price of this Shampoo
   * @param minimumAge   - the minimum age limit to buy this Shampoo
   * @param units       - the unit of this Shampoo
   * @return - object Shampoo
   */
  public Shampoo(String manufacturer, String name, Double price, int minimumAge, int units) {
    super(manufacturer, name, price, minimumAge, units);
  }
}
