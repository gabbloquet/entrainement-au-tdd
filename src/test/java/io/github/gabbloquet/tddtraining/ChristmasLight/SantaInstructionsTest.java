package io.github.gabbloquet.tddtraining.ChristmasLight;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class SantaInstructionsTest {

  private static final List<Instruction> SANTA_INSTRUCTIONS = List.of(
    new Instruction(InstructionType.TURNON, 887, 9, 959, 629),
    new Instruction(InstructionType.TURNON, 454, 398, 844, 448),
    new Instruction(InstructionType.TURNOFF, 539, 243, 559, 965),
    new Instruction(InstructionType.TURNOFF, 370, 819, 676, 868),
    new Instruction(InstructionType.TURNOFF, 145, 40, 370, 997),
    new Instruction(InstructionType.TURNOFF, 301, 3, 808, 453),
    new Instruction(InstructionType.TURNON, 351, 678, 951, 908),
    new Instruction(InstructionType.TOGGLE, 720, 196, 897, 994),
    new Instruction(InstructionType.TOGGLE, 831, 394, 904, 860)
  );

  @Test
  void should_light_230022_lights_after_the_santa_instructions() {
    ChristmasLight christmasLight = new ChristmasLight();

    SANTA_INSTRUCTIONS.forEach(christmasLight::executeInstruction);

    assertThat(christmasLight.getOpenedLights()).isEqualTo(230022);
  }

  @Test
  void should_reach_a_combined_brightness_of_539560_after_the_santa_instructions() {
    ChristmasLightUpdated christmasLight = new ChristmasLightUpdated();

    SANTA_INSTRUCTIONS.forEach(christmasLight::executeInstruction);

    assertThat(christmasLight.getCombinedIntensity()).isEqualTo(539560);
  }

  @Test
  void should_spread_the_brightness_over_three_levels_after_the_santa_instructions() {
    ChristmasLightUpdated christmasLight = new ChristmasLightUpdated();

    SANTA_INSTRUCTIONS.forEach(christmasLight::executeInstruction);

    assertThat(christmasLight.getLightsPerIntensity(1)).isEqualTo(135339);
    assertThat(christmasLight.getLightsPerIntensity(2)).isEqualTo(79112);
    assertThat(christmasLight.getLightsPerIntensity(3)).isEqualTo(35090);
  }
}
