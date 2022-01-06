package io.github.gabbloquet.tddtraining.ChristmasLight;

public class Instruction {

  private InstructionType type;
  private int startX;
  private int startY;
  private int endX;
  private int endY;

  public Instruction(InstructionType type, int startX, int startY, int endX, int endY) {
    this.type = type;
    this.startX = startX;
    this.startY = startY;
    this.endX = endX;
    this.endY = endY;
  }

  public InstructionType getType() {
    return type;
  }

  public int getStartX() {
    return startX;
  }

  public int getStartY() {
    return startY;
  }

  public int getEndX() {
    return endX;
  }

  public int getEndY() {
    return endY;
  }
}
