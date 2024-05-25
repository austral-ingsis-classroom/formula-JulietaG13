package edu.austral.ingsis.math.interfaces;

import edu.austral.ingsis.math.abs.BinaryOperator;
import edu.austral.ingsis.math.abs.UnaryOperator;
import edu.austral.ingsis.math.entities.functions.Number;
import edu.austral.ingsis.math.entities.functions.Variable;

public interface FunctionVisitor {
  void visit(BinaryOperator bop);

  void visit(UnaryOperator nop);

  void visit(Number number);

  void visit(Variable variable);
}
