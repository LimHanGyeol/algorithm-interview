import java.util.Arrays;
import java.util.Comparator;

/**
 * 쉽게 풀어보는 코딩 테스트 기출문제
 * String & Array
 * TwoSum
 */
class Solution {

    public static void main(String[] args) {
        int[] numbers = new int[]{10, 3, 21, 5};
        int target = 8;
        System.out.println(Arrays.toString(solve(numbers, target))); // 1, 3
    }

    /**
     * LeetCode 에서도 같은 문제 풀이가 있다.
     * 브루트 포스 풀이방법으로는 59ms 의 시간이 소요되며,
     * Map 을 초기화 하는 반복문을 넣을 경우 5ms가 소요된다.
     * 해당 방법은 최악 O(n) 최선 O(1) 의 시간복잡도를 가지고 있는 최적의 풀이이다.
     * @param numbers 탐색해야하는 숫자 배열
     * @param target 두 값의 합
     * @return 합을 이루는 수의 Index
     */
    private int[] solve(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i <numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(numbers[i], i);
        }
        throw new IllegalArgumentException();
    }

}
