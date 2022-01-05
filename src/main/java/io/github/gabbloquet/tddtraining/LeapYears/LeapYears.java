package io.github.gabbloquet.tddtraining.LeapYears;

public class LeapYears {

  public boolean isLeapYear(int year) {
    if(isDivisibleBy4(year)) {
      if (isDivisibleBy400(year)) {
        return true;
      }
      return !isDivisibleBy100(year);
    }
    return false;
  }

  private boolean isDivisibleBy100(int year) {
    return year % 100 == 0;
  }

  private boolean isDivisibleBy400(int year) {
    return year % 400 == 0;
  }

  private boolean isDivisibleBy4(int year) {
    return year % 4 == 0 && year > 0;
  }
}
