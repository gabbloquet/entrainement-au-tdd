package io.github.gabbloquet.tddtraining.StringCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdditionCalculatorTest {

  private final StringCalculator additionCalculator = new AdditionCalculator();

  @Test
  void should_return_0_by_default() throws UnexpectedNewlineException, NotANumberException, UnexpectedCommaException, NegativeNotAllowedException , NotCompliantOperationException {
    assertEquals("0", additionCalculator.calculate(""));
  }

  @Test
  void should_return_1_if_operation_is_1() throws UnexpectedNewlineException, NotANumberException, UnexpectedCommaException, NegativeNotAllowedException , NotCompliantOperationException {
    assertEquals("1", additionCalculator.calculate("1"));
  }

  @Test
  void should_return_2_if_operation_is_1_comma_1() throws UnexpectedNewlineException, NotANumberException, UnexpectedCommaException, NegativeNotAllowedException , NotCompliantOperationException {
    assertEquals("2", additionCalculator.calculate("1,1"));
  }

  @Test
  void should_return_3_comma_3_if_operation_is_1_dot_1_and_2_dot_2() throws UnexpectedNewlineException, NotANumberException, UnexpectedCommaException, NegativeNotAllowedException , NotCompliantOperationException {
    assertEquals("3,3", additionCalculator.calculate("1.1,2.2"));
  }

  @Test
  void should_return_6_if_operation_is_1_comma_2_comma_3() throws UnexpectedNewlineException, NotANumberException, UnexpectedCommaException, NegativeNotAllowedException , NotCompliantOperationException {
    assertEquals("6", additionCalculator.calculate("1,2,3"));
  }

  @Test
  void should_return_16_if_operation_is_1_comma_2_comma_3_comma_10() throws UnexpectedNewlineException, NotANumberException, UnexpectedCommaException, NegativeNotAllowedException , NotCompliantOperationException {
    assertEquals("16", additionCalculator.calculate("1,2,3,10"));
  }

  @Test
  void should_return_6_if_operation_is_1_newline_2_comma_3() throws UnexpectedNewlineException, NotANumberException, UnexpectedCommaException, NegativeNotAllowedException , NotCompliantOperationException {
    assertEquals("6", additionCalculator.calculate("1\n2,3"));
  }

  @Test
  void should_throw_unexpected_newline_at_position_six(){
    Exception exception = assertThrows(UnexpectedNewlineException.class, () -> {
      additionCalculator.calculate("175.2,\n35");
    });

    String expectedMessage = "Number expected but '\n' found at position 6.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void should_throw_unexpected_newline_at_position_3(){
    Exception exception = assertThrows(UnexpectedNewlineException.class, () -> {
      additionCalculator.calculate("12,\n2");
    });

    String expectedMessage = "Number expected but '\n' found at position 3.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void should_throw_not_a_number_exception_if_finish_by_1_comma(){
    Exception exception = assertThrows(NotANumberException.class, () -> {
      additionCalculator.calculate("1,");
    });

    String expectedMessage = "Number expected but \n or , found.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void should_throw_not_a_number_exception_if_finish_by_123_comma(){
    Exception exception = assertThrows(NotANumberException.class, () -> {
      additionCalculator.calculate("123,");
    });

    String expectedMessage = "Number expected but \n or , found.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void should_throw_not_a_number_exception_if_finish_by_12_comma_1_newline(){
    Exception exception = assertThrows(NotANumberException.class, () -> {
      additionCalculator.calculate("12,1\n");
    });

    String expectedMessage = "Number expected but \n or , found.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void should_return_3_with_semicolon_as_delimiter() throws NotANumberException, UnexpectedNewlineException, UnexpectedCommaException, NegativeNotAllowedException , NotCompliantOperationException {
    assertEquals("3", additionCalculator.calculate("//;\n1;2"));
  }

  @Test
  void should_return_6_with_pipe_as_delimiter() throws NotANumberException, UnexpectedNewlineException, UnexpectedCommaException, NegativeNotAllowedException , NotCompliantOperationException {
    assertEquals("6", additionCalculator.calculate("//|\n1|2|3"));
  }

  @Test
  void should_return_5_with_text_as_delimiter() throws NotANumberException, UnexpectedNewlineException, UnexpectedCommaException, NegativeNotAllowedException , NotCompliantOperationException {
    assertEquals("5", additionCalculator.calculate("//sep\n2sep3"));
  }

  @Test
  void should_throw_unexpected_comma_exception_pipe_delimiter_is_choose(){
    Exception exception = assertThrows(UnexpectedCommaException.class, () -> {
      additionCalculator.calculate("//|\n1|2,3");
    });

    String expectedMessage = "'|' expected but ',' found at position 3.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void should_throw_unexpected_comma_exception_if_toto_delimiter_is_choose(){
    Exception exception = assertThrows(UnexpectedCommaException.class, () -> {
      additionCalculator.calculate("//toto\n12.3toto2,3");
    });

    String expectedMessage = "'toto' expected but ',' found at position 9.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void should_throw_negative_not_allowed_exception_if_operation_contains_minus_one(){
    Exception exception = assertThrows(NegativeNotAllowedException.class, () -> {
      additionCalculator.calculate("-1,2");
    });

    String expectedMessage = "Negative not allowed : -1";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void should_throw_negative_not_allowed_exception_if_operation_contains_minus_four_minus_five(){
    Exception exception = assertThrows(NegativeNotAllowedException.class, () -> {
      additionCalculator.calculate("2,-4,-5");
    });

    String expectedMessage = "Negative not allowed : -4, -5";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void should_throw_a_common_error_exception_if_operation_contains_several_errors(){
    Exception exception = assertThrows(NotCompliantOperationException.class, () -> {
      additionCalculator.calculate("-1,,2");
    });

    String expectedMessage = "Negative not allowed : -1\nNumber expected but ',' found at position 3.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void should_throw_a_common_error_exception_if_operation_contains_several_negatives(){
    Exception exception = assertThrows(NotCompliantOperationException.class, () -> {
      additionCalculator.calculate("1,-2,-3,,4");
    });

    String expectedMessage = "Negative not allowed : -2, -3\nNumber expected but ',' found at position 8.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void should_throw_a_common_error_exception_if_operation_contains_unexpected_newline(){
    Exception exception = assertThrows(NotCompliantOperationException.class, () -> {
      additionCalculator.calculate("1,-2,-3,\n4");
    });

    String expectedMessage = "Negative not allowed : -2, -3\nNumber expected but '\n' found at position 8.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void should_throw_a_common_error_exception_if_operation_contains_all_errors(){
    Exception exception = assertThrows(NotCompliantOperationException.class, () -> {
      additionCalculator.calculate("1,-2,-3,\n4,,5");
    });

    String expectedMessage = "Negative not allowed : -2, -3\nNumber expected but '\n' found at position 8.\nNumber expected but ',' found at position 11.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

}
