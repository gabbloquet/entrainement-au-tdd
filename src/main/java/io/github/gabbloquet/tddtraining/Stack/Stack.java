package io.github.gabbloquet.tddtraining.Stack;

public class Stack {

  private final int[] elements = new int[2];
  private int size = 0;

  public boolean isEmpty() {
    return size == 0;
  }

  public void push(int element) {
    elements[size++] = element;
  }

  public int pop() throws UnderflowException {
    if(isEmpty())
      throw new UnderflowException();
    return elements[--size];
  }

  public int size() {
    return size;
  }
}
