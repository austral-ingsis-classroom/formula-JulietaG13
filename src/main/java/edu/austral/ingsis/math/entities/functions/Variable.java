package edu.austral.ingsis.math.entities.functions;

import edu.austral.ingsis.math.interfaces.Function;
import edu.austral.ingsis.math.interfaces.FunctionVisitor;

public class Variable implements Function {
  private final String name;

  public Variable(String name) {
    this.name = name;
  }

  @Override
  public void accept(FunctionVisitor visitor) {
    visitor.visit(this);
  }

  public String getName() {
    return name;
  }
}
