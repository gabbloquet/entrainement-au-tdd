package io.github.gabbloquet.tddtraining.Diamond;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DiamondRendererTest {

  private final DiamondRenderer diamondRenderer = new DiamondRenderer();

  @Test
  void should_render_only_A() throws UnexpectedLetter {
    assertThat(diamondRenderer.render('A')).isEqualTo("A");
  }

  @Test
  void should_render_a_diamond_with_a_height_of_3_given_B() throws UnexpectedLetter {
    assertThat(diamondRenderer.render('B')).isEqualTo("""
       A
      B B
       A""");
  }

  @Test
  void should_render_a_diamond_with_a_height_of_5_given_C() throws UnexpectedLetter {
    assertThat(diamondRenderer.render('C')).isEqualTo("""
        A
       B B
      C   C
       B B
        A""");
  }
  @Test
  void should_render_a_diamond_with_a_height_of_11_given_F() throws UnexpectedLetter {
    assertThat(diamondRenderer.render('F')).isEqualTo("""
           A
          B B
         C   C
        D     D
       E       E
      F         F
       E       E
        D     D
         C   C
          B B
           A""");
  }

  @Test
  void should_throw_unexpected_letter_error_if_strange_character_is_provided() {
    assertThatThrownBy(() -> diamondRenderer.render('%'))
      .isInstanceOf(UnexpectedLetter.class)
      .hasMessage("La lettre fournie n'est pas valide.");
  }
}
