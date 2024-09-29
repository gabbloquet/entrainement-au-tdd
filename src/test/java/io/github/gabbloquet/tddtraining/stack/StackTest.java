package io.github.gabbloquet.tddtraining.stack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StackTest {

    private final Stack stack = new Stack();

    @Test
    void should_create_an_empty_list() {
        assertThat(stack.isEmpty()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 34, 37284849})
    void should_not_be_empty_when_push_a_value(int valueToAdd) {
        stack.push(valueToAdd);

        assertThat(stack.isEmpty()).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 34, 37284849})
    void should_return_pushed_value_when_pop(int valueToAdd) {
        stack.push(valueToAdd);

        assertThat(stack.pop()).isEqualTo(valueToAdd);
    }

    @Test
    void should_pop_the_last_value_added_first() {
        stack.push(938);
        stack.push(347);

        assertThat(stack.pop()).isEqualTo(347);
        assertThat(stack.pop()).isEqualTo(938);
    }

    @Test
    void should_throw_an_exception_when_pop_a_value_of_an_empty_stack() {
        assertThatThrownBy(stack::pop)
            .isInstanceOf(PopOnEmptyStackException.class)
            .hasMessage("Impossible to pop a value of an empty stack.");
    }
}
