package algorithm.stringhandleing;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;

import static algorithm.util.InputReader.init;

/**
 * BaekJoon. 9935
 * 문자열 폭발
 * String Handling
 */
public class StringExplosion {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();

        String input = bufferedReader.readLine();
        String target = bufferedReader.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));

            if (stack.size() >= target.length()) {
                boolean explosion = true;

                for (int j = 0; j < target.length(); j++) {
                    if (stack.get(stack.size() - target.length() + j) != target.charAt(j)) {
                        explosion = false;
                        break;
                    }
                }
                if (explosion) {
                    for (int j = 0; j < target.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        String result = getResult(stack);
        System.out.println(result);
    }

    private static String getResult(Stack<Character> stack) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char element : stack) {
            stringBuilder.append(element);
        }

        if (stringBuilder.length() > 0) {
            return stringBuilder.toString();
        }
        return "FRULA";
    }
}
