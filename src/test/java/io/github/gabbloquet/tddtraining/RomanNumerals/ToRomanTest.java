package io.github.gabbloquet.tddtraining.RomanNumerals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToRomanTest {

  RomanNumerals romanNumerals = new RomanNumerals();

  @Test
  void should_convert_to_I() throws UnconvertibleException {
    assertEquals("I", romanNumerals.toRoman(1));
    assertEquals("II", romanNumerals.toRoman(2));
    assertEquals("III", romanNumerals.toRoman(3));
  }

  @Test
  void should_convert_to_V() throws UnconvertibleException {
    assertEquals("IV", romanNumerals.toRoman(4));
    assertEquals("V", romanNumerals.toRoman(5));
    assertEquals("VII", romanNumerals.toRoman(7));
  }

  @Test
  void should_convert_to_X() throws UnconvertibleException {
    assertEquals("IX", romanNumerals.toRoman(9));
    assertEquals("X", romanNumerals.toRoman(10));
    assertEquals("XII", romanNumerals.toRoman(12));
    assertEquals("XVII", romanNumerals.toRoman(17));
    assertEquals("XXX", romanNumerals.toRoman(30));
  }

  @Test
  void should_convert_to_L() throws UnconvertibleException {
    assertEquals("XL", romanNumerals.toRoman(40));
    assertEquals("L", romanNumerals.toRoman(50));
    assertEquals("LXI", romanNumerals.toRoman(61));
    assertEquals("LXXX", romanNumerals.toRoman(80));
  }

  @Test
  void should_convert_to_C() throws UnconvertibleException {
    assertEquals("XC", romanNumerals.toRoman(90));
    assertEquals("C", romanNumerals.toRoman(100));
    assertEquals("CC", romanNumerals.toRoman(200));
  }

  @Test
  void should_convert_to_D() throws UnconvertibleException {
    assertEquals("CD", romanNumerals.toRoman(400));
    assertEquals("D", romanNumerals.toRoman(500));
    assertEquals("DCC", romanNumerals.toRoman(700));
  }

  @Test
  void should_convert_to_M() throws UnconvertibleException {
    assertEquals("CM", romanNumerals.toRoman(900));
    assertEquals("M", romanNumerals.toRoman(1000));
    assertEquals("MM", romanNumerals.toRoman(2000));
  }

  @Test
  void should_convert_to_complexe_numbers() throws UnconvertibleException {
    assertEquals("DCCCXLVII", romanNumerals.toRoman(847));
    assertEquals("MLIII", romanNumerals.toRoman(1053));
    assertEquals("MDCCLXXVI", romanNumerals.toRoman(1776));
    assertEquals("MMXVIII", romanNumerals.toRoman(2018));
  }

  @Test
  void should_throw_an_error_if_not_convertible() {
    Exception exception = assertThrows(UnconvertibleException.class, () -> romanNumerals.toRoman(0));

    String expectedMessage = "Il est impossible de convertir 0 ou un nombre négatif.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }
}
