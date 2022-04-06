package io.github.gabbloquet.tddtraining.TennisGame;

import java.util.*;
import java.util.stream.Collectors;

public class TennisGame {

  private final String[] points;
  private int runningSet = 0;
  private final List<Integer> playerAGames = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
  private final List<Integer> playerBGames = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
  private final Map<Integer, String> pointsCorrespondence = Map.of(0, "0", 1, "15", 2, "30", 3, "40");

  public TennisGame(String match) {
    this.points = match.split(",");
  }

  public String getScore() {
    int playerAPoints = 0;
    int playerBPoints = 0;

    for (String point : points) {
      if(Objects.equals(point, "A")){
        playerAPoints++;
      } else if(Objects.equals(point, "B")){
        playerBPoints++;
      }
      if(isAWonGame(playerAPoints, playerBPoints)) {
        if(playerAPoints > playerBPoints){
          addGameToScoreboard(playerAGames, playerBGames);
          playerAPoints = playerAPoints - 4;
          playerBPoints = 0;
        } else {
          addGameToScoreboard(playerBGames, playerAGames);
          playerBPoints = playerBPoints - 4;
          playerAPoints = 0;
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

  private void addGameToScoreboard(List<Integer> playerGames, List<Integer> opponentsGames) {
    if(playerGames.get(runningSet) == 6 && opponentsGames.get(runningSet) < 5) {
      this.runningSet++;
      playerGames.set(runningSet, 1);
    } else {
      playerGames.set(runningSet, playerGames.get(runningSet) + 1);
    }
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

  private boolean isAWonGame(int playerAPoints, int playerBPoints) {
    return (playerAPoints > 3 || playerBPoints > 3) &&
      ((playerAPoints - playerBPoints > 1) || (playerBPoints - playerAPoints > 1));
  }

  private boolean isAContestedGame(int firstPlayerPoints, int secondPlayerPoints) {
    return firstPlayerPoints > 2 && secondPlayerPoints > 2;
  }
}
