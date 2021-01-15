/**
 * 프로그래머스
 * Level1
 * 문자열 내 p와 y의 개수
 */
class Solution {

    public static void main(String[] args) {
        getPYCount("pPooyY"); // true
    }

    private boolean getPYCount(String text) {
        int count = 0;
        char[] characters = text.toCharArray();

        for (char character : characters) {
            count += calculatePAndY(character);
        }

        return count == 0;
    }

    private int calculatePAndY(char character) {
        if (character == 112 || character == 80) {
            return 1;
        }
        if (character == 121 || character == 89) {
            return -1;
        }
        return 0;
    }

}
