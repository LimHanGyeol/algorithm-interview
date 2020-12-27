// 자바로 쉽게 배우는 알고리즘
// 탐욕 기법 (Greedy Algorithms)
// 거스름돈
class Solution {

    public static void main(String[] args) {
        int[] coinValues = new int[] {500, 100, 50, 10, 5, 1};
        int change = 674;
        System.out.println(getChange(coinValues, change));
    }

    private int getChange(int[] coinValues, int change) {
        int[] countChange = new int[coinValues.length];
        int count = 0;
        int i = 0;

        // 거스름돈이 남아있는 동안 거스름돈에 포함되는 각 동전의 개수를 계산한다.
        while (change > 0) {
            // 거스름돈에 포함되는 남아있는 동전들 중 가장 가치가 큰 동전들의 수를 계산한다.
            countChange[i] = change / coinValues[i];

            count = count + countChange[i];

            // 남은 거스름돈을 계산한다.
            change = change % coinValues[i];

            // 남아있는 동전들 중 다음으로 가치가 가장 큰 동전을 선택한다.
            i++;
        }

        return count;
    }
    
}
