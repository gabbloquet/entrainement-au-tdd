package io.github.gabbloquet.tddtraining.Stack;

public class UnderflowException extends Exception {
  public UnderflowException() {
    super("Il est impossible de retirer un élément d'une pile vide.");
  }
}
