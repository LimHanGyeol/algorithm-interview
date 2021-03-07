import java.util.*;
/**
 * 프로그래머스
 * Level2
 * 올바른 괄호
 */
class Solution {

    @Test
    void correctBracketTest() {
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
    }

    private boolean solution(String s) {
        if (s.charAt(0) == ')') {
            return false;
        }

        Stack<Character> bracketStack = new Stack<>();
        char[] chars = s.toCharArray();

        for (char character : chars) {
            if (character == '(') {
                bracketStack.push(character);
                continue;
            }
            if (character == ')'){
                if (bracketStack.isEmpty()) {
                    return false;
                }
                bracketStack.pop();
            }
        }
        return bracketStack.isEmpty();
    }
}
