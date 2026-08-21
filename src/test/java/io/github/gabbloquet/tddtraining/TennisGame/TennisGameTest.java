package io.github.gabbloquet.tddtraining.TennisGame;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class TennisGameTest {

  @Test
  void should_initialize_a_game() {
    TennisGame tennisGame = new TennisGame("");
    assertThat(tennisGame.getScore()).isEqualTo("A 0 0 0 0 0 0 B 0 0 0 0 0 0");
  }

  @Test
  void should_score_the_same_match_twice() {
    TennisGame tennisGame = new TennisGame("A,A,A,A");

    assertThat(tennisGame.getScore()).isEqualTo("A 1 0 0 0 0 0 B 0 0 0 0 0 0");
    assertThat(tennisGame.getScore()).isEqualTo("A 1 0 0 0 0 0 B 0 0 0 0 0 0");
  }

  @Test
  void should_score_a_running_game() {
    TennisGame aWonApoint = new TennisGame("A");
    assertThat(aWonApoint.getScore()).isEqualTo("A 0 0 0 0 0 15 B 0 0 0 0 0 0");

    TennisGame bWonTwoPoints = new TennisGame("B,B");
    assertThat(bWonTwoPoints.getScore()).isEqualTo("A 0 0 0 0 0 0 B 0 0 0 0 0 30");

    TennisGame aWonThreePointsBOne = new TennisGame("A,A,A,B");
    assertThat(aWonThreePointsBOne.getScore()).isEqualTo("A 0 0 0 0 0 40 B 0 0 0 0 0 15");

    TennisGame aWonThreePointsBTwo = new TennisGame("A,A,A,B,B");
    assertThat(aWonThreePointsBTwo.getScore()).isEqualTo("A 0 0 0 0 0 40 B 0 0 0 0 0 30");
  }

  @Test
  void should_score_an_advantage() {
    TennisGame aHasTheAdvantage = new TennisGame("A,B,A,B,A,B,A");
    assertThat(aHasTheAdvantage.getScore()).isEqualTo("A 0 0 0 0 0 advantage B 0 0 0 0 0 0");

    TennisGame bHasTheAdvantage = new TennisGame("A,B,A,B,A,B,B");
    assertThat(bHasTheAdvantage.getScore()).isEqualTo("A 0 0 0 0 0 0 B 0 0 0 0 0 advantage");
  }

  @Test
  void should_score_a_deuce() {
    TennisGame aBasicDeuceGame = new TennisGame("A,B,A,B,A,B,A,B,A,B");
    assertThat(aBasicDeuceGame.getScore()).isEqualTo("A 0 0 0 0 0 deuce B 0 0 0 0 0 deuce");
  }

  @Test
  void should_win_games() {
    TennisGame aWonTwoGamesBone = new TennisGame("A,A,A,B,A,A,A,A,B,A,B,B,A,B,B");
    assertThat(aWonTwoGamesBone.getScore()).isEqualTo("A 2 0 0 0 0 0 B 1 0 0 0 0 0");
  }

  @Test
  void should_win_sets() {
    TennisGame aWonASetAndAGame = new TennisGame("A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A");
    assertThat(aWonASetAndAGame.getScore()).isEqualTo("A 6 1 0 0 0 0 B 0 0 0 0 0 0");

    TennisGame aWonASetAndBWonASet = new TennisGame("A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B");
    assertThat(aWonASetAndBWonASet.getScore()).isEqualTo("A 6 1 0 0 0 0 B 2 6 0 0 0 0");

    TennisGame aWonASetWith7Games = new TennisGame("A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,A,A,A,A,A,A,A,A");
    assertThat(aWonASetWith7Games.getScore()).isEqualTo("A 7 0 0 0 0 0 B 5 0 0 0 0 0");
  }

  @Test
  void should_play_a_tie_break() {
    TennisGame aWonTheTieBreak = new TennisGame("A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,A,A,A,A,B,B,B,B,A,A,A,A,A,A,A");
    assertThat(aWonTheTieBreak.getScore()).isEqualTo("A 7 0 0 0 0 0 B 6 0 0 0 0 0");

    TennisGame bWonAContestedTieBreak = new TennisGame("A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,A,A,A,A,B,B,B,B,A,A,A,A,A,A,B,B,B,B,B,B,B,B");
    assertThat(bWonAContestedTieBreak.getScore()).isEqualTo("A 6 0 0 0 0 0 B 7 0 0 0 0 0");
  }

  @Test
  void should_play_a_full_match() {
    TennisGame aWonTheGameEasily = new TennisGame("A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A");
    assertThat(aWonTheGameEasily.getScore()).isEqualTo("A 6 1 6 6 0 0 B 2 6 0 0 0 0");

    TennisGame aWonAContestedMatch = new TennisGame("A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,A,A,A,A,B,B,B,B,A,A,A,A,A,A,A,A");
    assertThat(aWonAContestedMatch.getScore()).isEqualTo("A 6 1 6 1 8 0 B 2 6 2 6 6 0");
  }

}
