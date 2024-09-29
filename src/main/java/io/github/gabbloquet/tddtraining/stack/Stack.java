package io.github.gabbloquet.tddtraining.stack;

import java.util.ArrayList;
import java.util.List;

public class Stack {

    List<Integer> values = new ArrayList<>();

    public boolean isEmpty() {
        return values.isEmpty();
    }

    public void push(int valueToAdd) {
        values.add(valueToAdd);
    }

    public int pop() {
        if (values.isEmpty()) {
            throw new PopOnEmptyStackException();
        }
        return values.removeLast();
    }
}
