package io.github.gabbloquet.tddtraining.BowlingGameHardcore;

import java.util.ArrayList;
import java.util.List;

public class Game {

  private static final int FRAMES_PER_GAME = 10;
  private static final int ALL_PINS = 10;

  private final List<Integer> rolls = new ArrayList<>();

  public void roll(int downedPins) {
    rolls.add(downedPins);
  }

  public int score() {
    int score = 0;
    int roll = 0;

    for (int frame = 0; frame < FRAMES_PER_GAME && roll < rolls.size(); frame++) {
      if (isAStrike(roll)) {
        score += ALL_PINS + pinsDowned(roll + 1) + pinsDowned(roll + 2);
        roll += 1;
      } else if (isASpare(roll)) {
        score += ALL_PINS + pinsDowned(roll + 2);
        roll += 2;
      } else {
        score += pinsDowned(roll) + pinsDowned(roll + 1);
        roll += 2;
      }
    }

    return score;
  }

  private boolean isAStrike(int roll) {
    return pinsDowned(roll) == ALL_PINS;
  }

  private boolean isASpare(int roll) {
    return pinsDowned(roll) + pinsDowned(roll + 1) == ALL_PINS;
  }

  private int pinsDowned(int roll) {
    return roll < rolls.size() ? rolls.get(roll) : 0;
  }
}
