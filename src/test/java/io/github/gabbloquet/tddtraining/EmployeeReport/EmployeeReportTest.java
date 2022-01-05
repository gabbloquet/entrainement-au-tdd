package io.github.gabbloquet.tddtraining.EmployeeReport;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeReportTest {

  private final EmployeeReport employeeReport = new EmployeeReport();

  @Test
  void should_return_all_employees() {
    List<Employee> employees = List.of(
      new Employee("Max", 17),
      new Employee("Sepp", 18),
      new Employee("Nina", 15),
      new Employee("Mike", 51)
    );
    assertEquals(employees, employeeReport.getEmployees());
  }
}
