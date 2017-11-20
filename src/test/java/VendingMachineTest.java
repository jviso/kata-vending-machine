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

  @Test
  public void whenVendingMachineReceivesADimeAndANickelCurrentTotalIsFifteenCents() {
    vendingMachine.addCoin("dime");
    vendingMachine.addCoin("nickel");
    assertEquals(15, vendingMachine.getCurrentTotalInCents());
  }

  @Test
  public void whenVendingMachineReceivesQuarterAndDimeAndNickelCurrentTotalIsFortyCents() {
    vendingMachine.addCoin("quarter");
    vendingMachine.addCoin("dime");
    vendingMachine.addCoin("nickel");
    assertEquals(40, vendingMachine.getCurrentTotalInCents());
  }

  @Test
  public void whenVendingMachineReceivesNickelAndPennyCurrentTotalIsFiveCents() {
    vendingMachine.addCoin("nickel");
    vendingMachine.addCoin("penny");
    assertEquals(5, vendingMachine.getCurrentTotalInCents());
  }

  @Test
  public void whenColaIsRequestedVendingMachineKnowsThePriceIs100Cents() {
    assertEquals(100, vendingMachine.getPrice("cola"));
  }

  @Test
  public void whenChipsAreRequestedVendingMachineKnowsThePriceIs50Cents() {
    assertEquals(50, vendingMachine.getPrice("chips"));
  }

  @Test
  public void whenCandyIsRequestedVendingMachineKnowsThePriceIs65Cents() {
    assertEquals(65, vendingMachine.getPrice("candy"));
  }

  @Test
  public void whenColaIsRequestedAndUserHasEnteredFourQuartersVendingMachineAllowsThePurchase() {
    for (int i = 0; i < 4; i++) {
      vendingMachine.addCoin("quarter");
    }
    assertEquals(true, vendingMachine.canPurchase("cola"));
  }

  @Test
  public void whenColaIsRequestedAndUserHasNotEnteredMoneyVendingMachineDoesNotAllowThePurchase() {
    assertEquals(false, vendingMachine.canPurchase("cola"));
  }

  @Test
  public void whenChipsAreRequestedAndUserHasEnteredFiftyCentsVendingMachineAllowsThePurchase() {
    vendingMachine.addCoin("quarter");
    vendingMachine.addCoin("quarter");
    assertEquals(true, vendingMachine.canPurchase("chips"));
  }

}
