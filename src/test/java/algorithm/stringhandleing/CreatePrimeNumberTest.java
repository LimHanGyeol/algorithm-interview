package algorithm.stringhandleing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CreatePrimeNumberTest {

    @Test
    void testCreatePrimeNumberV1() {
        // given
        int[] nums = new int[]{1, 2, 3, 4};

        // when
        int result = new CreatePrimeNumber().solution(nums);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void testCreatePrimeNumberV2() {
        // given
        int[] nums = new int[]{1, 2, 7, 6, 4};

        // when
        int result = new CreatePrimeNumber().solution(nums);

        // then
        assertThat(result).isEqualTo(4);
    }
}
