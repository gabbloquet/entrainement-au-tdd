package io.github.gabbloquet.tddtraining.ChristmasLight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChristmasLightUpdatedTest {

  private ChristmasLightUpdated christmasLight;

  @BeforeEach
  void setUp() {
    christmasLight = new ChristmasLightUpdated();
  }

  @Test
  void should_count_total_lights() {
    var instruction = new Instruction(InstructionType.TURNON,
      0, 0,
      999, 999);

    christmasLight.executeInstruction(instruction);

    assertEquals(1000000, christmasLight.getTotalLights());
  }

  @Test
  void should_add_one_in_intensity_to_a_light_if_turn_on() {
    var instruction = new Instruction(
      InstructionType.TURNON,
      0, 0,
      0, 0
    );

    christmasLight.executeInstruction(instruction);

    assertEquals(1, christmasLight.getLightsPerIntensity(1));
  }

  @Test
  void should_add_one_in_intensity_to_four_lights_if_turn_on() {
    var instruction = new Instruction(
      InstructionType.TURNON,
      0, 0,
      1, 1
    );

    christmasLight.executeInstruction(instruction);

    assertEquals(4, christmasLight.getLightsPerIntensity(1));
  }

  @Test
  void should_add_one_in_intensity_to_hundred_lights_if_turn_on() {
    var instruction = new Instruction(
      InstructionType.TURNON,
      10, 10,
      19, 19
    );

    christmasLight.executeInstruction(instruction);

    assertEquals(100, christmasLight.getLightsPerIntensity(1));
  }

  @Test
  void should_subtract_one_in_intensity_to_a_light_if_turn_off() {
    var initInstruction = new Instruction(
      InstructionType.TURNON,
      0, 0,
      999, 999
    );
    var instruction = new Instruction(
      InstructionType.TURNOFF,
      0, 0,
      0, 0
    );

    christmasLight.executeInstruction(initInstruction);
    christmasLight.executeInstruction(instruction);

    assertEquals(1, christmasLight.getLightsPerIntensity(0));
  }

  @Test
  void should_subtract_one_in_intensity_to_four_lights_if_turn_off() {
    var initInstruction = new Instruction(
      InstructionType.TURNON,
      0, 0,
      999, 999
    );
    var instruction = new Instruction(
      InstructionType.TURNOFF,
      0, 0,
      1, 1
    );

    christmasLight.executeInstruction(initInstruction);
    christmasLight.executeInstruction(instruction);

    assertEquals(4, christmasLight.getLightsPerIntensity(0));
  }

  @Test
  void should_subtract_one_in_intensity_to_hundred_lights_if_turn_off() {
    var initInstruction = new Instruction(
      InstructionType.TURNON,
      0, 0,
      999, 999
    );
    var instruction = new Instruction(
      InstructionType.TURNOFF,
      50, 50,
      59, 59
    );

    christmasLight.executeInstruction(initInstruction);
    christmasLight.executeInstruction(instruction);

    assertEquals(100, christmasLight.getLightsPerIntensity(0));
  }

  @Test
  void should_add_two_in_intensity_to_a_light_if_toggled() {
    var instruction = new Instruction(
      InstructionType.TOGGLE,
      0,0,
      0,0
    );

    christmasLight.executeInstruction(instruction);

    assertEquals(1, christmasLight.getLightsPerIntensity(2));
  }

  @Test
  void should_add_two_in_intensity_to_a_light_if_toggled_so_three_if_already_turn_on() {
    var initInstruction = new Instruction(
      InstructionType.TURNON,
      0,0,
      0,0
    );
    var instruction = new Instruction(
      InstructionType.TOGGLE,
      0,0,
      0,0
    );

    christmasLight.executeInstruction(initInstruction);
    christmasLight.executeInstruction(instruction);

    assertEquals(1, christmasLight.getLightsPerIntensity(3));
  }

  @Test
  void should_add_two_in_intensity_to_four_light_if_toggled() {
    var toggleInstruction = new Instruction(
      InstructionType.TOGGLE,
      0,0,
      1,1
    );

    christmasLight.executeInstruction(toggleInstruction);

    assertEquals(4, christmasLight.getLightsPerIntensity(2));
  }

  @Test
  void should_add_two_only_in_middle_of_square_if_toggled() {
    Instruction openInstruction = new Instruction(
      InstructionType.TURNON,
      1,1,
      4,4
    );

    var toggleInstruction = new Instruction(
      InstructionType.TOGGLE,
      2,2,
      3,3
    );

    christmasLight.executeInstruction(openInstruction);
    christmasLight.executeInstruction(toggleInstruction);

    assertEquals(12, christmasLight.getLightsPerIntensity(1));
    assertEquals(4, christmasLight.getLightsPerIntensity(3));
  }

  @Test
  void should_return_24_as_combined_intensity_middle_of_square_if_toggled() {
    Instruction openInstruction = new Instruction(
      InstructionType.TURNON,
      1,1,
      4,4
    );

    var toggleInstruction = new Instruction(
      InstructionType.TOGGLE,
      2,2,
      3,3
    );

    christmasLight.executeInstruction(openInstruction);
    christmasLight.executeInstruction(toggleInstruction);

    assertEquals(12, christmasLight.getLightsPerIntensity(1));
    assertEquals(4, christmasLight.getLightsPerIntensity(3));
    assertEquals(24, christmasLight.getCombinedIntensity());
  }

  @Test
  void should_return_108_as_combined_intensity() {
    Instruction openInstruction = new Instruction(
      InstructionType.TURNON,
      50, 50,
      59, 59
    );

    var toggleInstruction = new Instruction(
      InstructionType.TOGGLE,
      2, 2,
      3, 3
    );

    christmasLight.executeInstruction(openInstruction);
    christmasLight.executeInstruction(toggleInstruction);

    assertEquals(108, christmasLight.getCombinedIntensity());
  }
}
