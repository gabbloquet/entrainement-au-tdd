package io.github.gabbloquet.tddtraining.EmployeeReport;

import java.util.List;

public class EmployeeReport {

  private List<Employee> employees = List.of(
    new Employee("Max", 17),
    new Employee("Sepp", 18),
    new Employee("Nina", 15),
    new Employee("Mike", 51)
  );

  public List<Employee> getEmployees() {
    return employees;
  }
}
