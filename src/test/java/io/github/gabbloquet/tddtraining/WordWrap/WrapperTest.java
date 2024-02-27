package io.github.gabbloquet.tddtraining.WordWrap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WrapperTest {

  private final Wrapper wrapper = new Wrapper();

  private void assertWrap(String expected, String StringToWrap, int column) {
    Assertions.assertEquals(expected, wrapper.wrap(StringToWrap, column));
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
  void shoud_wrap_three_words() {
    assertWrap("x\nx\nx\nx\nx\nx", "xx xx xx", 1);
    assertWrap("xx\nxx\nxx", "xx xx xx", 2);
    assertWrap("xx\nxx\nxx", "xx xx xx", 3);
    assertWrap("xx\nxx\nxx", "xx xx xx", 4);
  }
}
