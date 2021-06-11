package algorithm.hash;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankingTest {

    @Test
    void testLottoV1() {
        // given
        int[] lottos = new int[]{44, 1, 0, 0, 31, 25};
        int[] winNums = new int[]{31, 10, 45, 1, 6, 19};

        // when
        int[] results = new LottoRanking().solution(lottos, winNums);

        // then
        assertThat(results).containsExactly(3, 5);
    }

    @Test
    void testLottoV2() {
        // given
        int[] lottos = new int[]{0, 0, 0, 0, 0, 0};
        int[] winNums = new int[]{38, 19, 20, 40, 15, 25};

        // when
        int[] results = new LottoRanking().solution(lottos, winNums);

        // then
        assertThat(results).containsExactly(1, 6);
    }

    @Test
    void testLottoV3() {
        // given
        int[] lottos = new int[]{45, 4, 35, 20, 3, 9};
        int[] winNums = new int[]{20, 9, 3, 45, 4, 35};

        // when
        int[] results = new LottoRanking().solution(lottos, winNums);

        // then
        assertThat(results).containsExactly(1, 1);
    }

    @Test
    void testLottoV4() {
        // given
        int[] lottos = new int[]{1, 2, 3, 4, 5, 6};
        int[] winNums = new int[]{10, 11, 12, 13, 14, 15};

        // when
        int[] results = new LottoRanking().solution(lottos, winNums);

        // then
        assertThat(results).containsExactly(6, 6);
    }
}
