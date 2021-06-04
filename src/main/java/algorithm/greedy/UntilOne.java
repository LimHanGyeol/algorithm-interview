package algorithm.greedy;

/**
 * 이것이 취업을 위한 코딩 테스트다 with Python
 * Java
 * <p>
 * 1이 될 때까지
 * 시간제한 2초, 메모리 제한 128MB
 * Input
 * - 첫째 줄에 N (1 <= n <= 100_000)과 k (2 <= k <= 100_000)가 공백을 기준으로 각각 자연수로 주어진다.
 * Output
 * - 첫째 중레 n이 1이 될 때까지 1번 혹은 2번의 과정을 수행해야 하는 횟수의 최소값을 출력한다.
 * <p>
 * Condition
 * 1. n에서 1을 뺀다.
 * 2. n을 k로 나눈다.
 * <p>
 * Ex
 * Input : 25 5
 * Output : 2
 */
public class UntilOne {

    /**
     * 일반적으로 k로 나누어 떨어지면 나누고, 아니면 1을 빼는 방법으로도 구현할 수 있지만,
     * 아래와 같이 접근하면 O(logN) 시간 복잡도로 풀 수 있다.
     * @param args
     */
    public static void main(String[] args) {
        int n = 25;
        int k = 3;
        int count = 0;

        while (true) {
            // n이 k로 나누어 떨어지는 수가 될 때까지 빼기
            int target = (n / k) * k;
            count += (n - target);
            n = target;
            // n이 k보다 작을 때(더 이상 나눌 수 없을때) 반복문 탈출
            if (n < k) {
                break;
            }
            // k로 나누기
            n /= k;
            count += 1;
        }
        // 마지막으로 남은 수에 대하여 1씩 빼기
        count += (n - 1);
        System.out.println(count);
    }
}
