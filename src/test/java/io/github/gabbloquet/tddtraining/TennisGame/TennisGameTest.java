package io.github.gabbloquet.tddtraining.TennisGame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TennisGameTest {

  @Test
  void should_initialize_a_game() {
    TennisGame tennisGame = new TennisGame("");
    Assertions.assertEquals("A 0 0 0 0 0 0 B 0 0 0 0 0 0", tennisGame.getScore());
  }

}
