package io.github.gabbloquet.tddtraining.DictionaryReplacer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DictionaryReplacer {

  String DELIMITER = "$";

  public String replace(String entry, Map<String, String> dictionary) {

    for (String elementToSearch : getElementsToSearch(entry)) {
      String foundElement = dictionary.get(elementToSearch);
      entry = entry.replace(DELIMITER + elementToSearch + DELIMITER, foundElement);
    }

    return entry;
  }

  private List<String> getElementsToSearch(String entry) {
    List<String> matches = new ArrayList<>();

    Pattern pattern = Pattern.compile("\\" + DELIMITER + "(\\w*)\\" + DELIMITER);
    Matcher matcher = pattern.matcher(entry);

    while (matcher.find())
      matches.add(matcher.group(1));

    return matches;
  }
}
