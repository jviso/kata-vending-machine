import java.util.Scanner;

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

  public void runLoop() {
    boolean continueRunning = true;
    String currentInput = "";
    Scanner inputReader = new Scanner(System.in);
    printInstructions();
    System.out.println(currentDisplayMessage);
    while (continueRunning) {
      checkIfExactChangeIsNeeded();
      currentInput = inputReader.nextLine();
      switch (currentInput) {
        case "q":
          System.out.println(vendingMachine.addCoin("quarter"));
          break;
        case "d":
          System.out.println(vendingMachine.addCoin("dime"));
          break;
        case "n":
          System.out.println(vendingMachine.addCoin("nickel"));
          break;
        case "p":
          System.out.println("COIN NOT ACCEPTED");
          break;
        case "cola":
          System.out.println(vendingMachine.requestProduct("cola"));
          System.out.println(currentDisplayMessage);
          break;
        case "chips":
          System.out.println(vendingMachine.requestProduct("chips"));
          System.out.println(currentDisplayMessage);
          break;
        case "candy":
          System.out.println(vendingMachine.requestProduct("candy"));
          System.out.println(currentDisplayMessage);
          break;
        case "return":
          System.out.println(vendingMachine.returnCoinsForCurrentTotal());
          System.out.println(currentDisplayMessage);
          break;
        case "exit":
          System.out.println("Goodbye!");
          continueRunning = false;
          break;
        case "help":
          printInstructions();
          break;
        default:
          System.out.println("Sorry, that input isn't valid. Enter 'help' to review accepted commands.");
          break;
      }
    }
    System.exit(0);
  }

  public void printInstructions() {
    System.out.println(
      "Hello! Here are the available commands for this vending machine simulation.\n"
      + "Enter 'q', 'd', 'n', or 'p' to insert a quarter, dime, nickel, or penny, respectively.\n"
      + "Enter 'cola', 'chips', or 'candy' to request any of these products.\n"
      + "Enter 'return' to request a coin return.\n"
      + "Enter 'exit' to exit the simulation.\n"
      + "Enter 'help' to see these instructions again.\n");
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
    else {
      currentDisplayMessage = "INSERT COIN";
    }
  }

}
