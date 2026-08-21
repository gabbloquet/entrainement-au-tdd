package io.github.gabbloquet.tddtraining.WordWrap;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

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
  void should_fill_the_line_with_the_beginning_of_a_word_longer_than_a_line() {
    assertWrap("a long\nword", "a longword", 6);
  }

  @Test
  void should_not_break_before_a_long_word_when_the_line_is_already_full() {
    assertWrap("greedy\nwhenth\newordi\nstoolo\nng", "greedy whenthewordistoolong", 6);
    assertWrap("greedy\nwhenthe\nwordist\noolong", "greedy whenthewordistoolong", 7);
  }

  @Test
  void should_wrap_a_whole_sentence_on_word_boundaries() {
    assertWrap("a lot of\nwords for\na single\nline", "a lot of words for a single line", 10);
    assertWrap("this\nis a\ntest", "this is a test", 4);
  }

  @Test
  void shoud_wrap_three_words() {
    assertWrap("x\nx\nx\nx\nx\nx", "xx xx xx", 1);
    assertWrap("xx\nxx\nxx", "xx xx xx", 2);
    assertWrap("xx\nxx\nxx", "xx xx xx", 3);
    assertWrap("xx\nxx\nxx", "xx xx xx", 4);
  }
}
