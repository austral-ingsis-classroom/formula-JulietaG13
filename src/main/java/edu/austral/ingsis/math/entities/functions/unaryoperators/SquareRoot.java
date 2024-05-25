package edu.austral.ingsis.math.entities.functions.unaryoperators;

import edu.austral.ingsis.math.abs.UnaryOperator;
import edu.austral.ingsis.math.interfaces.Function;

public class SquareRoot extends UnaryOperator {

  public SquareRoot(Function f) {
    super(f);
  }

  public SquareRoot(Double f) {
    super(f);
  }

  public SquareRoot(String f) {
    super(f);
  }

  @Override
  public Double calculate(Double a) {
    return Math.pow(a, 0.5);
  }

  @Override
  public String toString(String f) {
    return f + " ^ (1/2)";
  }

  @Override
  public String toString() {
    return "√";
  }
}
