package algorithm.structure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Queue Test")
class CustomQueueTest {

    @Test
    void enqueue() {
        // given
        CustomQueue<Integer> queue = new CustomQueue<>();

        // when
        queue.enqueue(1);

        // then
        assertThat(queue).isNotNull();
        assertThat(queue.size()).isEqualTo(1);
    }

    @Test
    void dequeue() {
        // given
        CustomQueue<Integer> queue = new CustomQueue<>();
        queue.enqueue(5);

        // when
        int result = queue.dequeue();

        // then
        assertThat(result).isEqualTo(5);
        assertThat(queue.isEmpty()).isTrue();
    }
}