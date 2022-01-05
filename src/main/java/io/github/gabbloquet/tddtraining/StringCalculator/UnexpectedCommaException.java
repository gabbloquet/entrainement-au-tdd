package io.github.gabbloquet.tddtraining.StringCalculator;

public class UnexpectedCommaException extends Exception {
  public UnexpectedCommaException(String delimiter, int position) {
    super("'" + delimiter + "' expected but ',' found at position " + position + ".");
  }
}
