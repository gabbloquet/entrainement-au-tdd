package io.github.gabbloquet.tddtraining.TennisGame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TennisGameTest {

  @Test
  void should_initialize_a_game() {
    TennisGame tennisGame = new TennisGame("");
    Assertions.assertEquals("A 0 0 0 0 0 0 B 0 0 0 0 0 0", tennisGame.getScore());
  }

  @Test
  void should_score_a_running_game() {
    TennisGame aWonApoint = new TennisGame("A");
    Assertions.assertEquals("A 0 0 0 0 0 15 B 0 0 0 0 0 0", aWonApoint.getScore());

    TennisGame bWonTwoPoints = new TennisGame("B,B");
    Assertions.assertEquals("A 0 0 0 0 0 0 B 0 0 0 0 0 30", bWonTwoPoints.getScore());

    TennisGame aWonThreePointsBOne = new TennisGame("A,A,A,B");
    Assertions.assertEquals("A 0 0 0 0 0 40 B 0 0 0 0 0 15", aWonThreePointsBOne.getScore());
  }

  @Test
  void should_score_an_advantage() {
    TennisGame aHasTheAdvantage = new TennisGame("A,B,A,B,A,B,A");
    Assertions.assertEquals("A 0 0 0 0 0 advantage B 0 0 0 0 0 0", aHasTheAdvantage.getScore());

    TennisGame bHasTheAdvantage = new TennisGame("A,B,A,B,A,B,B");
    Assertions.assertEquals("A 0 0 0 0 0 0 B 0 0 0 0 0 advantage", bHasTheAdvantage.getScore());
  }

  @Test
  void should_score_a_deuce() {
    TennisGame aBasicDeuceGame = new TennisGame("A,B,A,B,A,B,A,B,A,B");
    Assertions.assertEquals("A 0 0 0 0 0 deuce B 0 0 0 0 0 deuce", aBasicDeuceGame.getScore());
  }

  @Test
  void should_win_games() {
    TennisGame aWonTwoGamesBone = new TennisGame("A,A,A,B,A,A,A,A,B,A,B,B,A,B,B");
    Assertions.assertEquals("A 2 0 0 0 0 0 B 1 0 0 0 0 0", aWonTwoGamesBone.getScore());
  }

  @Test
  void should_win_sets() {
    TennisGame aWonASetAndAGame = new TennisGame("A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A");
    Assertions.assertEquals("A 6 1 0 0 0 0 B 0 0 0 0 0 0", aWonASetAndAGame.getScore());

    TennisGame aWonASetAndBWonASet = new TennisGame("A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B");
    Assertions.assertEquals("A 6 1 0 0 0 0 B 2 6 0 0 0 0", aWonASetAndBWonASet.getScore());

    TennisGame aWonASetWith7Games = new TennisGame("A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,A,A,A,A,A,A,A,A");
    Assertions.assertEquals("A 7 0 0 0 0 0 B 5 0 0 0 0 0", aWonASetWith7Games.getScore());
  }

  @Test
  void should_play_a_tie_break() {
    TennisGame aWonTheTieBreak = new TennisGame("A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,A,A,A,A,B,B,B,B,A,A,A,A,A,A,A");
    Assertions.assertEquals("A 7 0 0 0 0 0 B 6 0 0 0 0 0", aWonTheTieBreak.getScore());

    TennisGame bWonAContestedTieBreak = new TennisGame("A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,A,A,A,A,B,B,B,B,A,A,A,A,A,A,B,B,B,B,B,B,B,B");
    Assertions.assertEquals("A 6 0 0 0 0 0 B 7 0 0 0 0 0", bWonAContestedTieBreak.getScore());
  }

  @Test
  void should_play_a_full_match() {
    TennisGame aWonTheGameEasily = new TennisGame("A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A");
    Assertions.assertEquals("A 6 1 6 6 0 0 B 2 6 0 0 0 0", aWonTheGameEasily.getScore());

    TennisGame aWonAContestedMatch = new TennisGame("A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,A,A,A,A,B,B,B,B,A,A,A,A,A,A,A,A");
    Assertions.assertEquals("A 6 1 6 1 8 0 B 2 6 2 6 6 0", aWonAContestedMatch.getScore());
  }

}
