import java.util.*;

/**
 * 프로그래머스
 * Level1
 * 문자열 내 마음대로 정렬하기
 */
class Solution {

    public static void main(String[] args) {
        String[] array = new String[]{"abce", "abcd", "cdx"};
        int n = 1;
        // abcd, abce, cdx
        System.out.println(Arrays.toString(sortStrings(array, n)));
    }

    private String[] sortStrings(String[] array, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            if (s1.charAt(n) > s2.charAt(n)) {
                return 1;
            }
            if (s1.charAt(n) == s2.charAt(n)) {
                return s1.compareTo(s2);
            }
            return -1;
        });
        return strings;
    }

}
