/**
 * Class Beer contains information about a Beer, including the manufacturer, name, price, minimum age, weight
 */
public class Beer extends Grocery {

  /**
   * Constructs a new Beer, based upon all of the provided input parameters.
   *
   * @param manufacturer - the manufacturer of this beer
   * @param name         - the name of this beer
   * @param price        - the price of this beer
   * @param minimumAge   - the minimum age limit to buy this beer
   * @param weight       - the weight of this beer
   * @return - object Beer
   */
  public Beer(String manufacturer, String name, Double price, int minimumAge,
      Double weight) {
    super(manufacturer, name, price, minimumAge, weight);
  }
}
