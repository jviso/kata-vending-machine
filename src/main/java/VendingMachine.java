public class VendingMachine {

  private int currentTotalInCents;
  private int currentColaInventory;
  private int currentChipsInventory;
  private int currentCandyInventory;
  private int currentNumberOfQuarters;
  private int currentNumberOfDimes;
  private int currentNumberOfNickels;
  private String lastReturnCoinMessage;

  public VendingMachine() {
    currentColaInventory = 1;
    currentChipsInventory = 1;
    currentCandyInventory = 1;
    currentNumberOfQuarters = 3;
    currentNumberOfDimes = 3;
    currentNumberOfNickels = 3;
  }

  public int getCurrentTotalInCents() {
    return currentTotalInCents;
  }

  public int getColaInventory() {
    return currentColaInventory;
  }

  public int getChipsInventory() {
    return currentChipsInventory;
  }

  public int getCandyInventory() {
    return currentCandyInventory;
  }

  public int getCurrentNumberOfQuarters() {
    return currentNumberOfQuarters;
  }

  public int getCurrentNumberOfDimes() {
    return currentNumberOfDimes;
  }

  public int getCurrentNumberOfNickels() {
    return currentNumberOfNickels;
  }

  public String getLastReturnCoinMessage() {
    return lastReturnCoinMessage;
  }

  public String addCoin(String coinString) {
    if (coinString.equals("nickel")) {
      currentTotalInCents += 5;
      currentNumberOfNickels += 1;
    }
    else if (coinString.equals("dime")) {
      currentTotalInCents += 10;
      currentNumberOfDimes += 1;
    }
    else if (coinString.equals("quarter")) {
      currentTotalInCents += 25;
      currentNumberOfQuarters += 1;
    }
    return String.format("$%.2f", (currentTotalInCents / 100.0));
  }

  public String requestProduct(String productString) {
    if (!checkIfProductIsInStock(productString)) {
      return "SOLD OUT";
    }
    if (!checkIfUserHasEnteredSufficientMoneyToBuyProduct(productString)) {
      return String.format("PRICE: $%.2f", (getPrice(productString) / 100.0));
    }
    return dispenseProduct(productString);
  }

  public String dispenseProduct(String productString) {
    switch (productString) {
      case "cola":
        currentColaInventory -= 1;
        currentTotalInCents -= 100;
        returnAllCoins();
        return "COLA DISPENSED%nTHANK YOU";
      case "chips":
        currentChipsInventory -= 1;
        currentTotalInCents -= 50;
        returnAllCoins();
        return "CHIPS DISPENSED%nTHANK YOU";
      case "candy":
        currentCandyInventory -= 1;
        currentTotalInCents -= 65;
        returnAllCoins();
        return "CANDY DISPENSED%nTHANK YOU";
      default:
        return "ERROR: INVALID PRODUCT";
    }
  }

  public String returnAllCoins() {
    int previousTotalInCents = getCurrentTotalInCents();
    currentTotalInCents = 0;
    lastReturnCoinMessage = String.format("RETURNED: $%.2f", (previousTotalInCents / 100.0));
    return lastReturnCoinMessage;
  }

  public int getPrice(String productString) {
    if (productString.equals("cola")) {
      return 100;
    }
    else if (productString.equals("chips")) {
      return 50;
    }
    else {
      return 65;
    }
  }

  public boolean checkIfUserHasEnteredSufficientMoneyToBuyProduct(String productString) {
    if (currentTotalInCents >= getPrice(productString)) {
      return true;
    }
    else {
      return false;
    }
  }

  public boolean checkIfProductIsInStock(String productString) {
    if (productString.equals("cola")) {
      return (getColaInventory() > 0);
    }
    else if (productString.equals("chips")) {
      return (getChipsInventory() > 0);
    }
    else {
      return (getCandyInventory() > 0);
    }
  }

}
