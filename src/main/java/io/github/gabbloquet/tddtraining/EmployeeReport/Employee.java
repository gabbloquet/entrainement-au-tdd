package io.github.gabbloquet.tddtraining.EmployeeReport;

public record Employee(String name, int age) {
  public boolean isAdult() {
    return age() >= 18;
  }

  public String getName() {
    return name().toUpperCase();
  }
}
