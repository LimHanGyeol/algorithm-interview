package algorithm.tree.heap;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoreSpicyTest {

    @Test
    void more_spicy() {
        int[] scoville = new int[]{1, 2, 3, 9, 10, 12};
        int k = 7;
        assertThat(new MoreSpicy().calculate(scoville, k)).isEqualTo(2);
    }
}
