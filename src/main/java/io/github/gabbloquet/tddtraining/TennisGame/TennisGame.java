package io.github.gabbloquet.tddtraining.TennisGame;

import com.google.common.base.CharMatcher;

import java.util.Map;

public class TennisGame {

  private final int playerAPoints;
  private final int playerBPoints;
  private final Map<Integer, String> pointsCorrespondence = Map.of(0, "0", 1, "15", 2, "30", 3, "40");

  public TennisGame(String match) {
    this.playerAPoints = CharMatcher.is('A').countIn(match);
    this.playerBPoints = CharMatcher.is('B').countIn(match);
  }

  public String getScore() {
    if(isAContestedGame()){
      if(playerAPoints > playerBPoints)
        return "A 0 0 0 0 0 advantage B 0 0 0 0 0 0";
      else if(playerAPoints < playerBPoints)
        return "A 0 0 0 0 0 0 B 0 0 0 0 0 advantage";
      return "A 0 0 0 0 0 deuce B 0 0 0 0 0 deuce";
    }
    if(isAWonGame()) {
      if(playerAPoints > playerBPoints)
        return "A 1 0 0 0 0 0 B 0 0 0 0 0 0";
      return "A 0 0 0 0 0 0 B 1 0 0 0 0 0";
    }
    return "A 0 0 0 0 0 " + pointsCorrespondence.get(playerAPoints) + " B 0 0 0 0 0 " + pointsCorrespondence.get(playerBPoints);
  }

  private boolean isAWonGame() {
    return playerAPoints > 3 || playerBPoints > 3;
  }

  private boolean isAContestedGame() {
    return playerAPoints > 2 && playerBPoints > 2;
  }
}
