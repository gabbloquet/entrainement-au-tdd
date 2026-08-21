package io.github.gabbloquet.tddtraining.Thermometer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ThermometerTest {

    @Test
    void should_return_0_when_there_is_no_temperature() {
        assertThat(closestToZeroOf()).isZero();
    }

    @Test
    void should_return_0_when_there_are_more_than_10000_temperatures() {
        assertThat(closestToZeroOf(temperaturesFrom1To(10001))).isZero();
    }

    @Test
    void should_still_answer_with_exactly_10000_temperatures() {
        assertThat(closestToZeroOf(temperaturesFrom1To(10000))).isEqualTo(1);
    }

    @Test
    void should_return_the_positive_temperature_closest_to_zero() {
        assertThat(closestToZeroOf(4, 2, 5)).isEqualTo(2);
    }

    @Test
    void should_return_the_negative_temperature_closest_to_zero() {
        assertThat(closestToZeroOf(4, 2, -5, -1)).isEqualTo(-1);
    }

    @Test
    void should_prefer_the_positive_temperature_when_the_distance_is_the_same() {
        assertThat(closestToZeroOf(4, 2, 5, -2, 1, -1)).isEqualTo(1);
    }

    @Test
    void should_prefer_the_positive_temperature_even_when_the_negative_one_comes_first() {
        assertThat(closestToZeroOf(-1, 1)).isEqualTo(1);
    }

    private int closestToZeroOf(int... temperatures) {
        return new Thermometer(temperatures).getClosestTemperatureToZero();
    }

    private int[] temperaturesFrom1To(int count) {
        int[] temperatures = new int[count];
        for (int i = 1; i <= count; i++) {
            temperatures[i - 1] = i;
        }
        return temperatures;
    }
}