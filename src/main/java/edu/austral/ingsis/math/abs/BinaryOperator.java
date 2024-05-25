package edu.austral.ingsis.math.abs;

import edu.austral.ingsis.math.entities.functions.Number;
import edu.austral.ingsis.math.entities.functions.Variable;
import edu.austral.ingsis.math.interfaces.Function;
import edu.austral.ingsis.math.interfaces.FunctionVisitor;

public abstract class BinaryOperator implements Function {
  protected Function a;
  protected Function b;

  public abstract Double calculate(Double a, Double b);

  public BinaryOperator(Function a, Function b) {
    this.a = a;
    this.b = b;
  }

  public String toString(String a, String b) {
    return "(" + a + " " + toString() + " " + b + ")";
  }

  public Function getA() {
    return a;
  }

  public Function getB() {
    return b;
  }

  @Override
  public void accept(FunctionVisitor visitor) {
    visitor.visit(this);
  }

  /*--------------------------------------------------*/

  public BinaryOperator(Double a, Function b) {
    this(new Number(a), b);
  }

  public BinaryOperator(Function a, Double b) {
    this(a, new Number(b));
  }

  public BinaryOperator(Double a, Double b) {
    this(new Number(a), new Number(b));
  }

  public BinaryOperator(String a, Function b) {
    this(new Variable(a), b);
  }

  public BinaryOperator(Function a, String b) {
    this(a, new Variable(b));
  }

  public BinaryOperator(String a, String b) {
    this(new Variable(a), new Variable(b));
  }

  public BinaryOperator(String a, Double b) {
    this(new Variable(a), new Number(b));
  }

  public BinaryOperator(Double a, String b) {
    this(new Number(a), new Variable(b));
  }
}
