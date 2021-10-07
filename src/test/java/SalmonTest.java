import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class SalmonTest {
  private Salmon salmon;
  @BeforeEach
  void setUp() {
    this.salmon = new Salmon("123", "123", 101.0, 114, 1001.0);
  }
}