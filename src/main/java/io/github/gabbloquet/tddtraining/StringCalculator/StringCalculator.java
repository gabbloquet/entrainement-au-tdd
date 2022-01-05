package io.github.gabbloquet.tddtraining.StringCalculator;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

  private static final String DEFAULT_DELIMITER = ",";

  public String add(String operation) throws UnexpectedNewlineException, NotANumberException, UnexpectedCommaException {
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
      .reduce((float) 0, Float::sum);

    return toString(result);
  }

  private String cleanOperation(String operation, String delimiter) {
    if(delimiter != null)
      return operation.substring(3 + delimiter.length());
    return operation;
  }

  private String getDelimiter(String operation) {
    Pattern pattern = Pattern.compile("//(.*)\\n");
    Matcher matcher = pattern.matcher(operation);

    if(matcher.find())
      return matcher.group(1);
    return null;
  }

  private List<String> getTerms(String operation, String delimiter) throws UnexpectedCommaException {
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

  private void checkOperationCompliance(String operation) throws UnexpectedNewlineException, NotANumberException {
    if(operation.endsWith(",") || operation.endsWith("\n"))
      throw new NotANumberException();

    int indexOfError = operation.indexOf(",\n");
    if(indexOfError != -1)
      throw new UnexpectedNewlineException(indexOfError + 1);
  }

  private String toString(float result) {
    DecimalFormat deciFormat = new DecimalFormat();
    deciFormat.setRoundingMode(RoundingMode.HALF_EVEN);
    return deciFormat.format(result);
  }
}
