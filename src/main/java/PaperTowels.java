/**
 * Class PaperTowels contains information about a PaperTowels, including the manufacturer, name, price, minimum age, units
 */
public class PaperTowels extends Household{
  /**
   * Constructs a new PaperTowels, based upon all of the provided input parameters.
   *
   * @param manufacturer - the manufacturer of this PaperTowels
   * @param name         - the name of this PaperTowels
   * @param price        - the price of this PaperTowels
   * @param minimumAge   - the minimum age limit to buy this PaperTowels
   * @param units       - the unit of this PaperTowels
   * @return - object PaperTowels
   */
  public PaperTowels(String manufacturer, String name, Double price, int minimumAge, int units) {
    super(manufacturer, name, price, minimumAge, units);
  }
}
