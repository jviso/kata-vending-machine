public class VendingMachine {

  private int currentTotalInCents;

  public int getCurrentTotalInCents() {
    return currentTotalInCents;
  }

  public void addCoin(String coinString) {
    if (coinString.equals("nickel")) {
      currentTotalInCents += 5;
    }
    else {
      currentTotalInCents += 10;
    }
  }

  public String requestProduct(String productString) {
    return "COLA DISPENSED";
  }

  public void returnAllCoins() {
    currentTotalInCents = 0;
  }

}
