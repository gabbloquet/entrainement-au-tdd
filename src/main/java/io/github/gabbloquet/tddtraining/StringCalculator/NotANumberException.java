package io.github.gabbloquet.tddtraining.StringCalculator;

public class NotANumberException extends Exception {
  public NotANumberException() {
    super("Number expected but \n or , found..");
  }
}
