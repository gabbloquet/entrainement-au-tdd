package io.github.gabbloquet.tddtraining.Wardrobe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Wardrobe {

  private final int size = 250;
  private final List<Integer> availableIndividualSizes = List.of(50, 75, 100, 120);
  private final Map<Integer, Integer> prices = Map.of(50, 59, 75, 62, 100, 90, 120, 111);

  public Wardrobe() {}

  public int size() {
    return size;
  }

  public List<Integer> availableIndividualSizes() {
    return availableIndividualSizes;
  }

  public List<List<Integer>> compliantCombinations() {
    List<List<Integer>> compliantCombinations = new ArrayList<>();
    for(int i = 0; i < availableIndividualSizes.size(); i++) {
        for (Integer availableIndividualSize : availableIndividualSizes) {
            List<Integer> initialCombination = new ArrayList<>();
            initialCombination.add(availableIndividualSizes.get(i));
            while (combinaisonSize(initialCombination) < size) {
                List<List<Integer>> compliantCombinationsWithInit =
                    findCombinations(initialCombination, availableIndividualSize);
                compliantCombinations.addAll(compliantCombinationsWithInit);
                initialCombination.add(availableIndividualSizes.get(i));
            }
        }
    }
    return compliantCombinations;
  }

  private List<List<Integer>> findCombinations(List<Integer> initialCombination, int elementToAdd) {
    List<Integer> tempCombination = new ArrayList<>(initialCombination);
    List<List<Integer>> compliantCombinations = new ArrayList<>();
    while(combinaisonSize(tempCombination) < size){
      tempCombination.add(elementToAdd);
    }
    if(combinaisonSize(tempCombination) == size){
      compliantCombinations.add(tempCombination);
    }
    return compliantCombinations;
  }

  private int combinaisonSize(List<Integer> combinations) {
    return combinations.stream().reduce(0, Integer::sum);
  }

  public Map<Integer, Integer> getPrices() {
    return prices;
  }

  public int getPrice(List<Integer> closetSizes) {
    return closetSizes.stream()
      .reduce(0, (total, closetSize) -> total + prices.get(closetSize));
  }

  public List<List<Integer>> getLeastExpensiveCombinations() {
    List<List<Integer>> combinations = new ArrayList<>();
    compliantCombinations()
      .forEach(combinaison -> {
        if(combinations.isEmpty() || getPrice(combinaison) < getPrice(combinations.getFirst())){
          combinations.clear();
          combinations.add(combinaison);
        } else if(getPrice(combinaison) == getPrice(combinations.getFirst())) {
          combinations.add(combinaison);
        }
      });
    return combinations;
  }
}
