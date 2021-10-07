import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class ShampooTest {
  private Shampoo shampoo;
  @BeforeEach
  void setUp() {
    this.shampoo = new Shampoo("KKD", "Joseph", 10.0, 14, 10);
  }
}