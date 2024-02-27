package io.github.gabbloquet.tddtraining.ChristmasLight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChristmasLightTest {

  private ChristmasLight christmasLight;

  @BeforeEach
  void setUp() {
    christmasLight = new ChristmasLight();
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
  void should_turn_on_a_light() {
    var instruction = new Instruction(
      InstructionType.TURNON,
      0, 0,
      0, 0
    );

    christmasLight.executeInstruction(instruction);

    assertEquals(1, christmasLight.getOpenedLights());
  }

  @Test
  void should_turn_on_four_lights() {
    var instruction = new Instruction(
      InstructionType.TURNON,
      0, 0,
      1, 1
    );

    christmasLight.executeInstruction(instruction);

    assertEquals(4, christmasLight.getOpenedLights());
  }

  @Test
  void should_turn_on_an_hundred_lights() {
    var instruction = new Instruction(
      InstructionType.TURNON,
      10, 10,
      19, 19
    );

    christmasLight.executeInstruction(instruction);

    assertEquals(100, christmasLight.getOpenedLights());
  }

  @Test
  void should_turn_off_a_light() {
    var instruction = new Instruction(
      InstructionType.TURNOFF,
      0, 0,
      0, 0
    );

    christmasLight.executeInstruction(instruction);

    assertEquals(1, christmasLight.getClosedLights());
  }

  @Test
  void should_turn_off_four_light() {
    var instruction = new Instruction(
      InstructionType.TURNOFF,
      0, 0,
      1, 1
    );

    christmasLight.executeInstruction(instruction);

    assertEquals(4, christmasLight.getClosedLights());
  }

  @Test
  void should_turn_off_an_hundred_lights() {
    var instruction = new Instruction(
      InstructionType.TURNOFF,
      50, 50,
      59, 59
    );

    christmasLight.executeInstruction(instruction);

    assertEquals(100, christmasLight.getClosedLights());
  }

  @Test
  void should_open_a_closed_light_if_toggle() {
    var instruction = new Instruction(
      InstructionType.TOGGLE,
      0,0,
      0,0
    );

    christmasLight.executeInstruction(instruction);

    assertEquals(1, christmasLight.getOpenedLights());
  }

  @Test
  void should_close_an_opened_light_if_toggle() {
    Instruction openInstruction = new Instruction(
      InstructionType.TURNON,
      0,0,
      0,0
    );

    var toggleInstruction = new Instruction(
      InstructionType.TOGGLE,
      0,0,
      0,0
    );

    christmasLight.executeInstruction(openInstruction);
    christmasLight.executeInstruction(toggleInstruction);

    assertEquals(1, christmasLight.getClosedLights());
  }

  @Test
  void should_open_25_closed_light_if_toggle() {
    var instruction = new Instruction(
      InstructionType.TOGGLE,
      0,0,
      4,4
    );

    christmasLight.executeInstruction(instruction);

    assertEquals(25, christmasLight.getOpenedLights());
  }

  @Test
  void should_close_36_opened_light_if_toggle() {
    Instruction openInstruction = new Instruction(
      InstructionType.TURNON,
      6,6,
      11,11
    );

    var toggleInstruction = new Instruction(
      InstructionType.TOGGLE,
      6,6,
      11,11
    );

    christmasLight.executeInstruction(openInstruction);
    christmasLight.executeInstruction(toggleInstruction);

    assertEquals(36, christmasLight.getClosedLights());
  }

  @Test
  void should_toggle_only_middle_of_square() {
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

    assertEquals(12, christmasLight.getOpenedLights());
    assertEquals(4, christmasLight.getClosedLights());
  }
}
