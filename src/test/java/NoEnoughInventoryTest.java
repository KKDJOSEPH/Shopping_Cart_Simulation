import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class NoEnoughInventoryTest {
  private NoEnoughInventory e;
  @BeforeEach
  void setUp() {
    this.e = new NoEnoughInventory("");
  }
}