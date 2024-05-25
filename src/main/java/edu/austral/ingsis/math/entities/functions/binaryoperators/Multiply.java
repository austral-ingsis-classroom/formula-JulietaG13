package edu.austral.ingsis.math.entities.functions.binaryoperators;

import edu.austral.ingsis.math.abs.BinaryOperator;
import edu.austral.ingsis.math.interfaces.Function;

public class Multiply extends BinaryOperator {

  public Multiply(Function a, Function b) {
    super(a, b);
  }

  public Multiply(Double a, Function b) {
    super(a, b);
  }

  public Multiply(Function a, Double b) {
    super(a, b);
  }

  public Multiply(Double a, Double b) {
    super(a, b);
  }

  public Multiply(String a, Function b) {
    super(a, b);
  }

  public Multiply(Function a, String b) {
    super(a, b);
  }

  public Multiply(String a, String b) {
    super(a, b);
  }

  public Multiply(String a, Double b) {
    super(a, b);
  }

  public Multiply(Double a, String b) {
    super(a, b);
  }

  @Override
  public Double calculate(Double a, Double b) {
    return a * b;
  }

  @Override
  public String toString() {
    return "*";
  }
}
