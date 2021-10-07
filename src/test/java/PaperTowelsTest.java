import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class PaperTowelsTest {
  private PaperTowels paperTowels;
  @BeforeEach
  void setUp() {
    this.paperTowels = new PaperTowels("KKD", "Joseph", 10.0, 14, 10);
  }
}