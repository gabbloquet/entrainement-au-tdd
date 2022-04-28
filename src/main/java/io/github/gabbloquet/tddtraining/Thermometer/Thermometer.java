package io.github.gabbloquet.tddtraining.Thermometer;

public record Thermometer(int[] temperatures) {

  public int getClosestTemperatureToZero() {
    if (this.temperatures.length == 0 || this.temperatures.length > 10000)
      return 0;

    int temperatureClosestToZero = this.temperatures[0];

    for (int temperature : temperatures) {
      int distance = Math.abs(temperature);

      if (distance < Math.abs(temperatureClosestToZero))
        temperatureClosestToZero = temperature;
      else if (temperature > 0 && distance <= Math.abs(temperatureClosestToZero))
        temperatureClosestToZero = temperature;
    }

    return temperatureClosestToZero;
  }
}
