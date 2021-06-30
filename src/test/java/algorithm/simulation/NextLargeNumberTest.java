package algorithm.simulation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NextLargeNumberTest {

    @Test
    void testNextLargeNumberV1() {
        // given
        int n = 78;

        // when
        int result = new NextLargeNumber().solutionV1(n);

        // then
        assertThat(result).isEqualTo(83);
    }

    @Test
    void testNextLargeNumberV2() {
        // given
        int n = 15;

        // when
        int result = new NextLargeNumber().solutionV1(n);

        // then
        assertThat(result).isEqualTo(23);
    }
}
