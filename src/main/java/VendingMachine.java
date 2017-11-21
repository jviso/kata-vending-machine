public class VendingMachine {

  private int currentTotalInCents;
  private int currentColaInventory;
  private int currentChipsInventory;
  private int currentCandyInventory;

  public VendingMachine() {
    currentColaInventory = 1;
    currentChipsInventory = 1;
    currentCandyInventory = 1;
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

  public void addCoin(String coinString) {
    if (coinString.equals("nickel")) {
      currentTotalInCents += 5;
    }
    else if (coinString.equals("dime")) {
      currentTotalInCents += 10;
    }
    else if (coinString.equals("quarter")) {
      currentTotalInCents += 25;
    }
  }

  public String requestProduct(String productString) {
    if (!checkIfProductIsInStock(productString)) {
      return "SOLD OUT";
    }
    if (!checkIfUserHasEnteredSufficientMoneyToBuyProduct(productString)) {
      return String.format("PRICE: $%.2f", (getPrice(productString) / 100.0));
    }
    switch (productString) {
      case "cola":
        currentColaInventory -= 1;
        return "COLA DISPENSED%nTHANK YOU";
      case "chips":
        currentChipsInventory -= 1;
        return "CHIPS DISPENSED%nTHANK YOU";
      case "candy":
        currentCandyInventory -= 1;
        return "CANDY DISPENSED%nTHANK YOU";
      default:
        return "ERROR: INVALID PRODUCT";
    }
  }

  public void returnAllCoins() {
    currentTotalInCents = 0;
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
