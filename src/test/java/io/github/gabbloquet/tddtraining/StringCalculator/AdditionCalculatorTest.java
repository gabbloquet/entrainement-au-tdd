package io.github.gabbloquet.tddtraining.StringCalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AdditionCalculatorTest {

  private final StringCalculator additionCalculator = new AdditionCalculator();

  @Test
  void should_return_0_by_default() throws UnexpectedNewlineException, NotANumberException, UnexpectedCommaException, NegativeNotAllowedException , NotCompliantOperationException {
    assertThat(additionCalculator.calculate("")).isEqualTo("0");
  }

  @Test
  void should_return_1_if_operation_is_1() throws UnexpectedNewlineException, NotANumberException, UnexpectedCommaException, NegativeNotAllowedException , NotCompliantOperationException {
    assertThat(additionCalculator.calculate("1")).isEqualTo("1");
  }

  @Test
  void should_return_2_if_operation_is_1_comma_1() throws UnexpectedNewlineException, NotANumberException, UnexpectedCommaException, NegativeNotAllowedException , NotCompliantOperationException {
    assertThat(additionCalculator.calculate("1,1")).isEqualTo("2");
  }

  @Test
  void should_return_3_comma_3_if_operation_is_1_dot_1_and_2_dot_2() throws UnexpectedNewlineException, NotANumberException, UnexpectedCommaException, NegativeNotAllowedException , NotCompliantOperationException {
    assertThat(additionCalculator.calculate("1.1,2.2")).isEqualTo("3,3");
  }

  @Test
  void should_return_6_if_operation_is_1_comma_2_comma_3() throws UnexpectedNewlineException, NotANumberException, UnexpectedCommaException, NegativeNotAllowedException , NotCompliantOperationException {
    assertThat(additionCalculator.calculate("1,2,3")).isEqualTo("6");
  }

  @Test
  void should_return_16_if_operation_is_1_comma_2_comma_3_comma_10() throws UnexpectedNewlineException, NotANumberException, UnexpectedCommaException, NegativeNotAllowedException , NotCompliantOperationException {
    assertThat(additionCalculator.calculate("1,2,3,10")).isEqualTo("16");
  }

  @Test
  void should_return_6_if_operation_is_1_newline_2_comma_3() throws UnexpectedNewlineException, NotANumberException, UnexpectedCommaException, NegativeNotAllowedException , NotCompliantOperationException {
    assertThat(additionCalculator.calculate("1\n2,3")).isEqualTo("6");
  }

  @Test
  void should_throw_unexpected_newline_at_position_six(){
    assertThatThrownBy(() -> additionCalculator.calculate("175.2,\n35"))
      .isInstanceOf(UnexpectedNewlineException.class)
      .hasMessageContaining("Number expected but '\n' found at position 6.");
  }

  @Test
  void should_throw_unexpected_newline_at_position_3(){
    assertThatThrownBy(() -> additionCalculator.calculate("12,\n2"))
      .isInstanceOf(UnexpectedNewlineException.class)
      .hasMessageContaining("Number expected but '\n' found at position 3.");
  }

  @Test
  void should_throw_not_a_number_exception_if_finish_by_1_comma(){
    assertThatThrownBy(() -> additionCalculator.calculate("1,"))
      .isInstanceOf(NotANumberException.class)
      .hasMessageContaining("Number expected but \n or , found.");
  }

  @Test
  void should_throw_not_a_number_exception_if_finish_by_123_comma(){
    assertThatThrownBy(() -> additionCalculator.calculate("123,"))
      .isInstanceOf(NotANumberException.class)
      .hasMessageContaining("Number expected but \n or , found.");
  }

  @Test
  void should_throw_not_a_number_exception_if_finish_by_12_comma_1_newline(){
    assertThatThrownBy(() -> additionCalculator.calculate("12,1\n"))
      .isInstanceOf(NotANumberException.class)
      .hasMessageContaining("Number expected but \n or , found.");
  }

  @Test
  void should_return_3_with_semicolon_as_delimiter() throws NotANumberException, UnexpectedNewlineException, UnexpectedCommaException, NegativeNotAllowedException , NotCompliantOperationException {
    assertThat(additionCalculator.calculate("//;\n1;2")).isEqualTo("3");
  }

  @Test
  void should_return_6_with_pipe_as_delimiter() throws NotANumberException, UnexpectedNewlineException, UnexpectedCommaException, NegativeNotAllowedException , NotCompliantOperationException {
    assertThat(additionCalculator.calculate("//|\n1|2|3")).isEqualTo("6");
  }

  @Test
  void should_return_5_with_text_as_delimiter() throws NotANumberException, UnexpectedNewlineException, UnexpectedCommaException, NegativeNotAllowedException , NotCompliantOperationException {
    assertThat(additionCalculator.calculate("//sep\n2sep3")).isEqualTo("5");
  }

  @Test
  void should_throw_unexpected_comma_exception_pipe_delimiter_is_choose(){
    assertThatThrownBy(() -> additionCalculator.calculate("//|\n1|2,3"))
      .isInstanceOf(UnexpectedCommaException.class)
      .hasMessageContaining("'|' expected but ',' found at position 3.");
  }

  @Test
  void should_throw_unexpected_comma_exception_if_toto_delimiter_is_choose(){
    assertThatThrownBy(() -> additionCalculator.calculate("//toto\n12.3toto2,3"))
      .isInstanceOf(UnexpectedCommaException.class)
      .hasMessageContaining("'toto' expected but ',' found at position 9.");
  }

  @Test
  void should_throw_negative_not_allowed_exception_if_operation_contains_minus_one(){
    assertThatThrownBy(() -> additionCalculator.calculate("-1,2"))
      .isInstanceOf(NegativeNotAllowedException.class)
      .hasMessageContaining("Negative not allowed : -1");
  }

  @Test
  void should_throw_negative_not_allowed_exception_if_operation_contains_minus_four_minus_five(){
    assertThatThrownBy(() -> additionCalculator.calculate("2,-4,-5"))
      .isInstanceOf(NegativeNotAllowedException.class)
      .hasMessageContaining("Negative not allowed : -4, -5");
  }

  @Test
  void should_throw_a_common_error_exception_if_operation_contains_several_errors(){
    assertThatThrownBy(() -> additionCalculator.calculate("-1,,2"))
      .isInstanceOf(NotCompliantOperationException.class)
      .hasMessageContaining("Negative not allowed : -1\nNumber expected but ',' found at position 3.");
  }

  @Test
  void should_throw_a_common_error_exception_if_operation_contains_several_negatives(){
    assertThatThrownBy(() -> additionCalculator.calculate("1,-2,-3,,4"))
      .isInstanceOf(NotCompliantOperationException.class)
      .hasMessageContaining("Negative not allowed : -2, -3\nNumber expected but ',' found at position 8.");
  }

  @Test
  void should_throw_a_common_error_exception_if_operation_contains_unexpected_newline(){
    assertThatThrownBy(() -> additionCalculator.calculate("1,-2,-3,\n4"))
      .isInstanceOf(NotCompliantOperationException.class)
      .hasMessageContaining("Negative not allowed : -2, -3\nNumber expected but '\n' found at position 8.");
  }

  @Test
  void should_throw_a_common_error_exception_if_operation_contains_all_errors(){
    assertThatThrownBy(() -> additionCalculator.calculate("1,-2,-3,\n4,,5"))
      .isInstanceOf(NotCompliantOperationException.class)
      .hasMessageContaining("Negative not allowed : -2, -3\nNumber expected but '\n' found at position 8.\nNumber expected but ',' found at position 11.");
  }

}
