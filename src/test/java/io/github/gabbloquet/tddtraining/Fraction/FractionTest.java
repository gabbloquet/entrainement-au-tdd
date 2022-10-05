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

  @Test
  void should_subtract_numerator_if_same_denominator() {
    Fraction firstFraction = new Fraction(4, 7);
    Fraction secondFraction = new Fraction(2, 7);

    Fraction result = fractionCalculator.subtract(firstFraction, secondFraction);

    Fraction expectedResult = new Fraction(2, 7);
    assertEquals(expectedResult, result);
  }

  @Test
  void should_put_the_same_denominator_to_substract() {
    Fraction firstFraction = new Fraction(5, 7);
    Fraction secondFraction = new Fraction(3, 8);

    Fraction result = fractionCalculator.subtract(firstFraction, secondFraction);

    Fraction expectedResult = new Fraction(19, 56);
    assertEquals(expectedResult, result);
  }

  @Test
  void should_multiply() {
    Fraction firstFraction = new Fraction(4, 7);
    Fraction secondFraction = new Fraction(2, 7);

    Fraction result = fractionCalculator.multiply(firstFraction, secondFraction);

    Fraction expectedResult = new Fraction(8, 49);
    assertEquals(expectedResult, result);
  }

  @Test
  void should_divide() {
    Fraction firstFraction = new Fraction(4, 7);
    Fraction secondFraction = new Fraction(2, 7);

    int result = fractionCalculator.divide(firstFraction, secondFraction);

    assertEquals(2, result);
  }

}
