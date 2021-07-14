package algorithm.simulation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DevelopmentFeatureV2Test {

    @Test
    void testDevelopmentFeatureV1() {
        // given
        int[] progresses = new int[]{93, 30, 55};
        int[] speeds = new int[]{1, 30, 5};

        // when
        int[] solution = new DevelopmentFeatureV2().solution(progresses, speeds);

        // then
        assertThat(solution).containsExactly(2, 1);
    }

    @Test
    void testDevelopmentFeatureV2() {
        // given
        int[] progresses = new int[]{95, 90, 99, 99, 80, 99};
        int[] speeds = new int[]{1, 1, 1, 1, 1, 1};

        // when
        int[] solution = new DevelopmentFeatureV2().solution(progresses, speeds);

        // then
        assertThat(solution).containsExactly(1, 3, 2);
    }
}
