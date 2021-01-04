import java.util.*;

/**
 * 쉽게 풀어보는 코딩 테스트 기출문제
 * String & Array
 * Daily Temperatures
 */
class Solution {

    public static void main(String[] args) {
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        // 1, 1, 4, 2, 1, 1, 0, 0
        System.out.println(Arrays.toString(getDailyTemperatures(temperatures)));
    }

    private int[] getDailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] results = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                results[index] = i - index;
            }
            stack.push(i);
        }

        return results;
    }

}
