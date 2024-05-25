package edu.austral.ingsis.math.entities.functions.binaryoperators;

import edu.austral.ingsis.math.abs.BinaryOperator;
import edu.austral.ingsis.math.interfaces.Function;

public class Add extends BinaryOperator {

  public Add(Function a, Function b) {
    super(a, b);
  }

  public Add(Double a, Function b) {
    super(a, b);
  }

  public Add(Function a, Double b) {
    super(a, b);
  }

  public Add(Double a, Double b) {
    super(a, b);
  }

  public Add(String a, Function b) {
    super(a, b);
  }

  public Add(Function a, String b) {
    super(a, b);
  }

  public Add(String a, String b) {
    super(a, b);
  }

  public Add(String a, Double b) {
    super(a, b);
  }

  public Add(Double a, String b) {
    super(a, b);
  }

  @Override
  public Double calculate(Double a, Double b) {
    return a + b;
  }

  @Override
  public String toString() {
    return "+";
  }
}
