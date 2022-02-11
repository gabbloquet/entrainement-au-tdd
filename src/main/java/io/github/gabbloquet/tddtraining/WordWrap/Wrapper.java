package io.github.gabbloquet.tddtraining.WordWrap;

public class Wrapper {
  public String wrap(String string, int columnSize) {
    if (hasNotToBeWrapped(string, columnSize))
      return string;

    int spaceIndex = string.lastIndexOf(" ", columnSize);
    if (thereIsNoSpace(spaceIndex))
      spaceIndex = columnSize;

    return string.substring(0, spaceIndex).trim()
      + "\n"
      + wrap(string.substring(spaceIndex).trim(), columnSize);
  }

  private boolean hasNotToBeWrapped(String string, int columnSize) {
    return columnSize >= string.length();
  }

  private boolean thereIsNoSpace(int spaceIndex) {
    return spaceIndex == -1;
  }
}
