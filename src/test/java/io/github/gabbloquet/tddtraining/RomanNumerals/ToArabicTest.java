package io.github.gabbloquet.tddtraining.RomanNumerals;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ToArabicTest {

  RomanNumerals romanNumerals = new RomanNumerals();

  @Test
  void should_convert_to_five_or_so() {
    assertThat(romanNumerals.toArabic("I")).isEqualTo(1);
    assertThat(romanNumerals.toArabic("II")).isEqualTo(2);
    assertThat(romanNumerals.toArabic("IV")).isEqualTo(4);
    assertThat(romanNumerals.toArabic("V")).isEqualTo(5);
  }

  @Test
  void should_convert_to_ten_or_so() {
    assertThat(romanNumerals.toArabic("IX")).isEqualTo(9);
    assertThat(romanNumerals.toArabic("X")).isEqualTo(10);
    assertThat(romanNumerals.toArabic("XII")).isEqualTo(12);
  }

  @Test
  void should_convert_to_fifty_or_so() {
    assertThat(romanNumerals.toArabic("XL")).isEqualTo(40);
    assertThat(romanNumerals.toArabic("L")).isEqualTo(50);
    assertThat(romanNumerals.toArabic("LXI")).isEqualTo(61);
    assertThat(romanNumerals.toArabic("LXXX")).isEqualTo(80);
  }

  @Test
  void should_convert_to_hundred_or_so() {
    assertThat(romanNumerals.toArabic("XC")).isEqualTo(90);
    assertThat(romanNumerals.toArabic("C")).isEqualTo(100);
    assertThat(romanNumerals.toArabic("CC")).isEqualTo(200);
  }

  @Test
  void should_convert_to_five_hundred_or_so() {
    assertThat(romanNumerals.toArabic("CD")).isEqualTo(400);
    assertThat(romanNumerals.toArabic("D")).isEqualTo(500);
    assertThat(romanNumerals.toArabic("DCC")).isEqualTo(700);
  }

  @Test
  void should_convert_to_thousands_or_so() {
    assertThat(romanNumerals.toArabic("CM")).isEqualTo(900);
    assertThat(romanNumerals.toArabic("M")).isEqualTo(1000);
    assertThat(romanNumerals.toArabic("MM")).isEqualTo(2000);
  }

  @Test
  void should_convert_to_complexe_numbers() {
    assertThat(romanNumerals.toArabic("DCCCXLVII")).isEqualTo(847);
    assertThat(romanNumerals.toArabic("MLIII")).isEqualTo(1053);
    assertThat(romanNumerals.toArabic("MDCCLXXVI")).isEqualTo(1776);
    assertThat(romanNumerals.toArabic("MMXVIII")).isEqualTo(2018);
  }
}
