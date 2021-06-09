package algorithm.graph;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TargetNumberTest {

    @Test
    void testTargetNumber() {
        // given
        int[] numbers = new int[]{1, 1, 1, 1, 1};
        int targetNumber = 3;

        // when
        int result = new TargetNumber().dfs(numbers, targetNumber, 0, 0);

        // then
        assertThat(result).isEqualTo(5);
    }
}
