package io.github.gabbloquet.tddtraining.TennisGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TennisGame {

  private static final Map<Integer, String> POINTS_CORRESPONDENCE = Map.of(0, "0", 1, "15", 2, "30", 3, "40");
  private static final int LAST_SET = 4;

  private final String[] points;

  public TennisGame(String match) {
    this.points = match.split(",");
  }

  public String getScore() {
    Scoreboard scoreboard = new Scoreboard();

    for (String point : points) {
      scoreboard.play(point);
    }

    return scoreboard.display();
  }

  private static final class Scoreboard {

    private final List<Integer> playerAGames = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
    private final List<Integer> playerBGames = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
    private int runningSet = 0;
    private int playerAPoints = 0;
    private int playerBPoints = 0;

    private void play(String point) {
      countPoint(point);

      if (isATieBreak()) {
        settleTieBreak();
      } else if (isAWonGame()) {
        settleGame();
      }
    }

    private void countPoint(String point) {
      if ("A".equals(point)) {
        playerAPoints++;
      } else if ("B".equals(point)) {
        playerBPoints++;
      }
    }

    private void settleTieBreak() {
      if (playerWonTheTieBreak(playerAPoints, playerBPoints)) {
        winTheRunningGame(playerAGames);
      }
      if (playerWonTheTieBreak(playerBPoints, playerAPoints)) {
        winTheRunningGame(playerBGames);
      }
    }

    private void settleGame() {
      boolean playerWonTheSet = playerAPoints > playerBPoints
        ? addGameToScoreboard(playerAGames, playerBGames)
        : addGameToScoreboard(playerBGames, playerAGames);

      if (playerWonTheSet) {
        runningSet++;
      }
      resetPoints();
    }

    private boolean addGameToScoreboard(List<Integer> playerGames, List<Integer> opponentsGames) {
      boolean playerWonTheSet = playerWonTheSet(playerGames.get(runningSet), opponentsGames.get(runningSet));
      addGame(playerGames);
      return playerWonTheSet;
    }

    private void winTheRunningGame(List<Integer> playerGames) {
      addGame(playerGames);
      resetPoints();
    }

    private void addGame(List<Integer> playerGames) {
      playerGames.set(runningSet, playerGames.get(runningSet) + 1);
    }

    private void resetPoints() {
      playerAPoints = 0;
      playerBPoints = 0;
    }

    private boolean isATieBreak() {
      return playerAGames.get(runningSet) == 6 && playerBGames.get(runningSet) == 6 && runningSet != LAST_SET;
    }

    private boolean isAWonGame() {
      return (playerAPoints > 3 || playerBPoints > 3) &&
        ((playerAPoints - playerBPoints > 1) || (playerBPoints - playerAPoints > 1));
    }

    private boolean playerWonTheTieBreak(int winner, int loser) {
      return winner > 6 && (winner - loser > 1);
    }

    private boolean playerWonTheSet(int playerScore, int opponentScore) {
      return playerScore == 5 && opponentScore < 5;
    }

    private String display() {
      return displayPlayer("A", playerAGames, playerAPoints, playerBPoints) +
        " " +
        displayPlayer("B", playerBGames, playerBPoints, playerAPoints);
    }

    private String displayPlayer(String player, List<Integer> playerGames, int playerPoints, int opponentPoints) {
      return player + " " + displaySets(playerGames) + " " + displayRunningGame(playerPoints, opponentPoints);
    }

    private String displaySets(List<Integer> playerGames) {
      return playerGames
        .stream()
        .map(Object::toString)
        .collect(Collectors.joining(" "));
    }

    private String displayRunningGame(int firstPlayerPoints, int secondPlayerPoints) {
      if (isAnEquality(firstPlayerPoints, secondPlayerPoints))
        return "deuce";

      if (isAContestedGame(firstPlayerPoints, secondPlayerPoints)) {
        if (firstPlayerPoints > secondPlayerPoints)
          return "advantage";
        return POINTS_CORRESPONDENCE.get(0);
      }

      return POINTS_CORRESPONDENCE.get(firstPlayerPoints);
    }

    private boolean isAnEquality(int firstPlayerPoints, int secondPlayerPoints) {
      return firstPlayerPoints == secondPlayerPoints && firstPlayerPoints > 0;
    }

    private boolean isAContestedGame(int firstPlayerPoints, int secondPlayerPoints) {
      return firstPlayerPoints > 2 && secondPlayerPoints > 2;
    }
  }
}
