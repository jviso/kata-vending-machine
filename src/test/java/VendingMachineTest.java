import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class VendingMachineTest {

  VendingMachine vendingMachine;

  @Before
  public void setUp() {
    vendingMachine = new VendingMachine();
  }

  @Test
  public void whenVendingMachineReceivesACoinItReturnsTheValueInCents() {
    assertEquals(5, vendingMachine.addCoin("nickel"));
  }

  @Test
  public void whenVendingMachineReceivesAProductRequestItReturnsTheProductName() {
    assertEquals("COLA DISPENSED", vendingMachine.requestProduct("cola"));
  }

}
