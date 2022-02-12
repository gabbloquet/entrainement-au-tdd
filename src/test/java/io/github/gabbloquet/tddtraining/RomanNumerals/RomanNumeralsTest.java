package io.github.gabbloquet.tddtraining.RomanNumerals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralsTest {

  RomanNumerals romanNumerals = new RomanNumerals();

  @Test
  void shoud_convert_to_I() {
    assertEquals("I", romanNumerals.convert(1));
    assertEquals("II", romanNumerals.convert(2));
    assertEquals("III", romanNumerals.convert(3));
  }

  @Test
  void shoud_convert_to_V() {
    assertEquals("IV", romanNumerals.convert(4));
    assertEquals("V", romanNumerals.convert(5));
    assertEquals("VII", romanNumerals.convert(7));
  }

  @Test
  void shoud_convert_to_X() {
    assertEquals("IX", romanNumerals.convert(9));
    assertEquals("X", romanNumerals.convert(10));
    assertEquals("XII", romanNumerals.convert(12));
    assertEquals("XVII", romanNumerals.convert(17));
    assertEquals("XXX", romanNumerals.convert(30));
  }

  @Test
  void shoud_convert_to_L() {
    assertEquals("XL", romanNumerals.convert(40));
    assertEquals("L", romanNumerals.convert(50));
    assertEquals("LXI", romanNumerals.convert(61));
    assertEquals("LXXX", romanNumerals.convert(80));
  }

  @Test
  void shoud_convert_to_C() {
    assertEquals("XC", romanNumerals.convert(90));
    assertEquals("C", romanNumerals.convert(100));
    assertEquals("CC", romanNumerals.convert(200));
  }

  @Test
  void shoud_convert_to_D() {
    assertEquals("CD", romanNumerals.convert(400));
    assertEquals("D", romanNumerals.convert(500));
    assertEquals("DCC", romanNumerals.convert(700));
  }

  @Test
  void shoud_convert_to_M() {
    assertEquals("CM", romanNumerals.convert(900));
    assertEquals("M", romanNumerals.convert(1000));
    assertEquals("MM", romanNumerals.convert(2000));
  }

  @Test
  void shoud_convert_to_complexe_numbers() {
    assertEquals("DCCCXLVII", romanNumerals.convert(847));
    assertEquals("MLIII", romanNumerals.convert(1053));
    assertEquals("MDCCLXXVI", romanNumerals.convert(1776));
    assertEquals("MMXVIII", romanNumerals.convert(2018));
  }
}
