package io.github.gabbloquet.tddtraining.Wardrobe;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class WardrobeTest {

  private final Wardrobe wardrobe = new Wardrobe();

  @Test
  void should_wardrobe_size_be_250() {
    assertThat(wardrobe.size()).isEqualTo(250);
  }

  @Test
  void should_individual_closet_available_size_contain_50() {
    assertThat(wardrobe.availableIndividualSizes()).contains(50);
  }

  @Test
  void should_individual_closet_available_size_contain_75() {
    assertThat(wardrobe.availableIndividualSizes()).contains(75);
  }

  @Test
  void should_individual_closet_available_size_contain_100_and_120() {
    assertThat(wardrobe.availableIndividualSizes()).contains(100);
    assertThat(wardrobe.availableIndividualSizes()).contains(120);
  }

  @Test
  void should_return_five_times_the_50_closet() {
    assertThat(wardrobe.compliantCombinations()).contains(List.of(50, 50, 50, 50, 50));
  }

  @Test
  void should_return_two_times_the_50_closet_and_two_75_closet() {
    assertThat(wardrobe.compliantCombinations()).contains(List.of(50, 50, 75, 75));
  }

  @Test
  void should_return_three_times_the_50_closet_and_one_100_closet() {
    assertThat(wardrobe.compliantCombinations()).contains(List.of(50, 50, 50, 100));
  }

  @Test
  void should_return_two_times_the_75_closet_and_one_100_closet() {
    assertThat(wardrobe.compliantCombinations()).contains(List.of(75, 75, 100));
  }

  @Test
  void should_return_the_linked_prices() {
    assertThat(wardrobe.getPrices()).isEqualTo(Map.of(50, 59, 75, 62, 100, 90, 120, 111));
  }

  @Test
  void should_return_295_for_5_50_closets() {
    assertThat(wardrobe.getPrice(List.of(50, 50, 50, 50, 50))).isEqualTo(295);
  }

  @Test
  void should_return_242_for_2_50_and_2_75_closets() {
    assertThat(wardrobe.getPrice(List.of(50, 50, 75, 75))).isEqualTo(242);
  }

  @Test
  void should_return_214_for_2_75_and_1_100_closets() {
    assertThat(wardrobe.getPrice(List.of(75, 75, 100))).isEqualTo(214);
  }

  @Test
  void should_return_the_least_expensive_combinations() {
    assertThat(wardrobe.getLeastExpensiveCombinations()).isEqualTo(List.of(List.of(75, 75, 100), List.of(100, 75, 75)));
  }

}
