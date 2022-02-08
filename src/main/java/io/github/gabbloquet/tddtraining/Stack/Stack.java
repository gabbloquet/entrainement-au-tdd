package io.github.gabbloquet.tddtraining.Stack;

public class Stack {

  private int element;
  private int size = 0;

  public boolean isEmpty() {
    return size == 0;
  }

  public void push(int i) {
    element = i;
    size++;
  }

  public int pop() throws UnderflowException {
    if(isEmpty())
      throw new UnderflowException();
    size--;
    return element;
  }

  public int size() {
    return size;
  }
}
