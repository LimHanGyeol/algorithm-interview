package algorithm.simulation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LeastCommonMultipleTest {

    @Test
    void testLCM_V1() {
        // given
        int[] arr = new int[]{2, 6, 8, 14};

        // when
        int result = new LeastCommonMultiple().solution(arr);

        // then
        assertThat(result).isEqualTo(168);
    }

    @Test
    void testLCM_V2() {
        // given
        int[] arr = new int[]{1, 2, 3};

        // when
        int result = new LeastCommonMultiple().solution(arr);

        // then
        assertThat(result).isEqualTo(6);
    }
}
