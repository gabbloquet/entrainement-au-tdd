package io.github.gabbloquet.tddtraining.Stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

  private final Stack stack = new Stack();

  @Test
  void should_create_an_empty_stack() {
    assertTrue(stack.isEmpty());
  }

  @Test
  void should_not_be_empty_after_a_push() {
    stack.push(0);
    assertFalse(stack.isEmpty());
    assertEquals(1, stack.size());
  }

  @Test
  void should_be_empty_after_a_push_and_a_pop() throws UnderflowException {
    stack.push(0);
    stack.pop();
    assertTrue(stack.isEmpty());
    assertEquals(0, stack.size());
  }

  @Test
  void should_have_a_size_of_two_after_two_push() {
    stack.push(0);
    stack.push(1);
    assertEquals(2, stack.size());
  }

  @Test
  void should_throw_empty_stack_error_when_pop_an_empty_stack() {
    Exception exception = assertThrows(UnderflowException.class, stack::pop);

    String expectedMessage = "Il est impossible de retirer un élément d'une pile vide.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void should_pop_X_after_push_X() throws UnderflowException {
    stack.push(10);
    assertEquals(10, stack.pop());

    stack.push(20);
    assertEquals(20, stack.pop());
  }

  @Test
  void should_pop_Y_then_X_after_push_X_then_Y() throws UnderflowException {
    stack.push(10);
    stack.push(20);
    assertEquals(20, stack.pop());
    assertEquals(10, stack.pop());
  }
}
