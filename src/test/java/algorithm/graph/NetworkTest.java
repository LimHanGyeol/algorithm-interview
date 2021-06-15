package algorithm.graph;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NetworkTest {

    @Test
    void testNetworkV1() {
        // given
        int n = 3;
        int[][] computers = new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        // when
        int result = new Network().solution(n, computers);

        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    void testNetworkV2() {
        // given
        int n = 3;
        int[][] computers = new int[][]{
                {1, 1, 0}, {1, 1, 1}, {0, 1, 1}
        };

        // when
        int result = new Network().solution(n, computers);

        // then
        assertThat(result).isEqualTo(1);
    }
}
