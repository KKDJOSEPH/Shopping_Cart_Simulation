import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class BeerTest {
  private Beer beer;
  @BeforeEach
  void setUp() {
    this.beer = new Beer("KKD", "Joseph", 10.0, 14, 100.0);
  }
}