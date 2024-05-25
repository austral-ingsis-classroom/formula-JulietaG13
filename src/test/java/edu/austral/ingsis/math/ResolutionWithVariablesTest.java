package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.entities.functions.binaryoperators.Add;
import edu.austral.ingsis.math.entities.functions.binaryoperators.Divide;
import edu.austral.ingsis.math.entities.functions.binaryoperators.Multiply;
import edu.austral.ingsis.math.entities.functions.binaryoperators.Power;
import edu.austral.ingsis.math.entities.functions.binaryoperators.Subtract;
import edu.austral.ingsis.math.entities.functions.unaryoperators.Module;
import edu.austral.ingsis.math.entities.functions.unaryoperators.SquareRoot;
import edu.austral.ingsis.math.entities.visitors.Resolver;
import edu.austral.ingsis.math.interfaces.Function;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    Map<String, Double> values = Map.of("x", 3d);

    Function f = new Add(1d, "x");
    final Double result = new Resolver(f, values).getResult();

    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    Map<String, Double> values = Map.of("div", 4d);

    Function f = new Divide(12d, "div");
    final Double result = new Resolver(f, values).getResult();

    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    Map<String, Double> values =
        Map.of(
            "x", 3d,
            "y", 4d);

    Function f = new Multiply(new Divide(9d, "x"), "y");
    final Double result = new Resolver(f, values).getResult();

    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    Map<String, Double> values =
        Map.of(
            "a", 9d,
            "b", 3d);

    Function f = new Power(new Divide(27d, "a"), "b");
    final Double result = new Resolver(f, values).getResult();

    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    Map<String, Double> values = Map.of("z", 36d);

    Function f = new SquareRoot("z");
    final Double result = new Resolver(f, values).getResult();

    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    Map<String, Double> values = Map.of("value", 8d);

    Function f = new Subtract(new Module("value"), 8d);
    final Double result = new Resolver(f, values).getResult();

    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    Map<String, Double> values = Map.of("value", 8d);

    Function f = new Subtract(new Module("value"), 8d);
    final Double result = new Resolver(f, values).getResult();

    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    Map<String, Double> values = Map.of("i", 2d);

    Function f = new Multiply(new Subtract(5d, "i"), 8d);
    final Double result = new Resolver(f, values).getResult();

    assertThat(result, equalTo(24d));
  }
}
