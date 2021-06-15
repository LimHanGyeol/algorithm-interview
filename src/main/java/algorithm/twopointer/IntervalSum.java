package algorithm.twopointer;

/**
 * 이것이 취업을 위한 코딩 테스트다 with Python
 * Java
 * <p>
 * 구간 합 (Interval Sum)
 * 연속적으로 나열된 N개의 수가 있을 때 특정 구간의 모든 수를 합한 값을 계산하는 문제
 * Input
 * - 5개의 데이터로 구성된 수열 10, 20, 30, 40, 50이 있을 경우
 * 두 번째 수부터 네 번째 수까지의 합은 20 + 30 + 40 = 90이다.
 * <p>
 * 접두사 합(Prefix Sum) : 배열의 맨 앞부터 특정 위치까지의 합을 미리 구해 놓은 것
 * 접두사 합을 활용한 알고리즘은 다음과 같다.
 * - N개의 수 위치 각각에 대하여 접두사 합을 계산하여 P 배열에 저장한다.
 * - 매 M개의 쿼리 정보를 확인할 때 구간 합은 P[right] - P[left - 1] 이다.
 */
public class IntervalSum {

    private static int[] array = new int[]{10, 20, 30, 40, 50};
    private static int[] prefixSum = new int[array.length + 1];

    public static void main(String[] args) {
        // 접두사 합 (Prefix Sum) 배열 계산
        int sum = 0;
        int n = array.length;

        for (int i = 0; i < n; i++) {
            sum += array[i];
            prefixSum[i + 1] = sum;
        }

        // 구간 합 계산 (세 번째 수부터 네 번째 수까지)
        // prefixSum[right] - prefixSum[left - 1]
        int left = 3;
        int right = 4;
        System.out.println(prefixSum[right] - prefixSum[left - 1]);
    }
}
