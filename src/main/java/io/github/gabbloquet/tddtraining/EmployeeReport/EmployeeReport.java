package io.github.gabbloquet.tddtraining.EmployeeReport;

import java.util.Comparator;
import java.util.List;

public class EmployeeReport {

  private final List<Employee> employees = List.of(
    new Employee("Max", 17),
    new Employee("Sepp", 18),
    new Employee("Nina", 15),
    new Employee("Mike", 51)
  );

  public List<String> getEmployees() {
    return employees.stream()
      .map(Employee::name)
      .toList();
  }

  public List<String> getList() {
    return employees.stream()
      .filter(Employee::isAdult)
      .map(Employee::getName)
      .sorted(Comparator.reverseOrder())
      .toList();
  }
}
