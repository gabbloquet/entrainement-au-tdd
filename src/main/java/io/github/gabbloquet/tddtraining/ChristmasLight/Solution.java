package io.github.gabbloquet.tddtraining.ChristmasLight;

public class Solution {

//  allumer 887,9 à 959,629
//  allumer 454,398 à 844,448
//  éteindre 539 243 à 559 965
//  éteindre 370,819 à 676,868
//  éteindre 145,40 à 370,997
//  éteindre 301,3 à 808,453
//  allumer 351,678 à 951,908
//  basculer de 720,196 à 897,994
//  basculer de 831,394 à 904,860

  public static void main(String args[]) {
    ChristmasLight christmasLight = new ChristmasLight();

    christmasLight.executeInstruction(new Instruction(InstructionType.TURNON, 887, 9, 959, 629));
    christmasLight.executeInstruction(new Instruction(InstructionType.TURNON, 454,398, 844,448));
    christmasLight.executeInstruction(new Instruction(InstructionType.TURNOFF, 539,243, 559,965));
    christmasLight.executeInstruction(new Instruction(InstructionType.TURNOFF, 370,819, 676,868));
    christmasLight.executeInstruction(new Instruction(InstructionType.TURNOFF, 145,40, 370,997));
    christmasLight.executeInstruction(new Instruction(InstructionType.TURNOFF, 301,3, 808,453));
    christmasLight.executeInstruction(new Instruction(InstructionType.TURNON, 351,678, 951,908));
    christmasLight.executeInstruction(new Instruction(InstructionType.TOGGLE, 720,196, 897,994));
    christmasLight.executeInstruction(new Instruction(InstructionType.TOGGLE, 831,394, 904,860));

    System.out.println("Opened christmas light: " + christmasLight.getOpenedLights());
    System.out.println("Closed christmas light: " + christmasLight.getClosedLights());
    System.out.println("Total : " + christmasLight.getTotalLights());
  }
}
