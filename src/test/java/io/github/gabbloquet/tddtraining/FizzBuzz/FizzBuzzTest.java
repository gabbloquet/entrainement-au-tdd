package io.github.gabbloquet.tddtraining.FizzBuzz;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class FizzBuzzTest {

    private final FizzBuzz fizzBuzz = new FizzBuzz();

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4})
    void should_return_the_number_when_it_is_multiple_of_neither_3_nor_5(int number) {
        assertThat(fizzBuzz.convert(number)).isEqualTo(String.valueOf(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9, 12})
    void should_return_fizz_for_every_multiple_of_3(int number) {
        assertThat(fizzBuzz.convert(number)).isEqualTo("Fizz");
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20})
    void should_return_buzz_for_every_multiple_of_5(int number) {
        assertThat(fizzBuzz.convert(number)).isEqualTo("Buzz");
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 30, 45, 60})
    void should_return_fizzbuzz_for_every_multiple_of_15(int number) {
        assertThat(fizzBuzz.convert(number)).isEqualTo("FizzBuzz");
    }

    @Test
    void should_compute_1_the_smallest_accepted_number() {
        assertThat(fizzBuzz.compute(1)).isEqualTo("1");
    }

    @Test
    void should_concatenate_every_conversion_up_to_20() {
        assertThat(fizzBuzz.compute(20))
            .isEqualTo("12Fizz4BuzzFizz78FizzBuzz11Fizz1314FizzBuzz1617Fizz19Buzz");
    }

    @Test
    void should_concatenate_every_conversion_up_to_100() {
        assertThat(fizzBuzz.compute(100))
            .isEqualTo("12Fizz4BuzzFizz78FizzBuzz11Fizz1314FizzBuzz1617Fizz19BuzzFizz2223FizzBuzz26Fizz2829FizzBuzz3132Fizz34BuzzFizz3738FizzBuzz41Fizz4344FizzBuzz4647Fizz49BuzzFizz5253FizzBuzz56Fizz5859FizzBuzz6162Fizz64BuzzFizz6768FizzBuzz71Fizz7374FizzBuzz7677Fizz79BuzzFizz8283FizzBuzz86Fizz8889FizzBuzz9192Fizz94BuzzFizz9798FizzBuzz");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -3})
    void should_throw_when_the_number_to_compute_is_lower_than_1(int number) {
        assertThatThrownBy(() -> fizzBuzz.compute(number))
            .isInstanceOf(NonCompliantNumberException.class)
            .hasMessage("The number provided is not greater than 1");
    }
}