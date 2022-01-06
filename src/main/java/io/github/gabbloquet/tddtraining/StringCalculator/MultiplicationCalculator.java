package io.github.gabbloquet.tddtraining.StringCalculator;

import java.util.List;

public class MultiplicationCalculator extends StringCalculator {
  public String calculate(String operation) throws UnexpectedNewlineException, NotANumberException, UnexpectedCommaException, NegativeNotAllowedException, NotCompliantOperationException {
    if(operation.isEmpty())
      return "0";

    checkOperationCompliance(operation);
    String delimiter = getDelimiter(operation);
    operation = cleanOperation(operation, delimiter);

    List<String> terms = getTerms(operation, delimiter);
    if(terms.size() == 1)
      return operation;

    float result = terms.stream()
      .map(Float::parseFloat)
      .reduce((float) 1, (subMultiplication, term) -> subMultiplication * term);

    return toString(result);
  }
}
