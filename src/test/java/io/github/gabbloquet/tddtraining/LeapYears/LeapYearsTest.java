package io.github.gabbloquet.tddtraining.LeapYears;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LeapYearsTest {

  private final LeapYears leapYears = new LeapYears();

  @Test
  void should_return_false_if_year_is_0() {
    assertFalse(leapYears.isLeapYear(0));
  }

  @Test
  void should_return_false_if_year_is_2017() {
    assertFalse(leapYears.isLeapYear(2017));
  }

  @Test
  void should_return_true_if_year_is_2008() {
    assertTrue(leapYears.isLeapYear(2008));
  }

  @Test
  void should_return_true_if_year_is_2012() {
    assertTrue(leapYears.isLeapYear(2012));
  }

  @Test
  void should_return_true_if_year_is_2000() {
    assertTrue(leapYears.isLeapYear(2000));
  }

  @Test
  void should_return_false_if_year_is_1700() {
    assertFalse(leapYears.isLeapYear(1700));
  }

  @Test
  void should_return_false_if_year_is_2100() {
    assertFalse(leapYears.isLeapYear(2100));
  }
}
