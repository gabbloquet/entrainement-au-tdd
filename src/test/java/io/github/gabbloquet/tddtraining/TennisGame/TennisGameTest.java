package io.github.gabbloquet.tddtraining.TennisGame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TennisGameTest {

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

}
