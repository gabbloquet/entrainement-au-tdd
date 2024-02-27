package io.github.gabbloquet.tddtraining.Diamond;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiamondRendererTest {

  private final DiamondRenderer diamondRenderer = new DiamondRenderer();

  @Test
  void should_render_only_A() throws UnexpectedLetter {
    assertEquals("A", diamondRenderer.render('A'));
  }

  @Test
  void should_render_a_diamond_with_a_height_of_3_given_B() throws UnexpectedLetter {
    assertEquals("""
       A
      B B
       A""", diamondRenderer.render('B'));
  }

  @Test
  void should_render_a_diamond_with_a_height_of_5_given_C() throws UnexpectedLetter {
    assertEquals("""
        A
       B B
      C   C
       B B
        A""", diamondRenderer.render('C'));
  }
  @Test
  void should_render_a_diamond_with_a_height_of_11_given_F() throws UnexpectedLetter {
    assertEquals("""
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
           A""", diamondRenderer.render('F'));
  }

  @Test
  void should_throw_unexpected_letter_error_if_strange_character_is_provided() {
    Exception exception = assertThrows(UnexpectedLetter.class, () -> diamondRenderer.render('%'));

    String expectedMessage = "La lettre fournie n'est pas valide.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }
}
