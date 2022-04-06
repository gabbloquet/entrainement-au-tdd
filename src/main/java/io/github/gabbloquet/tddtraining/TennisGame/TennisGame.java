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

      if(isATieBreak(playerAGames, playerBGames, runningSet)){
        if(playerWonTheTieBreak(playerAPoints, playerBPoints)){
          playerAGames.set(runningSet, playerAGames.get(runningSet) + 1);
          playerAPoints = 0;
          playerBPoints = 0;
        }
        if(playerWonTheTieBreak(playerBPoints, playerAPoints)){
          playerBGames.set(runningSet, playerBGames.get(runningSet) + 1);
          playerAPoints = 0;
          playerBPoints = 0;
        }
      } else if(isAWonGame(playerAPoints, playerBPoints)) {
        if(playerAPoints > playerBPoints){
          addGameToScoreboard(playerAGames, playerBGames);
        } else {
          addGameToScoreboard(playerBGames, playerAGames);
        }
        playerBPoints = 0;
        playerAPoints = 0;
      }
    }

    return "A " +
      displaySets(playerAGames) + " " +
      getPlayerRunningGameScore(playerAPoints, playerBPoints) +
      " B " +
      displaySets(playerBGames) + " " +
      getPlayerRunningGameScore(playerBPoints, playerAPoints);
  }

  private boolean playerWonTheTieBreak(int winner, int loser) {
    return winner > 6 && (winner - loser > 1);
  }

  private boolean isATieBreak(List<Integer> playerAGames, List<Integer> playerBGames, int runningSet) {
    return playerAGames.get(runningSet) == 6 && playerBGames.get(runningSet) == 6 && runningSet != 4;
  }

  private void addGameToScoreboard(List<Integer> playerGames, List<Integer> opponentsGames) {
    if(playerWonTheSet(playerGames, opponentsGames)) {
      playerGames.set(runningSet, playerGames.get(runningSet) + 1);
      this.runningSet++;
    } else {
      playerGames.set(runningSet, playerGames.get(runningSet) + 1);
    }
  }

  private boolean playerWonTheSet(List<Integer> playerGames, List<Integer> opponentsGames) {
    return playerGames.get(runningSet) == 5 && opponentsGames.get(runningSet) < 5;
  }

  private String displaySets(List<Integer> playerGames) {
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
