package edu.austral.ingsis.math.entities.functions.unaryoperators;

import edu.austral.ingsis.math.abs.UnaryOperator;
import edu.austral.ingsis.math.interfaces.Function;

public class Module extends UnaryOperator {

  public Module(Function f) {
    super(f);
  }

  public Module(Double f) {
    super(f);
  }

  public Module(String f) {
    super(f);
  }

  @Override
  public Double calculate(Double a) {
    return Math.abs(a);
  }

  @Override
  public String toString(String f) {
    return "|" + f + "|";
  }
}
