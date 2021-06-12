package algorithm.stringhandleing;

/**
 * Programmers
 * Level1
 * 소수 만들기
 */
public class CreatePrimeNumber {

    private static boolean[] visited;
    private static int count = 0;

    // nPr
    public int solution(int[] nums) {
        int n = nums.length;
        int r = 3;
        visited = new boolean[n];

        permutation(nums, 0, n, r); // start : 순열 탐색 시작 위치
        return count;
    }

    private void permutation(int[] nums, int start, int n, int r) {
        if (r == 0) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    sum += nums[i];
                }
            }
            if (isPrimeNumber(sum)) {
                count++;
            }
            return;
        }
        for (int i = start; i < n; i++) {
            visited[i] = true;
            permutation(nums, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    private boolean isPrimeNumber(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
