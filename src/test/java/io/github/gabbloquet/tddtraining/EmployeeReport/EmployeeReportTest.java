package io.github.gabbloquet.tddtraining.EmployeeReport;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeeReportTest {

  private final EmployeeReport employeeReport = new EmployeeReport();

  @Test
  void should_return_all_employees() {
    List<String> employees = List.of(
      "Max",
      "Sepp",
      "Nina",
      "Mike"
    );
    assertThat(employeeReport.getEmployees()).isEqualTo(employees);
  }

  @Test
  void should_return_adults_sorted_by_name_descending_in_uppercase() {
    List<String> employees = List.of(
      "SEPP",
      "MIKE"
    );
    assertThat(employeeReport.getList()).isEqualTo(employees);
  }
}
