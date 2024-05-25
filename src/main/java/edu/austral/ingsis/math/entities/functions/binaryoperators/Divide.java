package edu.austral.ingsis.math.entities.functions.binaryoperators;

import edu.austral.ingsis.math.abs.BinaryOperator;
import edu.austral.ingsis.math.interfaces.Function;

public class Divide extends BinaryOperator {

  public Divide(Function a, Function b) {
    super(a, b);
  }

  public Divide(Double a, Function b) {
    super(a, b);
  }

  public Divide(Function a, Double b) {
    super(a, b);
  }

  public Divide(Double a, Double b) {
    super(a, b);
  }

  public Divide(String a, Function b) {
    super(a, b);
  }

  public Divide(Function a, String b) {
    super(a, b);
  }

  public Divide(String a, String b) {
    super(a, b);
  }

  public Divide(String a, Double b) {
    super(a, b);
  }

  public Divide(Double a, String b) {
    super(a, b);
  }

  @Override
  public Double calculate(Double a, Double b) {
    return a / b;
  }

  @Override
  public String toString() {
    return "/";
  }
}
