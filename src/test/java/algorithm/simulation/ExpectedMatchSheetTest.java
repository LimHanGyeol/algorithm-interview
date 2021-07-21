package algorithm.simulation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ExpectedMatchSheetTest {

    @Test
    void testExpectedMatchSheet() {
        // given
        int n = 8;
        int a = 4;
        int b = 7;

        // when
        int result = new ExpectedMatchSheet().solution(n, a, b);

        // then
        assertThat(result).isEqualTo(3);
    }
}
