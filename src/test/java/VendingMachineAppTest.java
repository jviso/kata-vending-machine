import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class VendingMachineAppTest {

  VendingMachineApp app;

  @Before
  public void setUp() {
    app = new VendingMachineApp();
  }

  @Test
  public void whenVendingMachineAppStartsDisplayMessageIsInsertCoin() {
    assertEquals("INSERT COIN", app.getCurrentDisplayMessage());
  }

  @Test
  public void whenVendingMachineAppStartsItHasAVendingMachineObject() {
    assertNotNull(app.vendingMachine);
  }

}
