package algorithm.sorting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HIndexTest {

    @Test
    void testHIndex() {
        // given
        int[] citations = new int[]{3, 0, 6, 1, 5};

        // when
        int result = new HIndex().solution(citations);

        // then
        assertThat(result).isEqualTo(3);
    }
}
