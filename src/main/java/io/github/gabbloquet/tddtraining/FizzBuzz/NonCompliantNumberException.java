package io.github.gabbloquet.tddtraining.FizzBuzz;

public class NonCompliantNumberException extends RuntimeException {
  public NonCompliantNumberException() {
    super("The number provided is not greater than 1");
  }
}
