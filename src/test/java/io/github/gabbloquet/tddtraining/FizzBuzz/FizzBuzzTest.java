package io.github.gabbloquet.tddtraining.FizzBuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FizzBuzzTest {

  @Test
  void should_return_fizz_when_there_is_a_3() {
    int three = 3;
    String expectedString = "Fizz";
    Assertions.assertEquals(FizzBuzz.convert(three), expectedString);
  }

  @Test
  void should_return_buzz_when_there_is_a_5() {
    int five = 5;
    String expectedString = "Buzz";
    Assertions.assertEquals(FizzBuzz.convert(five), expectedString);
  }

  @Test
  void should_return_fizzbuzz_when_there_is_a_15_multiple() {
    int fifteen = 15;
    String expectedString = "FizzBuzz";
    Assertions.assertEquals(FizzBuzz.convert(fifteen), expectedString);
  }

  @Test
  void should_return_fizz_for_every_3_multiple() {
    int six = 6;
    int nine = 9;
    int twelve = 12;

    String expectedString = "Fizz";

    Assertions.assertEquals(FizzBuzz.convert(six), expectedString);
    Assertions.assertEquals(FizzBuzz.convert(nine), expectedString);
    Assertions.assertEquals(FizzBuzz.convert(twelve), expectedString);
  }

  @Test
  void should_return_buzz_for_every_5_multiple() {
    int five = 5;
    int ten = 10;
    int twenty = 20;

    String expectedString = "Buzz";

    Assertions.assertEquals(FizzBuzz.convert(five), expectedString);
    Assertions.assertEquals(FizzBuzz.convert(ten), expectedString);
    Assertions.assertEquals(FizzBuzz.convert(twenty), expectedString);
  }

  @Test
  void should_return_fizzbuzz_for_every_15_multiple() {
    int thirty = 30;
    int fortyFive = 45;
    int sixty = 60;

    String expectedString = "FizzBuzz";

    Assertions.assertEquals(FizzBuzz.convert(thirty), expectedString);
    Assertions.assertEquals(FizzBuzz.convert(fortyFive), expectedString);
    Assertions.assertEquals(FizzBuzz.convert(sixty), expectedString);
  }

  @Test
  void should_return_the_number_else() {
    int one = 1;
    int two = 2;
    int four = 4;

    Assertions.assertEquals(FizzBuzz.convert(one), "1");
    Assertions.assertEquals(FizzBuzz.convert(two), "2");
    Assertions.assertEquals(FizzBuzz.convert(four), "4");
  }

  @Test
  void should_return_transformed_list_to_20() {
    int to = 20;

    String expectedList = "12Fizz4BuzzFizz78FizzBuzz11Fizz1314FizzBuzz1617Fizz19Buzz";

    Assertions.assertEquals(FizzBuzz.compute(to), expectedList);
  }

  @Test
  void should_return_transformed_list_to_100() {
    int to = 100;

    String expectedList = "12Fizz4BuzzFizz78FizzBuzz11Fizz1314FizzBuzz1617Fizz19BuzzFizz2223FizzBuzz26Fizz2829FizzBuzz3132Fizz34BuzzFizz3738FizzBuzz41Fizz4344FizzBuzz4647Fizz49BuzzFizz5253FizzBuzz56Fizz5859FizzBuzz6162Fizz64BuzzFizz6768FizzBuzz71Fizz7374FizzBuzz7677Fizz79BuzzFizz8283FizzBuzz86Fizz8889FizzBuzz9192Fizz94BuzzFizz9798FizzBuzz";

    Assertions.assertEquals(FizzBuzz.compute(to), expectedList);
  }

}
