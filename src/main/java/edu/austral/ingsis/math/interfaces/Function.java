package edu.austral.ingsis.math.interfaces;

public interface Function {
  void accept(FunctionVisitor visitor);
}
