public class VendingMachineApp {

  VendingMachine vendingMachine;
  private String currentDisplayMessage;

  public VendingMachineApp() {
    vendingMachine = new VendingMachine();
    currentDisplayMessage = "INSERT COIN";
  }

  public String getCurrentDisplayMessage() {
    return currentDisplayMessage;
  }

  public void checkIfExactChangeIsNeeded() {
    // There are two scenarios where exact change matters:
    //    (1) user enters seven dimes to buy candy (needs one nickel back)
    //    (2) user enters three quarters to buy candy (needs one dime or two nickels back)
    // In all other scenarios, the limited number of coins accepted and products offered means that any change needed
    // would have been entered by the user.
    if ((vendingMachine.getCurrentNumberOfDimes() < 1 && vendingMachine.getCurrentNumberOfNickels() < 2)
          || (vendingMachine.getCurrentNumberOfNickels() < 1)) {
      currentDisplayMessage = "EXACT CHANGE ONLY";
    }
  }

}
