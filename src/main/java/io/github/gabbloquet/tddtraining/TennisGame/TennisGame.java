package io.github.gabbloquet.tddtraining.TennisGame;

import java.util.*;
import java.util.stream.Collectors;

public class TennisGame {

  private final String[] points;
  private int playerAPoints = 0;
  private int playerBPoints = 0;
  private List<Integer> playerAGames = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
  private List<Integer> playerBGames = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
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
          if(playerAGames.get(0) == 6) {
            playerAGames.set(1, 1);
          } else {
            playerAGames.set(0, playerAGames.get(0) + 1);
          }
          this.playerAPoints = this.playerAPoints - 4;
          this.playerBPoints = 0;
        } else {
          if(playerBGames.get(0) == 6) {
            playerBGames.set(1, 1);
          } else {
            playerBGames.set(0, playerBGames.get(0) + 1);
          }
          this.playerBPoints = this.playerBPoints - 4;
          this.playerAPoints = 0;
        }
      }
    }

    return "A " +
      getSets(playerAGames) + " " +
      getPlayerRunningGameScore(playerAPoints, playerBPoints) +
      " B " +
      getSets(playerBGames) + " " +
      getPlayerRunningGameScore(playerBPoints, playerAPoints);
  }

  private String getSets(List<Integer> playerGames) {
    return playerGames
      .stream()
      .map(Object::toString)
      .collect(Collectors.joining(" "));
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
