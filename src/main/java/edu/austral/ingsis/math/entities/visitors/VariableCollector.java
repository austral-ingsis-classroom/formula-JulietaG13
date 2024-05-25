package edu.austral.ingsis.math.entities.visitors;

import edu.austral.ingsis.math.abs.BinaryOperator;
import edu.austral.ingsis.math.abs.UnaryOperator;
import edu.austral.ingsis.math.entities.functions.Number;
import edu.austral.ingsis.math.entities.functions.Variable;
import edu.austral.ingsis.math.interfaces.Function;
import edu.austral.ingsis.math.interfaces.FunctionVisitor;
import java.util.ArrayList;
import java.util.List;

public class VariableCollector implements FunctionVisitor {
  private final List<String> variables = new ArrayList<>();

  public VariableCollector(Function f) {
    f.accept(this);
  }

  public List<String> getVariables() {
    return variables;
  }

  @Override
  public void visit(BinaryOperator bop) {
    bop.getA().accept(this);
    bop.getB().accept(this);
  }

  @Override
  public void visit(UnaryOperator nop) {
    nop.getF().accept(this);
  }

  @Override
  public void visit(Number number) {}

  @Override
  public void visit(Variable variable) {
    variables.add(variable.getName());
  }
}
