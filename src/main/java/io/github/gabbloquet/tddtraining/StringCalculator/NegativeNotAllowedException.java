package io.github.gabbloquet.tddtraining.StringCalculator;

public class NegativeNotAllowedException extends Exception {
  public NegativeNotAllowedException(String negatives) {
    super("Negative not allowed : " + negatives);
  }
}
