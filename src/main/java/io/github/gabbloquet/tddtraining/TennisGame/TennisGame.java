package io.github.gabbloquet.tddtraining.TennisGame;

import com.google.common.base.CharMatcher;

import java.util.Map;
import java.util.Objects;

public class TennisGame {

  private final String[] points;
  private int playerAPoints = 0;
  private int playerBPoints = 0;
  private int playerBGames = 0;
  private int playerAGames = 0;
  private final Map<Integer, String> pointsCorrespondence = Map.of(0, "0", 1, "15", 2, "30", 3, "40");

  public TennisGame(String match) {
    this.points = match.split(",");
  }

  public String getScore() {
    for (String point : points) {
      if(Objects.equals(point, "A")){
        playerAPoints++;
      } else if(Objects.equals(point, "B")){
        playerBPoints++;
      }
      if(isAWonGame()) {
        if(playerAPoints > playerBPoints){
          this.playerAGames = this.playerAGames + 1;
          this.playerAPoints = this.playerAPoints - 4;
          this.playerBPoints = 0;
        } else {
          this.playerBGames = this.playerBGames + 1;
          this.playerBPoints = this.playerBPoints - 4;
          this.playerAPoints = 0;
        }
      }
    }

    return "A " +
      playerAGames +
      " 0 0 0 0 " +
      getPlayerRunningGameScore(playerAPoints, playerBPoints) +
      " B " +
      playerBGames +
      " 0 0 0 0 " +
      getPlayerRunningGameScore(playerBPoints, playerAPoints);
  }

  private String getPlayerRunningGameScore(int firstPlayerPoints, int secondPlayerPoints) {
    if(isAnEquality(firstPlayerPoints, secondPlayerPoints))
      return "deuce";

    if(isAContestedGame(firstPlayerPoints, secondPlayerPoints)){
      if(firstPlayerPoints > secondPlayerPoints)
        return "advantage";
      return pointsCorrespondence.get(0);
    }

    return pointsCorrespondence.get(firstPlayerPoints);
  }

  private boolean isAnEquality(int firstPlayerPoints, int secondPlayerPoints) {
    return firstPlayerPoints == secondPlayerPoints && firstPlayerPoints > 0;
  }

  private boolean isAWonGame() {
    return (playerAPoints > 3 || playerBPoints > 3) &&
      ((playerAPoints - playerBPoints > 1) || (playerBPoints - playerAPoints > 1));
  }

  private boolean isAContestedGame(int firstPlayerPoints, int secondPlayerPoints) {
    return firstPlayerPoints > 2 && secondPlayerPoints > 2;
  }
}
