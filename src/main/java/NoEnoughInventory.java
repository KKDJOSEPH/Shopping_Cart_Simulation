/**
 * Class NoEnoughInventory contains the NoEnoughInventory exception
 */

public class NoEnoughInventory extends Exception{
  /**
   * Constructs a new NoEnoughInventory, based upon all of the provided input parameters.
   *
   * @param s - the error message
   * @return - object NoEnoughInventory
   */
  public NoEnoughInventory(String s){
    super(s);
  }

}
