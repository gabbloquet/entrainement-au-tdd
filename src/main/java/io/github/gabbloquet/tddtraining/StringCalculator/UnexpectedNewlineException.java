package io.github.gabbloquet.tddtraining.StringCalculator;

public class UnexpectedNewlineException extends Exception {
  public UnexpectedNewlineException(int position) {
    super("Nombre attendu mais '\n' trouvé en position " + position + ".");
  }
}
