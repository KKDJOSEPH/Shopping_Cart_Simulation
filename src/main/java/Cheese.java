/**
 * Class Cheese contains information about a Cheese, including the manufacturer, name, price, minimum age, weight
 */
public class Cheese extends Grocery{
  /**
   * Constructs a new Cheese, based upon all of the provided input parameters.
   *
   * @param manufacturer - the manufacturer of this cheese
   * @param name         - the name of this cheese
   * @param price        - the price of this cheese
   * @param minimumAge   - the minimum age limit to buy this cheese
   * @param weight       - the weight of this cheese
   * @return - object Cheese
   */
  public Cheese(String manufacturer, String name, Double price, int minimumAge,
      Double weight) {
    super(manufacturer, name, price, minimumAge, weight);
  }
}
