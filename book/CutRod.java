// 자바로 쉽게 배우는 알고리즘
// 동적 계획법 (Dynamic Programming)
// 막대 자르기
class Solution {

    public static void main(String[] args) {
        int[] array = new int[] {2, 5, 9, 10};
        int size = array.length;

        System.out.println(cutRod(array, size)); // 11
    }

    // 해당 알고리즘의 입력 크기는 막대의 길이 n 이다.
    // 동적 계획법 막대 자르기 알고리즘의 시간 복잡도는 O(n^2) 이다.
    // 길이 n의 막대를 양의 정수 크기로 잘라 얻을 수 있는 최대 판매 가격을 동적 계획법을 이용하여 계산한다.
    // 입력 : n - 막대의 길이 n
    // price[0 .. n - 1] - 다른 길이의 막대들의 가격 배열
    // 출력 : 최대 판매 가격
    private int cutRod(int[] price, int n) {
        int[] maxSellPrice = new int[n + 1];
        maxSellPrice[0] = 0;

        // 배열 maxSellPrice[] 을 쉬운 문제부터 시작하여 점점 어려운 문제를 풀어 구한다.
        // maxSellPrice[n] 이 구하는 값이다.
        for (int j = 1; j <= n; j++) {
            int maxValue = 0;

            for (int k = 1; k <= j; k++) {
                maxValue = Math.max(maxValue, price[k - 1] + maxSellPrice[j - k]);
            }
            maxSellPrice[j] = maxValue;
        }
        return maxSellPrice[n];
    }

}
