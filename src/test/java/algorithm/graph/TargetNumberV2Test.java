package algorithm.graph;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TargetNumberV2Test {

    @Test
    void testTargetNumberV1() {
        // given
        int[] numbers = new int[]{1, 1, 1, 1, 1};
        int target = 3;

        // when
        int result = new TargetNumberV2().solution(numbers, target);

        // then
        assertThat(result).isEqualTo(5);
    }
}
