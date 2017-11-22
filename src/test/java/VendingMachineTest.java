import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class VendingMachineTest {

  VendingMachine vendingMachine;

  @Before
  public void setUp() {
    vendingMachine = new VendingMachine();
  }

  public void addOneHundredCents() {
    for (int i = 0; i < 4; i++) {
      vendingMachine.addCoin("quarter");
    }
  }

  @Test
  public void whenVendingMachineReceivesANickelCurrentTotalIsFiveCents() {
    vendingMachine.addCoin("nickel");
    assertEquals(5, vendingMachine.getCurrentTotalInCents());
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
  public void whenVendingMachineReceivesACoinItReturnsTheTotal() {
    vendingMachine.addCoin("nickel");
    vendingMachine.addCoin("dime");
    assertEquals("$0.40", vendingMachine.addCoin("quarter"));
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
    addOneHundredCents();
    assertEquals(true, vendingMachine.checkIfUserHasEnteredSufficientMoneyToBuyProduct("cola"));
  }

  @Test
  public void whenColaIsRequestedAndUserHasNotEnteredMoneyVendingMachineDoesNotAllowThePurchase() {
    assertEquals(false, vendingMachine.checkIfUserHasEnteredSufficientMoneyToBuyProduct("cola"));
  }

  @Test
  public void whenChipsAreRequestedAndUserHasEnteredFiftyCentsVendingMachineAllowsThePurchase() {
    vendingMachine.addCoin("quarter");
    vendingMachine.addCoin("quarter");
    assertEquals(true, vendingMachine.checkIfUserHasEnteredSufficientMoneyToBuyProduct("chips"));
  }

  @Test
  public void whenVendingMachineIsNewThereIsAtLeastOneColaChipsAndCandy() {
    assertEquals(true, vendingMachine.getColaInventory() > 0);
    assertEquals(true, vendingMachine.getChipsInventory() > 0);
    assertEquals(true, vendingMachine.getCandyInventory() > 0);
  }

  @Test
  public void whenColaIsPurchasedColaInventoryDecreasesByOne() {
    int initialColaInventory = vendingMachine.getColaInventory();
    addOneHundredCents();
    vendingMachine.requestProduct("cola");
    assertEquals((initialColaInventory - 1), vendingMachine.getColaInventory());
  }

  @Test
  public void whenChipsArePurchasedChipsInventoryDecreasesByOne() {
    int initialChipsInventory = vendingMachine.getChipsInventory();
    addOneHundredCents();
    vendingMachine.requestProduct("chips");
    assertEquals((initialChipsInventory - 1), vendingMachine.getChipsInventory());
  }

  @Test
  public void whenCandyIsPurchasedCandyInventoryDecreasesByOne() {
    int initialCandyInventory = vendingMachine.getCandyInventory();
    addOneHundredCents();
    vendingMachine.requestProduct("candy");
    assertEquals((initialCandyInventory - 1), vendingMachine.getCandyInventory());
  }

  @Test
  public void whenColaIsInStockInventoryCheckOfColaReturnsTrue() {
    assertEquals(true, vendingMachine.checkIfProductIsInStock("cola"));
  }

  @Test
  public void whenColaIsNotInStockInventoryCheckOfColaReturnsFalse() {
    while (vendingMachine.getColaInventory() > 0) {
      addOneHundredCents();
      vendingMachine.requestProduct("cola");
    }
    assertEquals(false, vendingMachine.checkIfProductIsInStock("cola"));
  }

  @Test
  public void whenChipsAreInStockInventoryCheckOfChipsReturnsTrue() {
    assertEquals(true, vendingMachine.checkIfProductIsInStock("chips"));
  }

  @Test
  public void whenChipsAreNotInStockInventoryCheckOfChipsReturnsFalse() {
    while (vendingMachine.getChipsInventory() > 0) {
      addOneHundredCents();
      vendingMachine.requestProduct("chips");
    }
    assertEquals(false, vendingMachine.checkIfProductIsInStock("chips"));
  }

  @Test
  public void whenCandyIsInStockInventoryCheckOfCandyReturnsTrue() {
    assertEquals(true, vendingMachine.checkIfProductIsInStock("candy"));
  }

  @Test
  public void whenCandyIsNotInStockInventoryCheckOfCandyReturnsFalse() {
    while (vendingMachine.getCandyInventory() > 0) {
      addOneHundredCents();
      vendingMachine.requestProduct("candy");
    }
    assertEquals(false, vendingMachine.checkIfProductIsInStock("candy"));
  }

  @Test
  public void whenColaIsNotInStockColaRequestReturnsSoldOut() {
    while (vendingMachine.getColaInventory() > 0) {
      addOneHundredCents();
      vendingMachine.requestProduct("cola");
    }
    assertEquals("SOLD OUT", vendingMachine.requestProduct("cola"));
  }

  @Test
  public void whenChipsAreNotInStockChipsRequestReturnsSoldOut() {
    while (vendingMachine.getChipsInventory() > 0) {
      addOneHundredCents();
      vendingMachine.requestProduct("chips");
    }
    assertEquals("SOLD OUT", vendingMachine.requestProduct("chips"));
  }

  @Test
  public void whenCandyIsNotInStockCandyRequestReturnsSoldOut() {
    while (vendingMachine.getCandyInventory() > 0) {
      addOneHundredCents();
      vendingMachine.requestProduct("candy");
    }
    assertEquals("SOLD OUT", vendingMachine.requestProduct("candy"));
  }

  @Test
  public void whenInsufficientMoneyIsEnteredProductRequestReturnsPriceReminder() {
    assertEquals("PRICE: $1.00", vendingMachine.requestProduct("cola"));
    assertEquals("PRICE: $0.50", vendingMachine.requestProduct("chips"));
    assertEquals("PRICE: $0.65", vendingMachine.requestProduct("candy"));
  }

  @Test
  public void whenUserRequestsCoinReturnCurrentTotalIsSetToZero() {
    vendingMachine.addCoin("nickel");
    vendingMachine.returnCoinsForCurrentTotal();
    assertEquals(0, vendingMachine.getCurrentTotalInCents());
  }

  @Test
  public void whenCoinsAreReturnedUserKnowsHowMuchMoneyIsReturned() {
    addOneHundredCents();
    assertEquals("RETURNED: $1.00", vendingMachine.returnCoinsForCurrentTotal());
  }

  @Test
  public void whenUserBuysProductExcessMoneyIsReturned() {
    addOneHundredCents();
    vendingMachine.requestProduct("candy");
    assertEquals("RETURNED: $0.35", vendingMachine.getLastReturnCoinMessage());
  }

  @Test
  public void whenVendingMachineDisplays35CentsItFormatsTheOutput() {
    assertEquals("$0.35", vendingMachine.formatCentsForOutput(35));
  }

  @Test
  public void whenVendingMachineDisplays115CentsItFormatsTheOutput() {
    assertEquals("$1.15", vendingMachine.formatCentsForOutput(115));
  }

  @Test
  public void whenVendingMachineIsNewThereAreAtLeastThreeQuartersDimesAndNickelsStored() {
    assertEquals(true, vendingMachine.getCurrentNumberOfQuarters() >= 3);
    assertEquals(true, vendingMachine.getCurrentNumberOfDimes() >= 3);
    assertEquals(true, vendingMachine.getCurrentNumberOfNickels() >= 3);
  }

  @Test
  public void whenUserInsertsCoinsVendingMachineAddsThemToCoinStorage() {
    int initialNumberOfQuarters = vendingMachine.getCurrentNumberOfQuarters();
    int initialNumberOfDimes = vendingMachine.getCurrentNumberOfDimes();
    int initialNumberOfNickels = vendingMachine.getCurrentNumberOfNickels();
    vendingMachine.addCoin("nickel");
    vendingMachine.addCoin("dime");
    vendingMachine.addCoin("quarter");
    assertEquals(initialNumberOfQuarters + 1, vendingMachine.getCurrentNumberOfQuarters());
    assertEquals(initialNumberOfDimes + 1, vendingMachine.getCurrentNumberOfDimes());
    assertEquals(initialNumberOfNickels + 1, vendingMachine.getCurrentNumberOfNickels());
  }

  @Test
  public void whenVendingMachineHasThreeQuartersAndNeedsToReturn100CentsItReturnsThreeQuarters() {
    vendingMachine.setCurrentTotalInCents(100);
    vendingMachine.returnQuarters();
    assertEquals(25, vendingMachine.getCurrentTotalInCents());
    assertEquals(0, vendingMachine.getCurrentNumberOfQuarters());
  }

  @Test
  public void whenVendingMachineHasThreeQuartersAndNeedsToReturn25CentsItReturnsOneQuarter() {
    vendingMachine.setCurrentTotalInCents(25);
    vendingMachine.returnQuarters();
    assertEquals(0, vendingMachine.getCurrentTotalInCents());
    assertEquals(2, vendingMachine.getCurrentNumberOfQuarters());
  }

}
