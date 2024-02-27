package io.github.gabbloquet.tddtraining.RomanNumerals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToArabicTest {

  RomanNumerals romanNumerals = new RomanNumerals();

  @Test
  void should_convert_to_five_or_so() {
    assertEquals(1, romanNumerals.toArabic("I"));
    assertEquals(2, romanNumerals.toArabic("II"));
    assertEquals(4, romanNumerals.toArabic("IV"));
    assertEquals(5, romanNumerals.toArabic("V"));
  }

  @Test
  void should_convert_to_ten_or_so() {
    assertEquals(9, romanNumerals.toArabic("IX"));
    assertEquals(10, romanNumerals.toArabic("X"));
    assertEquals(12, romanNumerals.toArabic("XII"));
  }

  @Test
  void should_convert_to_fifty_or_so() {
    assertEquals(40, romanNumerals.toArabic("XL"));
    assertEquals(50, romanNumerals.toArabic("L"));
    assertEquals(61, romanNumerals.toArabic("LXI"));
    assertEquals(80, romanNumerals.toArabic("LXXX"));
  }

  @Test
  void should_convert_to_hundred_or_so() {
    assertEquals(90, romanNumerals.toArabic("XC"));
    assertEquals(100, romanNumerals.toArabic("C"));
    assertEquals(200, romanNumerals.toArabic("CC"));
  }

  @Test
  void should_convert_to_five_hundred_or_so() {
    assertEquals(400, romanNumerals.toArabic("CD"));
    assertEquals(500, romanNumerals.toArabic("D"));
    assertEquals(700, romanNumerals.toArabic("DCC"));
  }

  @Test
  void should_convert_to_thousands_or_so() {
    assertEquals(900, romanNumerals.toArabic("CM"));
    assertEquals(1000, romanNumerals.toArabic("M"));
    assertEquals(2000, romanNumerals.toArabic("MM"));
  }

  @Test
  void should_convert_to_complexe_numbers() {
    assertEquals(847, romanNumerals.toArabic("DCCCXLVII"));
    assertEquals(1053, romanNumerals.toArabic("MLIII"));
    assertEquals(1776, romanNumerals.toArabic("MDCCLXXVI"));
    assertEquals(2018, romanNumerals.toArabic("MMXVIII"));
  }
}
