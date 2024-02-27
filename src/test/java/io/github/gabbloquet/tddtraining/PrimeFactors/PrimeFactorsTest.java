package io.github.gabbloquet.tddtraining.PrimeFactors;

import org.junit.jupiter.api.Test;

import java.util.List;

import static io.github.gabbloquet.tddtraining.PrimeFactors.PrimeFactors.factorsOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimeFactorsTest {

  @Test
  void should_return_an_empty_array_if_is_0_or_1() {
    assertEquals(List.of(), factorsOf(0));
    assertEquals(List.of(), factorsOf(1));
  }

  @Test
  void should_return_X_if_X_is_a_prime_number() {
    assertEquals(List.of(2), factorsOf(2));
    assertEquals(List.of(3), factorsOf(3));
    assertEquals(List.of(5), factorsOf(5));
  }

  @Test
  void should_return_2_and_X_if_X_is_divisible_by_2() {
    assertEquals(List.of(2, 2), factorsOf(4));
    assertEquals(List.of(2, 3), factorsOf(6));
    assertEquals(List.of(2, 2, 2), factorsOf(8));
  }

  @Test
  void should_return_3_and_X_if_X_is_divisible_by_3() {
    assertEquals(List.of(3, 3), factorsOf(9));
    assertEquals(List.of(3, 5), factorsOf(15));
  }

  @Test
  void should_return_all_factors() {
    assertEquals(List.of(2, 2, 3, 5, 7, 11, 13), factorsOf(2 * 2 * 3 * 5 * 7 * 11 * 13));
  }
}
