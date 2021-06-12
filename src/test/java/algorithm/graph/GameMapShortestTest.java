package algorithm.graph;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameMapShortestTest {

    @Test
    void testGameMapShortestV1() {
        // given
        int[][] maps = new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        // when
        int result = new GameMapShortest().solution(maps);

        // then
        assertThat(result).isEqualTo(11);
    }

    @Test
    void testGameMapShortestV2() {
        // given
        int[][] maps = new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}
        };

        // when
        int result = new GameMapShortest().solution(maps);

        // then
        assertThat(result).isEqualTo(-1);
    }
}
