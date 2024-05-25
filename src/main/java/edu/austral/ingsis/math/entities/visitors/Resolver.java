package edu.austral.ingsis.math.entities.visitors;

import edu.austral.ingsis.math.abs.BinaryOperator;
import edu.austral.ingsis.math.abs.UnaryOperator;
import edu.austral.ingsis.math.entities.functions.Number;
import edu.austral.ingsis.math.entities.functions.Variable;
import edu.austral.ingsis.math.interfaces.Function;
import edu.austral.ingsis.math.interfaces.FunctionVisitor;
import java.util.Map;
import java.util.Stack;

public class Resolver implements FunctionVisitor {
  private Map<String, Double> values;
  private Stack<Double> func = new Stack<>();
  private Double result;

  public Resolver(Function f, Map<String, Double> values) {
    this.values = values;
    f.accept(this);
  }

  public Resolver(Function f) {
    this(f, null);
  }

  public Double getResult() {
    if (result == null) {
      result = func.pop();
    }
    return result;
  }

  @Override
  public void visit(BinaryOperator bop) {
    bop.getB().accept(this);
    bop.getA().accept(this);

    func.push(bop.calculate(func.pop(), func.pop()));
  }

  @Override
  public void visit(UnaryOperator nop) {
    nop.getF().accept(this);

    func.push(nop.calculate(func.pop()));
  }

  @Override
  public void visit(Number number) {
    func.push(number.getValue());
  }

  @Override
  public void visit(Variable variable) {
    if (values.containsKey(variable.getName())) {
      func.push(values.get(variable.getName()));
      return;
    }
    throw new IllegalArgumentException("Variable " + variable.getName() + " is not defined");
  }
}
