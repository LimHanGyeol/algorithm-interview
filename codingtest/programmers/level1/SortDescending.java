import java.util.*;

/**
 * 프로그래머스
 * Level1
 * 정수 내림차순으로 배치하기
 */
class Solution {

    public static void main(String[] args) {
        // 873211
        System.out.println(sortDescending(118372));
    }

    private long sortDescending(long number) {
        String[] numbers = String.valueOf(number).split("");
        Arrays.sort(numbers, Comparator.reverseOrder());

        StringBuffer result = new StringBuffer();
        for (String numberElement : numbers) {
            result.append(numberElement);
        }

        return Long.parseLong(result.toString());
    }

}
