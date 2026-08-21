package io.github.gabbloquet.tddtraining.WordWrap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WrapperTest {

  private final Wrapper wrapper = new Wrapper();

  private void assertWrap(String expected, String StringToWrap, int column) {
    assertThat(wrapper.wrap(StringToWrap, column)).isEqualTo(expected);
  }

  @Test
  void shoud_wrap_a_word() {
    assertWrap("toto", "toto", 4);
    assertWrap("x", "x", 1);
  }

  @Test
  void shoud_split_a_word() {
    assertWrap("x\nx", "xx", 1);
    assertWrap("xx\nxx", "xxxx", 2);
    assertWrap("x\nx\nx", "xxx", 1);
  }

  @Test
  void shoud_wrap_two_words() {
    assertWrap("toto\ntata", "toto tata", 4);
    assertWrap("x x", "x x", 3);
    assertWrap("xx\nxx", "xx xx", 2);
    assertWrap("xx\nxx", "xx xx", 3);
    assertWrap("xx\nxx", "xx xx", 4);
    assertWrap("xx xx", "xx xx", 5);
  }

  @Test
  void should_break_on_the_space_when_the_next_word_fills_exactly_a_line() {
    assertWrap("ab\ncdefgh", "ab cdefgh", 6);
  }

  @ParameterizedTest
  @MethodSource
  void should_wrap_the_examples_of_the_readme(String stringToWrap, int column, String expected) {
    assertWrap(expected, stringToWrap, column);
  }

  static Stream<Arguments> should_wrap_the_examples_of_the_readme() {
    return Stream.of(
      arguments("test", 7, "test"),
      arguments("hello world", 7, "hello\nworld"),
      arguments("a lot of words for a single line", 10, "a lot of\nwords for\na single\nline"),
      arguments("this is a test", 4, "this\nis a\ntest"),
      arguments("a longword", 6, "a long\nword"),
      arguments("areallylongword", 6, "areall\nylongw\nord"),
      arguments("greedy whenthewordistoolong", 6, "greedy\nwhenth\newordi\nstoolo\nng"),
      arguments("greedy whenthewordistoolong", 7, "greedy\nwhenthe\nwordist\noolong")
    );
  }

  @Test
  void shoud_wrap_three_words() {
    assertWrap("x\nx\nx\nx\nx\nx", "xx xx xx", 1);
    assertWrap("xx\nxx\nxx", "xx xx xx", 2);
    assertWrap("xx\nxx\nxx", "xx xx xx", 3);
    assertWrap("xx\nxx\nxx", "xx xx xx", 4);
  }
}
