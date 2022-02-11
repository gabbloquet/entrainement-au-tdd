package io.github.gabbloquet.tddtraining.BowlingGame;

public class Game {

  private int score = 0;
  private int currentRoll = 0;
  private final int[] rolls = new int[21];

  public void roll(int pinsDown) {
    rolls[currentRoll++] = pinsDown;
  }

  public int score() {
    int rollNumber = 0;
    for(int frame = 0; frame < 10; frame++){

      if(isStrike(rollNumber)){
        score += getStrikeScore(rollNumber);
        rollNumber++;
      } else if(isSpare(rollNumber, rollNumber + 1)){
        score += getSpareScore(rollNumber);
        rollNumber+=2;
      } else {
        score += getNormalScore(rollNumber);
        rollNumber+=2;
      }

    }
    return score;
  }

  private int getStrikeScore(int rollNumber) {
    return 10 + rolls[rollNumber+1] + rolls[rollNumber+2];
  }

  private int getSpareScore(int rollNumber) {
    return 10 + rolls[rollNumber+2];
  }

  private int getNormalScore(int rollNumber) {
    return rolls[rollNumber] + rolls[rollNumber + 1];
  }

  private boolean isStrike(int rollNumber) {
    return rolls[rollNumber] == 10;
  }

  private boolean isSpare(int rollNumber, int nextRollNumber) {
    return rolls[rollNumber] + rolls[nextRollNumber] == 10;
  }
}
