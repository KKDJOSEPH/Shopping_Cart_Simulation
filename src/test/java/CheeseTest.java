import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class CheeseTest {
  private Cheese cheese;
  @BeforeEach
  void setUp() {
    this.cheese = new Cheese("KKD", "Joseph", 10.0, 14, 100.0);
  }
}