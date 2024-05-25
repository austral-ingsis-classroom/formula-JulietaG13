package edu.austral.ingsis.math.entities.functions.binaryoperators;

import edu.austral.ingsis.math.abs.BinaryOperator;
import edu.austral.ingsis.math.interfaces.Function;

public class Subtract extends BinaryOperator {

  public Subtract(Function a, Function b) {
    super(a, b);
  }

  public Subtract(Double a, Function b) {
    super(a, b);
  }

  public Subtract(Function a, Double b) {
    super(a, b);
  }

  public Subtract(Double a, Double b) {
    super(a, b);
  }

  public Subtract(String a, Function b) {
    super(a, b);
  }

  public Subtract(Function a, String b) {
    super(a, b);
  }

  public Subtract(String a, String b) {
    super(a, b);
  }

  public Subtract(String a, Double b) {
    super(a, b);
  }

  public Subtract(Double a, String b) {
    super(a, b);
  }

  @Override
  public Double calculate(Double a, Double b) {
    return a - b;
  }

  @Override
  public String toString() {
    return "-";
  }
}
