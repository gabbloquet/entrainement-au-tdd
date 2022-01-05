package io.github.gabbloquet.tddtraining.StringCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

  private final StringCalculator stringCalculator = new StringCalculator();

  @Test
  void should_return_0_by_default() throws UnexpectedNewlineException, NotANumberException , UnexpectedCommaException {
    assertEquals("0", stringCalculator.add(""));
  }

  @Test
  void should_return_1_if_operation_is_1() throws UnexpectedNewlineException, NotANumberException , UnexpectedCommaException {
    assertEquals("1", stringCalculator.add("1"));
  }

  @Test
  void should_return_2_if_operation_is_1_comma_1() throws UnexpectedNewlineException, NotANumberException , UnexpectedCommaException {
    assertEquals("2", stringCalculator.add("1,1"));
  }

  @Test
  void should_return_3_comma_3_if_operation_is_1_dot_1_and_2_dot_2() throws UnexpectedNewlineException, NotANumberException , UnexpectedCommaException {
    assertEquals("3,3", stringCalculator.add("1.1,2.2"));
  }

  @Test
  void should_return_6_if_operation_is_1_comma_2_comma_3() throws UnexpectedNewlineException, NotANumberException , UnexpectedCommaException {
    assertEquals("6", stringCalculator.add("1,2,3"));
  }

  @Test
  void should_return_16_if_operation_is_1_comma_2_comma_3_comma_10() throws UnexpectedNewlineException, NotANumberException , UnexpectedCommaException {
    assertEquals("16", stringCalculator.add("1,2,3,10"));
  }

  @Test
  void should_return_6_if_operation_is_1_newline_2_comma_3() throws UnexpectedNewlineException, NotANumberException , UnexpectedCommaException {
    assertEquals("6", stringCalculator.add("1\n2,3"));
  }

  @Test
  void should_throw_unexpected_newline_at_position_six(){
    Exception exception = assertThrows(UnexpectedNewlineException.class, () -> {
      stringCalculator.add("175.2,\n35");
    });

    String expectedMessage = "Nombre attendu mais '\n' trouvé en position 6.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void should_throw_unexpected_newline_at_position_3(){
    Exception exception = assertThrows(UnexpectedNewlineException.class, () -> {
      stringCalculator.add("12,\n2");
    });

    String expectedMessage = "Nombre attendu mais '\n' trouvé en position 3.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void should_throw_not_a_number_exception_if_finish_by_1_comma(){
    Exception exception = assertThrows(NotANumberException.class, () -> {
      stringCalculator.add("1,");
    });

    String expectedMessage = "Number expected but \n or , found.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void should_throw_not_a_number_exception_if_finish_by_123_comma(){
    Exception exception = assertThrows(NotANumberException.class, () -> {
      stringCalculator.add("123,");
    });

    String expectedMessage = "Number expected but \n or , found.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void should_throw_not_a_number_exception_if_finish_by_12_comma_1_newline(){
    Exception exception = assertThrows(NotANumberException.class, () -> {
      stringCalculator.add("12,1\n");
    });

    String expectedMessage = "Number expected but \n or , found.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void should_return_3_with_semicolon_as_delimiter() throws NotANumberException, UnexpectedNewlineException , UnexpectedCommaException {
    assertEquals("3", stringCalculator.add("//;\n1;2"));
  }

  @Test
  void should_return_6_with_pipe_as_delimiter() throws NotANumberException, UnexpectedNewlineException , UnexpectedCommaException {
    assertEquals("6", stringCalculator.add("//|\n1|2|3"));
  }

  @Test
  void should_return_5_with_text_as_delimiter() throws NotANumberException, UnexpectedNewlineException , UnexpectedCommaException {
    assertEquals("5", stringCalculator.add("//sep\n2sep3"));
  }

  @Test
  void should_throw_unexpected_comma_exception_pipe_delimiter_is_choose(){
    Exception exception = assertThrows(UnexpectedCommaException.class, () -> {
      stringCalculator.add("//|\n1|2,3");
    });

    String expectedMessage = "'|' expected but ',' found at position 3.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void should_throw_unexpected_comma_exception_if_toto_delimiter_is_choose(){
    Exception exception = assertThrows(UnexpectedCommaException.class, () -> {
      stringCalculator.add("//toto\n12.3toto2,3");
    });

    String expectedMessage = "'toto' expected but ',' found at position 9.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void should_throw_negative_not_allowed_exception_if_operation_contains_minus_one(){
    Exception exception = assertThrows(NegativeNotAllowedException.class, () -> {
      stringCalculator.add("-1,2");
    });

    String expectedMessage = "Negative not allowed : -1";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

}
