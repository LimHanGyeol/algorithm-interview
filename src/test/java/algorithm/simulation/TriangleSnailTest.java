package algorithm.simulation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TriangleSnailTest {

    @Test
    void input1() {
        // given
        int n = 4;

        // when
        int[] result = new TriangleSnail().solution(n);

        // then
        assertThat(result).containsExactly(1, 2, 9, 3, 10, 8, 4, 5, 6, 7);
    }

    @Test
    void input2() {
        // given
        int n = 5;

        // when
        int[] result = new TriangleSnail().solution(n);

        // then
        assertThat(result).containsExactly(1, 2, 12, 3, 13, 11, 4, 14, 15, 10, 5, 6, 7, 8, 9);
    }

    @Test
    void input3() {
        // given
        int n = 6;

        // when
        int[] result = new TriangleSnail().solution(n);

        // then
        assertThat(result).containsExactly(1, 2, 15, 3, 16, 14, 4, 17, 21, 13, 5, 18, 19, 20, 12, 6, 7, 8, 9, 10, 11);
    }
}
