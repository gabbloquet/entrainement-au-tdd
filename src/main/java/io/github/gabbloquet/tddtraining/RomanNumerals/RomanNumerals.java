package io.github.gabbloquet.tddtraining.RomanNumerals;

import java.util.*;

public class RomanNumerals {

  private final List<Combinaison> conversions = Arrays.asList(
    new Combinaison("M", 1000),
    new Combinaison("CM", 900),
    new Combinaison("D", 500),
    new Combinaison("CD", 400),
    new Combinaison("C", 100),
    new Combinaison("XC", 90),
    new Combinaison("L", 50),
    new Combinaison("XL", 40),
    new Combinaison("X", 10),
    new Combinaison("IX", 9),
    new Combinaison("V", 5),
    new Combinaison("IV", 4),
    new Combinaison("I", 1)
  );

  public String toRoman(int arabicNumber) throws UnconvertibleException {
    StringBuilder convertedNumber = new StringBuilder();

    if(arabicNumber < 1){
      throw new UnconvertibleException();
    }

    while (arabicNumber > 0) {
      for (Combinaison conversion : conversions) {
        if(arabicNumber >= conversion.arabicValue()) {
          convertedNumber.append(conversion.romanValue());
          arabicNumber-=conversion.arabicValue();
          break;
        }
      }
    }

    return convertedNumber.toString();
  }

  public int toArabic(String romanNumber) {
    int arabicNumber = 0;

    while (!romanNumber.isEmpty()) {
      for (Combinaison conversion : conversions) {
        if(romanNumber.startsWith(conversion.romanValue())) {
          arabicNumber += conversion.arabicValue();
          romanNumber = romanNumber.replaceFirst(conversion.romanValue(), "");
          break;
        }
      }
    }

    return arabicNumber;
  }
}
