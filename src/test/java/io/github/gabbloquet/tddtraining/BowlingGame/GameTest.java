package io.github.gabbloquet.tddtraining.BowlingGame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {
  private Game game;

  @BeforeEach
  void setUp() {
    game = new Game();
  }

  private void rollMany(int times, int score) {
    for(int i = 0; i < times; i++)
      game.roll(score);
  }

  @Test
  void should_return_0_for_a_gutter_game() {
    rollMany(20, 0);
    Assertions.assertEquals(0, game.score());
  }

  @Test
  void should_return_20_for_all_ones() {
    rollMany(20, 1);
    Assertions.assertEquals(20, game.score());
  }

  @Test
  void should_add_next_frame_score_when_spare() {
    rollSpare();
    game.roll(4);
    rollMany(17, 0);
    Assertions.assertEquals(18, game.score());
  }

  private void rollSpare() {
    game.roll(7);
    game.roll(3);
  }

  @Test
  void should_add_2_next_frame_score_when_strike() {
    rollStrike();
    game.roll(2);
    game.roll(3);
    rollMany(16, 0);
    Assertions.assertEquals(20, game.score());
  }

  private void rollStrike() {
    game.roll(10);
  }

  @Test
  void roll_a_perfect_game() {
    rollMany(12, 10);
    Assertions.assertEquals(300, game.score());
  }
}
