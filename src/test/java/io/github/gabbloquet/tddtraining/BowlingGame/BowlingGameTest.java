package io.github.gabbloquet.tddtraining.BowlingGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {

  private BowlingGame bowlingGame;

  @BeforeEach
  void setUp() {
    bowlingGame = new BowlingGame();
  }

  private void rollMany(int rollsNumber, int score) {
    for(int i = 0; i < rollsNumber; i++){
      bowlingGame.roll(score);
    }
  }
  private void doASpare(int firstTry, int secondTry) {
    bowlingGame.roll(firstTry);
    bowlingGame.roll(secondTry);
  }
  private void doAStrike() {
    bowlingGame.roll(10);
  }

  @Test
  void should_return_1_as_score_if_the_player_scores_1() {
    int userScore = 1;

    bowlingGame.roll(userScore);

    assertEquals(1, bowlingGame.score());
  }

  @Test
  void should_return_2_as_score_if_the_player_scores_2() {
    int userScore = 2;

    bowlingGame.roll(userScore);

    assertEquals(2, bowlingGame.score());
  }

  @Test
  void should_return_3_as_score_if_the_player_scores_1_and_2() {
    int firstTry = 1;
    int secondTry = 2;

    bowlingGame.roll(firstTry);
    bowlingGame.roll(secondTry);

    assertEquals(3, bowlingGame.score());
  }

  @Test
  void should_return_20_as_score_if_the_player_scores_1_twenty_times() {
    int playerScore = 1;

    rollMany(20, playerScore);

    assertEquals(20, bowlingGame.score());
  }

  @Test
  void should_return_40_as_score_if_the_player_scores_2_twenty_times() {
    int playerScore = 2;

    rollMany(20, playerScore);

    assertEquals(40, bowlingGame.score());
  }

  @Test
  void should_return_10_as_score_if_the_player_scores_6_and_4() {
    doASpare(6, 4);

    rollMany(18, 0);

    assertEquals(10, bowlingGame.score());
  }

  @Test
  void should_return_18_if_the_player_spare_and_then_scores_4() {
    int playerScore = 4;

    doASpare(1, 9);
    bowlingGame.roll(playerScore);

    rollMany(17, 0);

    assertEquals(18, bowlingGame.score());
  }

  @Test
  void should_return_43_if_the_player_does_3_spares_1_9_then_7_3_then_7_2() {
    doASpare(1, 9);
    doASpare(7, 3);
    doASpare(7, 2);

    rollMany(15, 0);

    assertEquals(43, bowlingGame.score());
  }

  @Test
  void should_return_11_if_the_player_does_a_strike_and_1_later() {
    doAStrike();
    bowlingGame.roll(0);
    bowlingGame.roll(0);
    bowlingGame.roll(1);

    rollMany(15, 0);

    assertEquals(11, bowlingGame.score());
  }

  @Test
  void should_return_19_if_the_player_does_a_strike_then_2_and_5_later() {
    doAStrike();
    bowlingGame.roll(2);
    bowlingGame.roll(0);
    bowlingGame.roll(5);

    rollMany(15, 0);

    assertEquals(19, bowlingGame.score());
  }

  @Test
  void should_return_20_if_the_player_does_a_strike_then_1_and_4() {
    doAStrike();
    bowlingGame.roll(1);
    bowlingGame.roll(4);

    rollMany(16, 0);

    assertEquals(20, bowlingGame.score());
  }

  @Test
  void should_return_42_if_the_player_does_2_strikes_then_4() {
    doAStrike();
    doAStrike();
    bowlingGame.roll(4);

    rollMany(15, 0);

    assertEquals(42, bowlingGame.score());
  }

  @Test
  void should_return_60_if_the_player_does_3_strikes() {
    doAStrike();
    doAStrike();
    doAStrike();

    rollMany(14, 0);

    assertEquals(60, bowlingGame.score());
  }

  @Test
  void should_return_52_if_the_player_does_2_strikes_then_4_and_at_then_end_10_and_0() {
    doAStrike();
    doAStrike();
    bowlingGame.roll(4);

    rollMany(15, 0);

    doAStrike();
    bowlingGame.roll(0);

    assertEquals(52, bowlingGame.score());
  }

  @Test
  void should_return_57_if_the_player_does_2_strikes_then_4_and_at_then_end_10_and_5() {
    doAStrike();
    doAStrike();
    bowlingGame.roll(4);

    rollMany(15, 0);

    doAStrike();
    bowlingGame.roll(5);

    assertEquals(57, bowlingGame.score());
  }

  @Test
  void should_return_61_if_the_player_does_2_strikes_then_4_and_at_then_end_10_then_7_and_2() {
    doAStrike();
    doAStrike();
    bowlingGame.roll(4);

    rollMany(13, 0);

    doAStrike();
    bowlingGame.roll(7);
    bowlingGame.roll(2);

    assertEquals(61, bowlingGame.score());
  }

  @Test
  void should_return_300_if_the_player_is_a_genius() {

    rollMany(12, 10);

    assertEquals(300, bowlingGame.score());
  }
}
