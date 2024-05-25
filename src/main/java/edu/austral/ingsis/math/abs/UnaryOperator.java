package edu.austral.ingsis.math.abs;

import edu.austral.ingsis.math.entities.functions.Number;
import edu.austral.ingsis.math.entities.functions.Variable;
import edu.austral.ingsis.math.interfaces.Function;
import edu.austral.ingsis.math.interfaces.FunctionVisitor;

public abstract class UnaryOperator implements Function {
  protected Function f;

  public abstract Double calculate(Double f);

  public UnaryOperator(Function f) {
    this.f = f;
  }

  public String toString(String f) {
    return toString() + f;
  }

  public Function getF() {
    return f;
  }

  @Override
  public void accept(FunctionVisitor visitor) {
    visitor.visit(this);
  }

  /*--------------------------------------------------*/

  public UnaryOperator(Double f) {
    this(new Number(f));
  }

  public UnaryOperator(String f) {
    this(new Variable(f));
  }
}
