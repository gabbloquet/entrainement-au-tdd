package io.github.gabbloquet.tddtraining.TennisGame;

import com.google.common.base.CharMatcher;

import java.util.Map;

public class TennisGame {

  private final int playerAPoints;
  private final Map<Integer, String> pointsCorrespondence = Map.of(0, "0", 1, "15", 2, "30", 3, "40");

  public TennisGame(String match) {
    this.playerAPoints = CharMatcher.is('A').countIn(match);
  }

  public String getScore() {
    return "A 0 0 0 0 0 " + pointsCorrespondence.get(playerAPoints) + " B 0 0 0 0 0 0";
  }
}
