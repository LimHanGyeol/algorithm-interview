package algorithm.simulation;

/**
 * leetcode. 121
 * Best Time to Buy and Sell Stock
 * Easy
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int startDay = prices[0]; // 매수일
        int result = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < startDay) {
                startDay = prices[i];
                continue;
            }
            int endDay = prices[i]; // 매도일
            int newResult = endDay - startDay;
            if (newResult > result) {
                result = newResult;
            }
        }
        return result;
    }
}
