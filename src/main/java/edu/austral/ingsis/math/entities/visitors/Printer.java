package edu.austral.ingsis.math.entities.visitors;

import edu.austral.ingsis.math.abs.BinaryOperator;
import edu.austral.ingsis.math.abs.UnaryOperator;
import edu.austral.ingsis.math.entities.functions.Number;
import edu.austral.ingsis.math.entities.functions.Variable;
import edu.austral.ingsis.math.interfaces.Function;
import edu.austral.ingsis.math.interfaces.FunctionVisitor;
import java.util.Stack;

public class Printer implements FunctionVisitor {
  private final Stack<String> func = new Stack<>();
  private String str = "";

  public Printer(Function f) {
    f.accept(this);
  }

  public String getString() {
    if (str.isEmpty()) {
      str = func.pop();
      str = str.substring(1, str.length() - 1);
    }
    return str;
  }

  @Override
  public void visit(BinaryOperator bop) {
    bop.getB().accept(this);
    bop.getA().accept(this);
    func.push(bop.toString(func.pop(), func.pop()));
  }

  @Override
  public void visit(UnaryOperator nop) {
    nop.getF().accept(this);
    func.push(nop.toString(func.pop()));
  }

  @Override
  public void visit(Number number) {
    double num = number.getValue();
    if (num % 1 == 0) {
      func.push(String.valueOf((int) num));
    } else {
      func.push(String.valueOf(num));
    }
  }

  @Override
  public void visit(Variable variable) {
    func.push(variable.getName());
  }
}
