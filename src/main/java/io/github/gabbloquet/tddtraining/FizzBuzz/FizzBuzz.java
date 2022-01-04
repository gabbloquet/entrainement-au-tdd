package io.github.gabbloquet.tddtraining.FizzBuzz;

public class FizzBuzz {
  public static String convert(int input) {
    if(input % 15 == 0){
      return "FizzBuzz";
    } else if(input % 5 == 0) {
      return "Buzz";
    } else if(input % 3 == 0){
      return "Fizz";
    }
    return String.valueOf(input);
  }

  public static String compute(int to) {
    StringBuilder transformedString = new StringBuilder();
    for(int i = 1; i <= to; i++){
      transformedString.append(convert(i));
    }
    return transformedString.toString();
  }
}
