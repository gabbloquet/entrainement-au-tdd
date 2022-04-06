package io.github.gabbloquet.tddtraining.TennisGame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TennisGameTest {

  @Test
  void should_score_a_game_with_a_point() {
    TennisGame tennisGame = new TennisGame("A");
    Assertions.assertEquals(tennisGame.score(), "A 0 0 0 0 0 15 B 0 0 0 0 0 0");
  }

  @Test
  void should_score_a_game_with_five_points() {
    TennisGame tennisGame = new TennisGame("A,B,A,B,A");
    Assertions.assertEquals(tennisGame.score(), "A 0 0 0 0 0 40 B 0 0 0 0 0 30");
  }

  @Test
  void should_score_a_game_with_a_won_game() {
    TennisGame tennisGameWonByA = new TennisGame("A,B,A,B,A,A");
    Assertions.assertEquals(tennisGameWonByA.score(), "A 1 0 0 0 0 0 B 0 0 0 0 0 0");

    TennisGame tennisGameWonByB = new TennisGame("A,B,A,B,B,B");
    Assertions.assertEquals(tennisGameWonByB.score(), "A 0 0 0 0 0 0 B 1 0 0 0 0 0");
  }

  @Test
  void should_score_an_advantage_when_users_have_3_points() {
    TennisGame tennisGame = new TennisGame("A,B,A,B,A,B,A");
    Assertions.assertEquals(tennisGame.score(), "A 0 0 0 0 0 advantage B 0 0 0 0 0 0");

    TennisGame tennisGame2 = new TennisGame("A,B,A,B,A,B,B");
    Assertions.assertEquals(tennisGame2.score(), "A 0 0 0 0 0 0 B 0 0 0 0 0 advantage");
  }

}
