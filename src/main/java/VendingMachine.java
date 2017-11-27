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

  public void setCurrentTotalInCents(int cents) {
    currentTotalInCents = cents;
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
    return formatCentsForOutput(currentTotalInCents);
  }

  public String requestProduct(String productString) {
    if (!checkIfProductIsInStock(productString)) {
      return "SOLD OUT";
    }
    if (!checkIfUserHasEnteredSufficientMoneyToBuyProduct(productString)) {
      return "PRICE: " + formatCentsForOutput(getPrice(productString));
    }
    return dispenseProduct(productString);
  }

  public String dispenseProduct(String productString) {
    switch (productString) {
      case "cola":
        currentColaInventory -= 1;
        currentTotalInCents -= 100;
        returnCoinsForCurrentTotal();
        return "COLA DISPENSED%nTHANK YOU";
      case "chips":
        currentChipsInventory -= 1;
        currentTotalInCents -= 50;
        returnCoinsForCurrentTotal();
        return "CHIPS DISPENSED%nTHANK YOU";
      case "candy":
        currentCandyInventory -= 1;
        currentTotalInCents -= 65;
        returnCoinsForCurrentTotal();
        return "CANDY DISPENSED%nTHANK YOU";
      default:
        return "ERROR: INVALID PRODUCT";
    }
  }

  public String returnCoinsForCurrentTotal() {
    int previousTotalInCents = getCurrentTotalInCents();
    currentTotalInCents = 0;
    lastReturnCoinMessage = "RETURNED: " + formatCentsForOutput(previousTotalInCents);
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
    return (currentTotalInCents >= getPrice(productString));
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

  public String formatCentsForOutput(int cents) {
    double dollars = cents / 100.0;
    return String.format("$%.2f", dollars);
  }

  public void returnQuarters() {
    while ((getCurrentNumberOfQuarters() > 0) && (currentTotalInCents / 25 > 0)) {
      currentNumberOfQuarters -= 1;
      currentTotalInCents -= 25;
    } 
  }

  public void returnDimes() {
    while ((getCurrentNumberOfDimes() > 0) && (currentTotalInCents / 10 > 0)) {
      currentNumberOfDimes -= 1;
      currentTotalInCents -= 10;
    }
  }

  public void returnNickels() {
    while ((getCurrentNumberOfNickels() > 0) && (currentTotalInCents / 5 > 0)) {
      currentNumberOfNickels -= 1;
      currentTotalInCents -= 5;
    }
  }

}
