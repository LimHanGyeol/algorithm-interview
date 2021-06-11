package algorithm.stringhandleing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindPrimeNumberTest {

    @Test
    void testFindPrimeNumber() {
        // given
        String numbers = "17";

        // when
        int result = new FindPrimeNumber().solution(numbers);

        // then
        assertThat(result).isEqualTo(3);
    }
}
