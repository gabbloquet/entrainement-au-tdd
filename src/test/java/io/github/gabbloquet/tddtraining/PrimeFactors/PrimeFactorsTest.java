package io.github.gabbloquet.tddtraining.PrimeFactors;

import static io.github.gabbloquet.tddtraining.PrimeFactors.PrimeFactors.factorsOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class PrimeFactorsTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void should_return_no_factor_when_the_number_is_0_or_1(int number) {
        assertThat(factorsOf(number)).isEmpty();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5})
    void should_return_the_number_itself_when_it_is_prime(int prime) {
        assertThat(factorsOf(prime)).containsExactly(prime);
    }

    @ParameterizedTest
    @MethodSource
    void should_return_2_and_the_remaining_factors_when_the_number_is_divisible_by_2(int number, Integer[] expectedFactors) {
        assertThat(factorsOf(number)).containsExactly(expectedFactors);
    }

    static Stream<Arguments> should_return_2_and_the_remaining_factors_when_the_number_is_divisible_by_2() {
        return Stream.of(
            arguments(4, new Integer[]{2, 2}),
            arguments(6, new Integer[]{2, 3}),
            arguments(8, new Integer[]{2, 2, 2})
        );
    }

    @ParameterizedTest
    @MethodSource
    void should_return_3_and_the_remaining_factors_when_the_number_is_divisible_by_3(int number, Integer[] expectedFactors) {
        assertThat(factorsOf(number)).containsExactly(expectedFactors);
    }

    static Stream<Arguments> should_return_3_and_the_remaining_factors_when_the_number_is_divisible_by_3() {
        return Stream.of(
            arguments(9, new Integer[]{3, 3}),
            arguments(15, new Integer[]{3, 5})
        );
    }

    @Test
    void should_return_every_factor_in_ascending_order() {
        assertThat(factorsOf(2 * 2 * 3 * 5 * 7 * 11 * 13))
            .containsExactly(2, 2, 3, 5, 7, 11, 13);
    }
}