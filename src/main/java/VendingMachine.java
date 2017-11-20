public class VendingMachine {

  private int currentTotalInCents;

  public int getCurrentTotalInCents() {
    return currentTotalInCents;
  }

  public void addCoin(String coinString) {
    currentTotalInCents += 5;
  }

  public String requestProduct(String productString) {
    return "COLA DISPENSED";
  }

  public void returnAllCoins() {
    currentTotalInCents = 0;
  }

}
