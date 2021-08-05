package algorithm.simulation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBuyAndSellStockTest {

    @Test
    void testBestTimeToBuyAndSellStockV1() {
        // given
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};

        // when
        int result = new BestTimeToBuyAndSellStock().maxProfit(prices);

        // then
        assertThat(result).isEqualTo(5);
    }

    @Test
    void testBestTimeToBuyAndSellStockV2() {
        // given
        int[] prices = new int[]{7, 6, 4, 3, 1};

        // when
        int result = new BestTimeToBuyAndSellStock().maxProfit(prices);

        // then
        assertThat(result).isEqualTo(0);
    }
}
