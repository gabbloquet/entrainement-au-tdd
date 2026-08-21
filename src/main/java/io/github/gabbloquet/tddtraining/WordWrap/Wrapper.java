package io.github.gabbloquet.tddtraining.WordWrap;

public class Wrapper {
  public String wrap(String string, int columnSize) {
    if (hasNotToBeWrapped(string, columnSize))
      return string;

    int breakIndex = breakIndex(string, columnSize);

    return string.substring(0, breakIndex).trim()
      + "\n"
      + wrap(string.substring(breakIndex).trim(), columnSize);
  }

  private int breakIndex(String string, int columnSize) {
    int spaceIndex = string.lastIndexOf(" ", columnSize);

    if (thereIsNoSpace(spaceIndex) || nextWordNeedsAWholeLine(string, spaceIndex, columnSize))
      return columnSize;

    return spaceIndex;
  }

  private boolean nextWordNeedsAWholeLine(String string, int spaceIndex, int columnSize) {
    return lengthOfWordAfter(string, spaceIndex) > columnSize;
  }

  private int lengthOfWordAfter(String string, int spaceIndex) {
    String remaining = string.substring(spaceIndex).trim();
    int endOfWord = remaining.indexOf(" ");

    return endOfWord == -1 ? remaining.length() : endOfWord;
  }

  private boolean hasNotToBeWrapped(String string, int columnSize) {
    return columnSize >= string.length();
  }

  private boolean thereIsNoSpace(int spaceIndex) {
    return spaceIndex == -1;
  }
}
