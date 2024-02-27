package io.github.gabbloquet.tddtraining.Thermometer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ThermometerTest {

  @Test
  void should_return_0_if_empty() {
    int[] temperatures = {};

    Thermometer thermometer = new Thermometer(temperatures);

    Assertions.assertEquals(0, thermometer.getClosestTemperatureToZero());
  }

  @Test
  void should_return_0_if_more_than_10000_entries() {
    int[] temperatures = new int[10001];

    for(int i = 1; i <= 10001; i++){
      temperatures[i - 1] = i;
    }

    Thermometer thermometer = new Thermometer(temperatures);

    Assertions.assertEquals(0, thermometer.getClosestTemperatureToZero());
  }

  @Test
  void should_return_the_positive_temperature_closest_to_zero() {
    int[] temperatures = { 4, 2, 5 };

    Thermometer thermometer = new Thermometer(temperatures);

    Assertions.assertEquals(2, thermometer.getClosestTemperatureToZero());
  }

  @Test
  void should_return_the_negative_temperature_closest_to_zero() {
    int[] temperatures = { 4, 2, -5, -1 };

    Thermometer thermometer = new Thermometer(temperatures);

    Assertions.assertEquals(-1, thermometer.getClosestTemperatureToZero());
  }

  @Test
  void should_prefer_the_positive_temperature_if_distance_is_the_same() {
    int[] temperatures = { 4, 2, 5, -2, 1, -1 };

    Thermometer thermometer = new Thermometer(temperatures);

    Assertions.assertEquals(1, thermometer.getClosestTemperatureToZero());
  }

}
