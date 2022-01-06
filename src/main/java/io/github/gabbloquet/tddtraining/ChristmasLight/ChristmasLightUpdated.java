package io.github.gabbloquet.tddtraining.ChristmasLight;

import java.util.Arrays;

public class ChristmasLightUpdated {

  private final int[][] lights = new int[1000][1000];

  public int getTotalLights() {
    return lights.length * lights.length;
  }

  public void executeInstruction(Instruction instruction) {
    for(int i = instruction.getStartX(); i <= instruction.getEndX(); i++) {
      for(int j = instruction.getStartY(); j <= instruction.getEndY(); j++) {
        lights[i][j] = getIntensity(lights[i][j], instruction.getType());
      }
    }
  }

  private int getIntensity(int intensity, InstructionType type) {
    if(type == InstructionType.TURNON) {
      return intensity + 1;
    } else if(type == InstructionType.TURNOFF) {
      return intensity > 0 ? intensity - 1 : 0;
    } else {
      return intensity + 2;
    }
  }

  public long getCombinedIntensity() {
    return Arrays.stream(lights)
      .flatMapToInt(Arrays::stream)
      .reduce(0, Integer::sum);
  }

  public long getLightsPerIntensity(int intensity) {
    return Arrays.stream(lights)
      .flatMapToInt(Arrays::stream)
      .filter(lightState -> lightState == intensity)
      .count();
  }
}
