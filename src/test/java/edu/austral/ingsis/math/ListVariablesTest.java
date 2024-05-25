package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import edu.austral.ingsis.math.entities.functions.binaryoperators.Add;
import edu.austral.ingsis.math.entities.functions.binaryoperators.Divide;
import edu.austral.ingsis.math.entities.functions.binaryoperators.Multiply;
import edu.austral.ingsis.math.entities.functions.binaryoperators.Power;
import edu.austral.ingsis.math.entities.functions.binaryoperators.Subtract;
import edu.austral.ingsis.math.entities.functions.unaryoperators.Module;
import edu.austral.ingsis.math.entities.functions.unaryoperators.SquareRoot;
import edu.austral.ingsis.math.entities.visitors.VariableCollector;
import edu.austral.ingsis.math.interfaces.Function;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    Function f = new Add(1d, 6d);
    final List<String> result = new VariableCollector(f).getVariables();

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    Function f = new Divide(12d, "div");
    final List<String> result = new VariableCollector(f).getVariables();

    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    Function f = new Multiply(new Divide(9d, "x"), "y");
    final List<String> result = new VariableCollector(f).getVariables();

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    Function f = new Power(new Divide(27d, "a"), "b");
    final List<String> result = new VariableCollector(f).getVariables();

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    Function f = new SquareRoot("z");
    final List<String> result = new VariableCollector(f).getVariables();

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    Function f = new Subtract(new Module("value"), 8d);
    final List<String> result = new VariableCollector(f).getVariables();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    Function f = new Subtract(new Module("value"), 8d);
    final List<String> result = new VariableCollector(f).getVariables();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    Function f = new Multiply(new Subtract(5d, "i"), 8d);
    final List<String> result = new VariableCollector(f).getVariables();

    assertThat(result, containsInAnyOrder("i"));
  }
}
