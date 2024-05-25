package edu.austral.ingsis.math.entities.functions.binaryoperators;

import edu.austral.ingsis.math.abs.BinaryOperator;
import edu.austral.ingsis.math.interfaces.Function;

public class Power extends BinaryOperator {

  public Power(Function a, Function b) {
    super(a, b);
  }

  public Power(Double a, Function b) {
    super(a, b);
  }

  public Power(Function a, Double b) {
    super(a, b);
  }

  public Power(Double a, Double b) {
    super(a, b);
  }

  public Power(String a, Function b) {
    super(a, b);
  }

  public Power(Function a, String b) {
    super(a, b);
  }

  public Power(String a, String b) {
    super(a, b);
  }

  public Power(String a, Double b) {
    super(a, b);
  }

  public Power(Double a, String b) {
    super(a, b);
  }

  @Override
  public Double calculate(Double a, Double b) {
    return Math.pow(a, b);
  }

  @Override
  public String toString() {
    return "^";
  }
}
