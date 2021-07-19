package algorithm.tree.heap;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoreSpicyV2Test {

    @Test
    void testMoreSpicyV1() {
        // given
        int[] scoville = new int[]{1, 2, 3, 9, 10, 12};
        int k = 7;

        // when
        int result = new MoreSpicyV2().solution(scoville, k);

        // then
        assertThat(result).isEqualTo(2);
    }
}
