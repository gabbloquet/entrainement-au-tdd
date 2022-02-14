package io.github.gabbloquet.tddtraining.Diamond;

public class DiamondRenderer {

  public String render(char letter) throws UnexpectedLetter {
    StringBuilder diamondBuilder = new StringBuilder();
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int letterPosition = alphabet.indexOf(letter) + 1;
    if(letterPosition == 0) throw new UnexpectedLetter();
    int diamondHeight = (letterPosition * 2) - 1;

    for(int line = 0; line <= diamondHeight; line++) {
      if(line < letterPosition){
        char letterToDisplay = alphabet.charAt(line);
        addDiamondLine(diamondBuilder,
          !isA(letterToDisplay),
          (letterPosition - 1) - line,
          line,
          letterToDisplay
        );
      } else if(line > letterPosition) {
        char letterToDisplay = alphabet.charAt(diamondHeight - line);
        addDiamondLine(diamondBuilder,
          true,
          line - letterPosition,
          diamondHeight - line,
          letterToDisplay
        );
      }
    }

    return diamondBuilder.toString();
  }

  private void addDiamondLine(StringBuilder diamondBuilder, boolean isAEndOfLine, int spaceSize, int position, char letterToDisplay) {
    diamondBuilder
      .append(isAEndOfLine ? "\n" : "")
      .append(addSpace(spaceSize))
      .append(letterToDisplay)
      .append(getSpaceBetween(position))
      .append(isA(letterToDisplay) ? "" : letterToDisplay);
  }

  private boolean isA(char letter) {
    return letter == 'A';
  }

  private String addSpace(int spaceSize) {
    return " ".repeat(spaceSize);
  }

  private String getSpaceBetween(int position) {
    return position != 0 ? " ".repeat((position * 2) - 1) : "";
  }
}