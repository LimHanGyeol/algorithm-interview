package algorithm.stringhandleing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MatrixBorderRotationTest {

    @Test
    void testMatrixBorderRotationV1() {
        // given
        int rows = 6;
        int columns = 6;
        int[][] queries = new int[][]{
                {2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}
        };

        // when
        int[] results = new MatrixBorderRotation().solution(rows, columns, queries);

        // then
        assertThat(results).containsExactly(8, 10, 25);
    }

    @Test
    void testMatrixBorderRotationV2() {
        // given
        int rows = 3;
        int columns = 3;
        int[][] queries = new int[][]{
                {1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}
        };

        // when
        int[] results = new MatrixBorderRotation().solution(rows, columns, queries);

        // then
        assertThat(results).containsExactly(1, 1, 5, 3);
    }

    @Test
    void testMatrixBorderRotationV3() {
        // given
        int rows = 100;
        int columns = 97;
        int[][] queries = new int[][]{
                {1, 1, 100, 97}
        };

        // when
        int[] results = new MatrixBorderRotation().solution(rows, columns, queries);

        // then
        assertThat(results).containsExactly(1);
    }
}
