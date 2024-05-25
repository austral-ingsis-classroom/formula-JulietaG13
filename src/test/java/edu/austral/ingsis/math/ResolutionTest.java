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
import org.junit.jupiter.api.Test;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    Function f = new Add(1d, 6d);
    final Double result = new Resolver(f).getResult();

    assertThat(result, equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    Function f = new Divide(12d, 2d);
    final Double result = new Resolver(f).getResult();

    assertThat(result, equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    Function f = new Multiply(new Divide(9d, 2d), 3d);
    final Double result = new Resolver(f).getResult();

    assertThat(result, equalTo(13.5));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    Function f = new Power(new Divide(27d, 6d), 2d);
    final Double result = new Resolver(f).getResult();

    assertThat(result, equalTo(20.25));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    Function f = new SquareRoot(36d);
    final Double result = new Resolver(f).getResult();

    assertThat(result, equalTo(6d));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    Function f = new Module(136d);
    final Double result = new Resolver(f).getResult();

    assertThat(result, equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    Function f = new Module(-136d);
    final Double result = new Resolver(f).getResult();

    assertThat(result, equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    Function f = new Multiply(new Subtract(5d, 5d), 8d);
    final Double result = new Resolver(f).getResult();

    assertThat(result, equalTo(0d));
  }
}
