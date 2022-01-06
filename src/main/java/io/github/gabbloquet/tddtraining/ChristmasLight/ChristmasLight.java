package io.github.gabbloquet.tddtraining.ChristmasLight;

import java.util.Arrays;

public class ChristmasLight {

  private final LightState[][] lights = new LightState[1000][1000];

  public int getTotalLights() {
    return lights.length * lights.length;
  }

  public void executeInstruction(Instruction instruction) {
    if(instruction.getType() == InstructionType.TURNON){
      swithLightsWithState(instruction, LightState.ON);
    } else if(instruction.getType() == InstructionType.TURNOFF) {
      swithLightsWithState(instruction, LightState.OFF);
    } else {
      swithLightsWithState(instruction, null);
    }
  }

  private void swithLightsWithState(Instruction instruction, LightState lightState) {
    for(int i = instruction.getStartX(); i <= instruction.getEndX(); i++) {
      for(int j = instruction.getStartY(); j <= instruction.getEndY(); j++) {
        lights[i][j] = lightState != null
          ? lightState
          : toggleIt(lights[i][j]);
      }
    }
  }

  private LightState toggleIt(LightState lightState) {
    return lightState == LightState.ON ? LightState.OFF : LightState.ON;
  }

  public long getOpenedLights() {
    return getLightsWithState(LightState.ON);
  }

  public long getClosedLights() {
    return getLightsWithState(LightState.OFF);
  }

  private long getLightsWithState(LightState state) {
    return Arrays.stream(lights)
      .flatMap(Arrays::stream)
      .filter(lightState -> lightState == state)
      .count();
  }
}
