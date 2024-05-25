package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.entities.functions.Variable;
import edu.austral.ingsis.math.entities.functions.binaryoperators.Add;
import edu.austral.ingsis.math.entities.functions.binaryoperators.Divide;
import edu.austral.ingsis.math.entities.functions.binaryoperators.Multiply;
import edu.austral.ingsis.math.entities.functions.binaryoperators.Power;
import edu.austral.ingsis.math.entities.functions.binaryoperators.Subtract;
import edu.austral.ingsis.math.entities.functions.unaryoperators.Module;
import edu.austral.ingsis.math.entities.visitors.Printer;
import edu.austral.ingsis.math.interfaces.Function;
import org.junit.jupiter.api.Test;

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    final String expected = "1 + 6";

    Function f = new Add(1.0, 6.0);
    final String result = new Printer(f).getString();

    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    final String expected = "12 / 2";

    Function f = new Divide(12.0, 2.0);
    final String result = new Printer(f).getString();

    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    final String expected = "(9 / 2) * 3";

    Function f = new Multiply(new Divide(9.0, 2.0), 3.0);
    final String result = new Printer(f).getString();

    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    final String expected = "(27 / 6) ^ 2";

    Function f = new Power(new Divide(27.0, 6.0), 2.0);
    final String result = new Printer(f).getString();

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    final String expected = "|value| - 8";

    Function f = new Subtract(new Module("value"), 8.0);
    final String result = new Printer(f).getString();

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction7() {
    final String expected = "|value| - 8";

    Function f = new Subtract(new Module("value"), 8.0);
    final String result = new Printer(f).getString();

    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    final String expected = "(5 - i) * 8";

    Function f = new Multiply(new Subtract(5.0, new Variable("i")), 8.0);
    final String result = new Printer(f).getString();

    assertThat(result, equalTo(expected));
  }
}
