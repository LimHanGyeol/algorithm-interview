import java.util.*;

/**
 * 쉽게 풀어보는 코딩 테스트 기출문제
 * Stack
 * BaseballGame
 */
class Solution {

    @Test
    void baseball() {
        String[] strings = new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}; // 28
        System.out.println(play(strings));
    }

    private static int play(String[] strings) {
        Stack<Integer> stack = new Stack<>();

        for (String operation : strings) {
            if (operation.equals("C")) {
                stack.pop();
                continue;
            }
            if (operation.equals("D")) {
                stack.push(stack.peek() * 2);
                continue;
            }
            if (operation.equals("+")) {
                int x = stack.pop();
                int y = stack.pop();
                stack.push(y);
                stack.push(x);
                stack.push(x + y);
                continue;
            }
            stack.push(Integer.parseInt(operation));
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

}
