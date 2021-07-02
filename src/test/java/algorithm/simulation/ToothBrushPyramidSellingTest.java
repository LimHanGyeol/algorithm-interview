package algorithm.simulation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ToothBrushPyramidSellingTest {

    @Test
    void testToothBrushPyramidSellingTestV1() {
        // given
        String[] enroll = new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = new String[]{"young", "john", "tod", "emily", "mary"};
        int[] amount = new int[]{12, 4, 2, 5, 10};

        // when
        int[] result = new ToothBrushPyramidSelling().solution(enroll, referral, seller, amount);

        // then
        assertThat(result).containsExactly(360, 958, 108, 0, 450, 18, 180, 1080);
    }

    @Test
    void testToothBrushPyramidSellingTestV2() {
        // given
        String[] enroll = new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = new String[]{"sam", "emily", "jaimie", "edward"};
        int[] amount = new int[]{2, 3, 5, 4};

        // when
        int[] result = new ToothBrushPyramidSelling().solution(enroll, referral, seller, amount);

        // then
        assertThat(result).containsExactly(0, 110, 378, 180, 270, 450, 0, 0);
    }
}
