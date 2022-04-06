package io.github.gabbloquet.tddtraining.TennisGame;

import com.google.common.base.CharMatcher;

import java.util.Map;

public class TennisGame {
  private final int aPoints;
  private final int bPoints;
  private final Map<Integer, String> pointsCorrespondence = Map.of(0, "0", 1, "15", 2, "30", 3, "40");

  TennisGame(String game) {
    this.aPoints = CharMatcher.is('A').countIn(game);
    this.bPoints = CharMatcher.is('B').countIn(game);
  }

  public String score() {

    if(aPoints < 4 && bPoints < 4) {
      String pointsOfA = pointsCorrespondence.get(aPoints);
      String pointsOfB = pointsCorrespondence.get(bPoints);

      return "A 0 0 0 0 0 " + pointsOfA + " B 0 0 0 0 0 " + pointsOfB;
    }

    if(bHasAtLeastTwoPointsMore()) {
      return "A 0 0 0 0 0 0 B 1 0 0 0 0 0";
    } else if(aHasAtLeastTwoPointsMore()){
      return "A 1 0 0 0 0 0 B 0 0 0 0 0 0";
    }

    if(isEquality()) {
      return "A 0 0 0 0 0 deuce B 0 0 0 0 0 deuce";
    }

    if(bHasAdvantage()) {
      return "A 0 0 0 0 0 0 B 0 0 0 0 0 advantage";
    }

    return "A 0 0 0 0 0 advantage B 0 0 0 0 0 0";
  }

  private boolean isEquality() {
    return bPoints == aPoints;
  }

  private boolean bHasAtLeastTwoPointsMore() {
    return bPoints - aPoints > 1;
  }

  private boolean aHasAtLeastTwoPointsMore() {
    return aPoints - bPoints > 1;
  }

  private boolean bHasAdvantage() {
    return bPoints > aPoints;
  }
}
