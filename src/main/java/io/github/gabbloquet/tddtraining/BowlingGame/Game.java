package io.github.gabbloquet.tddtraining.BowlingGame;

import java.util.ArrayList;
import java.util.List;

public class Game {
  private final List<Integer> rolls = new ArrayList<>();

  public void roll(int pinsDown) {
    rolls.add(pinsDown);
  }

  public int score() {
    int score = 0;
    int frameIndex = 0;

    for (int frame = 0; frame < 10; frame++) {
      score += frameScore(frameIndex);

      frameIndex = nextFrameIndex(frameIndex);
    }

    return score;
  }

  private int frameScore(int frameIndex) {
    if (isStrike(frameIndex)) {
      return strikeScore(frameIndex);
    }

    if (isSpare(frameIndex)) {
      return spareScore(frameIndex);
    }

    return normalFrameScore(frameIndex);
  }

  private int nextFrameIndex(int frameIndex) {
    if (isStrike(frameIndex)) {
      return frameIndex + 1;
    }

    return frameIndex + 2;
  }

  private boolean isStrike(int frameIndex) {
    return rolls.get(frameIndex) == 10;
  }

  private int strikeScore(int frameIndex) {
    return 10 + strikeBonus(frameIndex);
  }

  private int strikeBonus(int frameIndex) {
    return rolls.get(frameIndex + 1) + rolls.get(frameIndex + 2);
  }

  private boolean isSpare(int frameIndex) {
    return normalFrameScore(frameIndex) == 10;
  }

  private int spareScore(int frameIndex) {
    return 10 + spareBonus(frameIndex);
  }

  private Integer spareBonus(int frameIndex) {
    return rolls.get(frameIndex + 2);
  }

  private int normalFrameScore(int frameIndex) {
    return rolls.get(frameIndex) + rolls.get(frameIndex + 1);
  }
}
