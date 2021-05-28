package algorithm.structure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Stack Test")
class CustomStackTest {

    @Test
    void push() {
        // given
        CustomStack<Integer> stack = new CustomStack<>();

        // when
        stack.push(5);

        // then
        assertThat(stack).isNotNull();
        assertThat(stack.size()).isEqualTo(1);
        assertThat(stack.peek()).isEqualTo(5);
    }

    @Test
    void pop() {
        // given
        CustomStack<Integer> stack = new CustomStack<>();
        stack.push(3);

        // when
        int result = stack.pop();

        // then
        assertThat(stack.isEmpty()).isTrue();
        assertThat(result).isEqualTo(3);
    }
}