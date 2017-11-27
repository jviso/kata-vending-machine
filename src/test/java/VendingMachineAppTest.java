import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class VendingMachineAppTest {

  VendingMachineApp vendingMachineApp;

  @Before
  public void setUp() {
    vendingMachineApp = new VendingMachineApp();
  }

  @Test
  public void whenVendingMachineAppStartsDisplayMessageIsInsertCoin() {
    assertEquals("INSERT COIN", vendingMachineApp.getCurrentDisplayMessage());
  }

}
