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
        int[] temperatures = new int[10001];
        for (int i = 1; i <= 10001; i++) {
            temperatures[i - 1] = i;
        }

        assertThat(closestToZeroOf(temperatures)).isZero();
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

    private int closestToZeroOf(int... temperatures) {
        return new Thermometer(temperatures).getClosestTemperatureToZero();
    }
}