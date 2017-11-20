import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class VendingMachineTest {

  @Test
  public void whenVendingMachineReceivesACoinItReturnsTheValueInCents() {
    VendingMachine vendingMachine = new VendingMachine();
    assertEquals(5, vendingMachine.addCoin("nickel"));
  }

}
