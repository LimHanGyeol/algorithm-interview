import java.util.*;

class Solution {

    public boolean isPalindrome(String input) {
        int startIndex = 0;
        int endIndex = input.length() - 1;

        while (startIndex < endIndex) {
            while (startIndex < input.length()
                    && !isAlphanumeric(input.charAt(startIndex))) {
                startIndex++;
            }

            while (endIndex >= 0
                    && !isAlphanumeric(input.charAt(endIndex))) {
                endIndex--;
            }

            if (startIndex == input.length()
                    || endIndex == -1) {
                return true;
            }

            char startCharacter = toUpperCase(input.charAt(startIndex));
            char endCharacter = toUpperCase(input.charAt(endIndex));

            if (startCharacter != endCharacter) {
                return false;
            }

            startIndex++;
            endIndex--;
        }
        return true;
    }

    private char toUpperCase(char input) {
        return Character.toUpperCase(input);
    }

    private Boolean isAlphanumeric(char input) {
        return (input >= 'a' && input <= 'z')
                || (input >= 'A' && input <= 'Z')
                || (input >= '0' && input <= '9');
    }
}