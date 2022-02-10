package io.github.gabbloquet.tddtraining.PrimeFactors;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
  public static List<Integer> factorsOf(int n) {
    List<Integer> factors = new ArrayList<>();

    for(int divisor = 2; n > 1; divisor++)
      for(; n % divisor == 0; n /= divisor)
        factors.add(divisor);

      return factors;
  }
}
