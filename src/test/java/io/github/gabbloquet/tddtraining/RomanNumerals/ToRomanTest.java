package io.github.gabbloquet.tddtraining.RomanNumerals;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ToRomanTest {

  RomanNumerals romanNumerals = new RomanNumerals();

  @Test
  void should_convert_to_I() throws UnconvertibleException {
    assertThat(romanNumerals.toRoman(1)).isEqualTo("I");
    assertThat(romanNumerals.toRoman(2)).isEqualTo("II");
    assertThat(romanNumerals.toRoman(3)).isEqualTo("III");
  }

  @Test
  void should_convert_to_V() throws UnconvertibleException {
    assertThat(romanNumerals.toRoman(4)).isEqualTo("IV");
    assertThat(romanNumerals.toRoman(5)).isEqualTo("V");
    assertThat(romanNumerals.toRoman(7)).isEqualTo("VII");
  }

  @Test
  void should_convert_to_X() throws UnconvertibleException {
    assertThat(romanNumerals.toRoman(9)).isEqualTo("IX");
    assertThat(romanNumerals.toRoman(10)).isEqualTo("X");
    assertThat(romanNumerals.toRoman(12)).isEqualTo("XII");
    assertThat(romanNumerals.toRoman(17)).isEqualTo("XVII");
    assertThat(romanNumerals.toRoman(30)).isEqualTo("XXX");
  }

  @Test
  void should_convert_to_L() throws UnconvertibleException {
    assertThat(romanNumerals.toRoman(40)).isEqualTo("XL");
    assertThat(romanNumerals.toRoman(50)).isEqualTo("L");
    assertThat(romanNumerals.toRoman(61)).isEqualTo("LXI");
    assertThat(romanNumerals.toRoman(80)).isEqualTo("LXXX");
  }

  @Test
  void should_convert_to_C() throws UnconvertibleException {
    assertThat(romanNumerals.toRoman(90)).isEqualTo("XC");
    assertThat(romanNumerals.toRoman(100)).isEqualTo("C");
    assertThat(romanNumerals.toRoman(200)).isEqualTo("CC");
  }

  @Test
  void should_convert_to_D() throws UnconvertibleException {
    assertThat(romanNumerals.toRoman(400)).isEqualTo("CD");
    assertThat(romanNumerals.toRoman(500)).isEqualTo("D");
    assertThat(romanNumerals.toRoman(700)).isEqualTo("DCC");
  }

  @Test
  void should_convert_to_M() throws UnconvertibleException {
    assertThat(romanNumerals.toRoman(900)).isEqualTo("CM");
    assertThat(romanNumerals.toRoman(1000)).isEqualTo("M");
    assertThat(romanNumerals.toRoman(2000)).isEqualTo("MM");
  }

  @Test
  void should_convert_to_complexe_numbers() throws UnconvertibleException {
    assertThat(romanNumerals.toRoman(847)).isEqualTo("DCCCXLVII");
    assertThat(romanNumerals.toRoman(1053)).isEqualTo("MLIII");
    assertThat(romanNumerals.toRoman(1776)).isEqualTo("MDCCLXXVI");
    assertThat(romanNumerals.toRoman(2018)).isEqualTo("MMXVIII");
  }

  @Test
  void should_throw_an_error_if_not_convertible() {
    assertThatThrownBy(() -> romanNumerals.toRoman(0))
      .isInstanceOf(UnconvertibleException.class)
      .hasMessage("Il est impossible de convertir 0 ou un nombre négatif.");
  }
}
