package io.github.gabbloquet.tddtraining.FizzBuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FizzBuzzTest {

  private FizzBuzz fizzBuzz;

  @BeforeEach
  void setUp() {
    fizzBuzz = new FizzBuzz();
  }

  @Test
  void should_return_1_when_number_is_1() {
    int one = 1;
    String expectedString = "1";
    assertEquals(expectedString, fizzBuzz.convert(one));
  }

  @Test
  void should_return_fizz_when_the_number_is_3() {
    int three = 3;
    String expectedString = "Fizz";
    assertEquals(expectedString, fizzBuzz.convert(three));
  }

  @Test
  void should_return_buzz_when_the_number_is_5() {
    int five = 5;
    String expectedString = "Buzz";
    assertEquals(expectedString, fizzBuzz.convert(five));
  }

  @Test
  void should_return_fizzbuzz_when_the_number_is_15() {
    int fifteen = 15;
    String expectedString = "FizzBuzz";
    assertEquals(expectedString, fizzBuzz.convert(fifteen));
  }

  @Test
  void should_return_fizz_for_every_multiple_of_3() {
    int six = 6;
    int nine = 9;
    int twelve = 12;

    String expectedString = "Fizz";

    assertEquals(expectedString, fizzBuzz.convert(six));
    assertEquals(expectedString, fizzBuzz.convert(nine));
    assertEquals(expectedString, fizzBuzz.convert(twelve));
  }

  @Test
  void should_return_buzz_for_every_multiple_of_5() {
    int five = 5;
    int ten = 10;
    int twenty = 20;

    String expectedString = "Buzz";

    assertEquals(expectedString, fizzBuzz.convert(five));
    assertEquals(expectedString, fizzBuzz.convert(ten));
    assertEquals(expectedString, fizzBuzz.convert(twenty));
  }

  @Test
  void should_return_fizzbuzz_for_every_multiple_of_15() {
    int thirty = 30;
    int fortyFive = 45;
    int sixty = 60;

    String expectedString = "FizzBuzz";

    assertEquals(expectedString, fizzBuzz.convert(thirty));
    assertEquals(expectedString, fizzBuzz.convert(fortyFive));
    assertEquals(expectedString, fizzBuzz.convert(sixty));
  }

  @Test
  void should_return_the_number_else() {
    int one = 1;
    int two = 2;
    int four = 4;

    assertEquals(fizzBuzz.convert(one), "1");
    assertEquals(fizzBuzz.convert(two), "2");
    assertEquals(fizzBuzz.convert(four), "4");
  }

  @Test
  void should_return_transformed_list_to_20() {
    int to = 20;

    String expectedList = "12Fizz4BuzzFizz78FizzBuzz11Fizz1314FizzBuzz1617Fizz19Buzz";

    assertEquals(fizzBuzz.compute(to), expectedList);
  }

  @Test
  void should_return_transformed_list_to_100() {
    int to = 100;

    String expectedList = "12Fizz4BuzzFizz78FizzBuzz11Fizz1314FizzBuzz1617Fizz19BuzzFizz2223FizzBuzz26Fizz2829FizzBuzz3132Fizz34BuzzFizz3738FizzBuzz41Fizz4344FizzBuzz4647Fizz49BuzzFizz5253FizzBuzz56Fizz5859FizzBuzz6162Fizz64BuzzFizz6768FizzBuzz71Fizz7374FizzBuzz7677Fizz79BuzzFizz8283FizzBuzz86Fizz8889FizzBuzz9192Fizz94BuzzFizz9798FizzBuzz";

    assertEquals(fizzBuzz.compute(to), expectedList);
  }

  @Test
  void should_throw_non_compliant_error_if_number_is_0() {
    Exception exception = assertThrows(NonCompliantNumberException.class, () -> {
      fizzBuzz.compute(0);
    });

    String expectedMessage = "The number provided is not greater than 1";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void should_throw_non_compliant_error_if_number_is_minus_3() {
    Exception exception = assertThrows(NonCompliantNumberException.class, () -> {
      fizzBuzz.compute(-3);
    });

    String expectedMessage = "The number provided is not greater than 1";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

}
