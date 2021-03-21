import java.util.*;

/**
 * 쉽게 풀어보는 코딩 테스트 기출문제
 * Stack
 * ValidParentheses
 */
class Solution {

    @Test
    void baseball() {
        System.out.println(isValid("{()}")); // true
        System.out.println(isValid("{()}(")); // false
        System.out.println(isValid("([)]")); // false
    }

    private boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();

        for (char character : array) {
            if (character == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
                continue;
            }
            if (character == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                }
                continue;
            }
            if (character == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                }
                continue;
            }
            stack.push(character);
        }
        return stack.isEmpty();
    }

}
