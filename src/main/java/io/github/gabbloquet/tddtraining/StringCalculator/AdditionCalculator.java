package io.github.gabbloquet.tddtraining.StringCalculator;

import org.springframework.expression.Operation;

public class AdditionCalculator extends StringCalculator {
  public String calculate(String operation) throws UnexpectedNewlineException, NotANumberException, UnexpectedCommaException, NegativeNotAllowedException, NotCompliantOperationException {
    return calculateWith(Operation.ADD ,operation);
  }
}
