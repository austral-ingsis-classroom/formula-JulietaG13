package edu.austral.ingsis.math.entities.functions;

import edu.austral.ingsis.math.interfaces.Function;
import edu.austral.ingsis.math.interfaces.FunctionVisitor;

public class Number implements Function {
  private final Double value;

  public Number(Double value) {
    this.value = value;
  }

  @Override
  public void accept(FunctionVisitor visitor) {
    visitor.visit(this);
  }

  public double getValue() {
    return value;
  }
}
