package io.github.gabbloquet.tddtraining.LeapYears;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LeapYearsTest {

  private final LeapYears leapYears = new LeapYears();

  @Test
  void should_return_false_if_year_is_0() {
    assertThat(leapYears.isLeapYear(0)).isFalse();
  }

  @Test
  void should_return_false_if_year_is_2017() {
    assertThat(leapYears.isLeapYear(2017)).isFalse();
  }

  @Test
  void should_return_true_if_year_is_2008() {
    assertThat(leapYears.isLeapYear(2008)).isTrue();
  }

  @Test
  void should_return_true_if_year_is_2012() {
    assertThat(leapYears.isLeapYear(2012)).isTrue();
  }

  @Test
  void should_return_true_if_year_is_2000() {
    assertThat(leapYears.isLeapYear(2000)).isTrue();
  }

  @Test
  void should_return_false_if_year_is_1700() {
    assertThat(leapYears.isLeapYear(1700)).isFalse();
  }

  @Test
  void should_return_false_if_year_is_2100() {
    assertThat(leapYears.isLeapYear(2100)).isFalse();
  }
}
