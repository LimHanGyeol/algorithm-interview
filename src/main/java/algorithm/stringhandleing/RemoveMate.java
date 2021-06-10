package algorithm.stringhandleing;

import java.util.Stack;

/**
 * Programmers
 * Level2
 * 짝지어 제거하기
 */
public class RemoveMate {

    public int calculate(String s) {
        String[] element = s.split("");
        int length = element.length;
        if (element.length <= 1) {
            return 0;
        }

        Stack<String> stack = new Stack<>();
        stack.push(element[0]);
        int index = 1;

        while (index != length) {
            if (stack.isEmpty() || !stack.peek().equals(element[index])) {
                stack.push(element[index]);
            } else {
                stack.pop();
            }
            index++;
        }

        if (stack.isEmpty()) {
            return 1;
        }
        return 0;
    }
}
