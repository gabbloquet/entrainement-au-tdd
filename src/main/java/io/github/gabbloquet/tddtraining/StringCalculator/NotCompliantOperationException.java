package io.github.gabbloquet.tddtraining.StringCalculator;

public class NotCompliantOperationException extends Exception {
  public NotCompliantOperationException(int indexOfUnexpectedNewline, int indexOfUnexpectedComma, String unexpectedNegatives) {
    super(buildMessage(indexOfUnexpectedNewline, indexOfUnexpectedComma, unexpectedNegatives));
  }

  private static String buildMessage(int indexOfUnexpectedNewline, int indexOfUnexpectedComma, String unexpectedNegatives) {
    StringBuilder messageBuilder = new StringBuilder();

    boolean isCommaError = indexOfUnexpectedComma != -1;

    if(!unexpectedNegatives.isEmpty())
      messageBuilder
        .append("Negative not allowed : ")
        .append(unexpectedNegatives)
        .append("\n");

    if(indexOfUnexpectedNewline != -1)
      messageBuilder
        .append("Number expected but '\n' found at position ")
        .append(indexOfUnexpectedNewline + 1)
        .append(isCommaError ? ".\n" : ".");

    if(isCommaError)
      messageBuilder
        .append("Number expected but ',' found at position ")
        .append(indexOfUnexpectedComma + 1)
        .append(".");

    return messageBuilder.toString();
  }
}
