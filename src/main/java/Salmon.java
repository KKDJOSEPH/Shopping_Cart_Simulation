/**
 * Class Salmon contains information about a Cheese, including the manufacturer, name, price, minimum age, weight
 */
public class Salmon extends Grocery{
  /**
   * Constructs a new Salmon, based upon all of the provided input parameters.
   *
   * @param manufacturer - the manufacturer of this Salmon
   * @param name         - the name of this Salmon
   * @param price        - the price of this Salmon
   * @param minimumAge   - the minimum age limit to buy this Salmon
   * @param weight       - the weight of this Salmon
   * @return - object Salmon
   */
  public Salmon(String manufacturer, String name, Double price, int minimumAge,
      Double weight) {
    super(manufacturer, name, price, minimumAge, weight);
  }
}
