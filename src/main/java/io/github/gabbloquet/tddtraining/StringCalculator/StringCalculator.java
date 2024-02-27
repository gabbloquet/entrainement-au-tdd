package io.github.gabbloquet.tddtraining.StringCalculator;

import org.springframework.expression.Operation;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public abstract class StringCalculator {

  private static final String DEFAULT_DELIMITER = ",";

  public abstract String calculate(String operation) throws UnexpectedNewlineException, NotANumberException, UnexpectedCommaException, NegativeNotAllowedException, NotCompliantOperationException;

  String calculateWith(Operation operationType, String operation) throws NegativeNotAllowedException, NotANumberException, NotCompliantOperationException, UnexpectedNewlineException, UnexpectedCommaException {
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
      .reduce((float) getStarterToReduce(operationType), getFunctionToReduce(operationType));

    return toString(result);
  }

  private int getStarterToReduce(Operation operationType) {
    return operationType == Operation.ADD ? 0 : 1;
  }

  private BinaryOperator<Float> getFunctionToReduce(Operation operationType) {
    return operationType == Operation.ADD
      ? Float::sum
      : (subMultiplication, term) -> subMultiplication * term;
  }

  String cleanOperation(String operation, String delimiter) {
    if(delimiter != null)
      return operation.substring(3 + delimiter.length());
    return operation;
  }

  String getDelimiter(String operation) {
    Pattern pattern = Pattern.compile("//(.*)\\n");
    Matcher matcher = pattern.matcher(operation);

    if(matcher.find())
      return matcher.group(1);
    return null;
  }

  List<String> getTerms(String operation, String delimiter) throws UnexpectedCommaException {
    if(delimiter != null) {
      checkDoubleDelimiter(operation, delimiter);
    } else {
      delimiter = DEFAULT_DELIMITER;
    }
    operation = operation.replace("\n", delimiter);
    return List.of(operation.split(getSplitter(delimiter)));
  }

  private void checkDoubleDelimiter(String operation, String delimiter) throws UnexpectedCommaException {
    int indexOfComma = operation.indexOf(",");
    if(indexOfComma != -1) {
      throw new UnexpectedCommaException(delimiter, indexOfComma);
    }
  }

  private String getSplitter(String delimiter) {
    if(delimiter.equals("|"))
      return "\\|";
    return delimiter;
  }

  void checkOperationCompliance(String operation) throws UnexpectedNewlineException, NotANumberException, NegativeNotAllowedException, NotCompliantOperationException {
    if(operation.endsWith(",") || operation.endsWith("\n"))
      throw new NotANumberException();

    int indexOfUnexpectedNewline = operation.indexOf(",\n");
    int indexOfUnexpectedComma = operation.indexOf(",,");
    String unexpectedNegatives = getNegatives(operation);

    if(areAtLeastTwoErrors(indexOfUnexpectedNewline, indexOfUnexpectedComma, unexpectedNegatives))
      throw new NotCompliantOperationException(indexOfUnexpectedNewline, indexOfUnexpectedComma, unexpectedNegatives);

    if(!unexpectedNegatives.isEmpty())
      throw new NegativeNotAllowedException(unexpectedNegatives);

    if(indexOfUnexpectedNewline != -1)
      throw new UnexpectedNewlineException(indexOfUnexpectedNewline + 1);
  }

  private boolean areAtLeastTwoErrors(int indexOfUnexpectedNewline, int indexOfUnexpectedComma, String unexpectedNegatives) {
    boolean isNewlineError = indexOfUnexpectedNewline != -1;
    boolean isCommaError = indexOfUnexpectedComma != -1;
    boolean areNegativesError = !unexpectedNegatives.isEmpty();
    return Stream.of(isNewlineError, isCommaError, areNegativesError)
      .filter(bool -> bool)
      .count() > 1;
  }

  private String getNegatives(String operation) {
    StringBuilder negatives = new StringBuilder();

    Pattern pattern = Pattern.compile("-(\\d*)");
    Matcher matcher = pattern.matcher(operation);

    while (matcher.find()) {
      if(negatives.isEmpty()){
        negatives.append("-").append(matcher.group(1));
      } else {
        negatives.append(", -").append(matcher.group(1));
      }
    }

    return negatives.toString();
  }

  String toString(float result) {
    DecimalFormat deciFormat = new DecimalFormat();
    deciFormat.setRoundingMode(RoundingMode.HALF_EVEN);
    return deciFormat.format(result);
  }
}
