import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;
import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestMain {

  @Rule
  public final ExpectedException exception = ExpectedException.none();

  CoreMatchers matcher = new CoreMatchers();

  @Test
  public void divisionShouldThrowArithmeticExceptionIfSecondArgumentZero() {
    exception.expect(ArithmeticException.class);
    exception.expectMessage("Divider can not be null");
    Main.division(1233, 0);
  }

  @Test
  public void resultStringShouldFilterInputByChar() {
    List<String> inputList = Arrays.asList("Test", "Or", "Not", "To", "Test");

    assertThat(Main.filterListByFirstChar(inputList, "T"), hasItems("Test", "To", "Test"));
  }

  @Test
  public void shouldReturnTrimmedString() {
    assertFalse(Main.trimAllWhitespace("There should not be spaces").contains(" "));
  }
}
