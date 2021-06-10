package algorithm.bruteforce;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PassingLandTest {

    @Test
    void testPassingLand() {
        // given
        int[][] land = new int[][]{
                {1, 2, 3, 5},
                {5, 6, 7, 100},
                {4, 3, 2, 1}
        };

        // when
        int score = new PassingLand().play(land);

        // then
        assertThat(score).isEqualTo(107);
    }

    @Test
    void testPassingLandV2() {
        // given
        int[][] land = new int[][]{
                {4, 3, 2, 1},
                {2, 2, 2, 1},
                {6, 6, 6, 4},
                {8, 7, 6, 5}
        };

        // when
        int score = new PassingLand().play(land);

        // then
        assertThat(score).isEqualTo(20);
    }
}
