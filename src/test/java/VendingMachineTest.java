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
  public void whenVendingMachineReceivesANickelCurrentTotalIsFiveCents() {
    vendingMachine.addCoin("nickel");
    assertEquals(5, vendingMachine.getCurrentTotalInCents());
  }

  @Test
  public void whenVendingMachineReceivesAProductRequestItReturnsTheProductName() {
    assertEquals("COLA DISPENSED", vendingMachine.requestProduct("cola"));
  }

  @Test
  public void whenUserRequestsCoinReturnCurrentTotalIsSetToZero() {
    vendingMachine.addCoin("nickel");
    vendingMachine.returnAllCoins();
    assertEquals(0, vendingMachine.getCurrentTotalInCents());
  }

  @Test
  public void whenVendingMachineReceivesTwoNickelsCurrentTotalIsTenCents() {
    vendingMachine.addCoin("nickel");
    vendingMachine.addCoin("nickel");
    assertEquals(10, vendingMachine.getCurrentTotalInCents());
  }

}
