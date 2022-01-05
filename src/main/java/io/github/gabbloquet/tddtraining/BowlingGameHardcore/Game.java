package io.github.gabbloquet.tddtraining.BowlingGameHardcore;

import java.util.*;

public class Game {
  private final List<Integer> strikes;

  public Game() {
    this.strikes = new LinkedList<>();
  }

  public void roll(int downedPins) {
    strikes.add(downedPins);
  }


  public int score() {
    int score = 0;
    for(int i = 0; i < strikes.size(); i++){
      if(isNotTheFirstThrow(i)) {
        if(wasAStrikeSuite(strikes, i) && isTwoThrowsLeft(strikes, i)){
          score += strikes.get(i) * 3;
        } else if(wasAStrike(strikes, i) && isTwoThrowsLeft(strikes, i)){
          score += strikes.get(i) * 2;
        } else if(wasAStrikeSuite(strikes, i) && isOneThrowLeft(strikes, i)){
          score += strikes.get(i) * 2;
        } else if(wasASpare(strikes, i)){
          score += strikes.get(i) * 2;
        } else {
          score += strikes.get(i);
        }
      } else {
        score += strikes.get(i);
      }
    }
    return score;
  }

  private boolean isOneThrowLeft(List<Integer> strikes, int position) {
    return strikes.size() - 2 == position;
  }

  private boolean isTwoThrowsLeft(List<Integer> strikes, int position) {
    int totalPosition = strikes.size() - 1;
    return totalPosition != position && totalPosition - 1 != position;
  }

  private boolean wasAStrikeSuite(List<Integer> strikes, Integer position) {
    if(position > 1 && strikes.get(position -1 ) == 10 && strikes.get(position - 2 ) == 10) {
      return true;
    }
   return false;
  }
  private boolean wasAStrike(List<Integer> strikes, Integer position) {
    if(position == 1 && strikes.get(0) == 10) {
      return true;
    } else if(position > 1 && (strikes.get(position - 1) == 10 || strikes.get(position - 2) == 10)) {
      return true;
    } else {
     return false;
    }
  }

  private boolean isNotTheFirstThrow(int i) {
    return i > 0;
  }

  private boolean wasASpare(List<Integer> strikes, Integer position) {
    return position % 2 == 0 && (strikes.get(position - 1) + strikes.get(position - 2) == 10);
  }
}
