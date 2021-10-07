import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HouseholdTest {
  private Household household;
  @BeforeEach
  void setUp() {
    this.household = new Household("KKD", "Joseph", 10.0, 14, 10);
  }

  @Test
  void getUnits() {
    Assertions.assertEquals(10, household.getUnits());
  }

  @Test
  void setUnits() {
    household.setUnits(100);
    Assertions.assertEquals(100, household.getUnits());
  }

  @Test
  void testEquals() {
    Assertions.assertTrue(household.equals(household));
    this.household = new Household("KKD", "Joseph", 10.0, 14, 10);
    Household household0 = new Household("KKD", "Joseph", 10.0, 14, 10);
    Assertions.assertTrue(household0.equals(household));
    Household household1 = new Household("KKDD", "Joseph", 10.0, 14, 10);
    Assertions.assertFalse(household.equals(household1));
    Household household2 = new Household("KKD", "JosephD", 10.0, 14, 10);
    Assertions.assertFalse(household1.equals(household2));
    Household household3 = new Household("KKD", "Joseph", 101.0, 14, 10);
    Assertions.assertFalse(household1.equals(household3));
    Household household4 = new Household("KKD", "Joseph", 10.0, 141, 10);
    Assertions.assertFalse(household1.equals(household4));
    Household household5 = new Household("KKD", "Joseph", 10.0, 14, 101);
    Assertions.assertFalse(household1.equals(household5));
  }

  @Test
  void testHashCode() {
    Assertions.assertEquals(680533489, household.hashCode());
  }

  @Test
  void testToString() {
    Assertions.assertEquals("Household{Units=10} Products{Manufacturer='KKD', Name='Joseph', Price=10.0, MinimumAge=14}", household.toString());
  }
}