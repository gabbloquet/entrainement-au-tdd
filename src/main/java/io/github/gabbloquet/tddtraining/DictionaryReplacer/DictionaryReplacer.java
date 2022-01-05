package io.github.gabbloquet.tddtraining.DictionaryReplacer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DictionaryReplacer {

  String DELIMITER = "$";

  public String replace(String entry, Map<String, String> dictionary) {

    List<String> elementsToSearch = getElementsToSearch(entry);

    if(elementsToSearch.size() > 0){
      for(int i = 0; i < elementsToSearch.size(); i++) {
        String foundElement = dictionary.get(elementsToSearch.get(i));
        entry = entry.replace(DELIMITER + elementsToSearch.get(i) + DELIMITER, foundElement);
      }
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
