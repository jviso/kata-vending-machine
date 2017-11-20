public class VendingMachine {

  private int currentTotalInCents;

  public int getCurrentTotalInCents() {
    return currentTotalInCents;
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
    return "COLA DISPENSED";
  }

  public void returnAllCoins() {
    currentTotalInCents = 0;
  }

  public int getPrice(String productString) {
    return 100;
  }

}
