package io.github.gabbloquet.tddtraining.Fraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FractionTest {

  private FractionCalculator fractionCalculator;

  @BeforeEach
  void setUp() {
    fractionCalculator = new FractionCalculator();
  }

  @Test
  void should_add_up_numerator_if_same_denominator() {
    Fraction firstFraction = new Fraction(4, 7);
    Fraction secondFraction = new Fraction(2, 7);

    Fraction result = fractionCalculator.add(firstFraction, secondFraction);

    Fraction expectedResult = new Fraction(6, 7);
    assertEquals(expectedResult, result);
  }

  @Test
  void should_put_the_same_denominator_to_add_up() {
    Fraction firstFraction = new Fraction(2, 7);
    Fraction secondFraction = new Fraction(3, 8);

    Fraction result = fractionCalculator.add(firstFraction, secondFraction);

    Fraction expectedResult = new Fraction(37, 56);
    assertEquals(expectedResult, result);
  }

}
