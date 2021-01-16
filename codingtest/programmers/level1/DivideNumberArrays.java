import java.util.*;

/**
 * 프로그래머스
 * Level1
 * 나누어 떨어지는 숫자 배열
 */
class Solution {

    public static void main(String[] arg) {
        int[] results = new int[]{5, 9, 7, 10};
        int[] dividedNumbers = divideNumberArrays(results, 5);
        System.out.println(Arrays.toString(dividedNumbers));
    }

    private int[] divideNumberArrays(int[] array, int divisor) {
        List<Integer> dividedNumbers = divideNumberByDivisor(array, divisor);

        int numbersSize = dividedNumbers.size();

        if (numbersSize == 0) {
            return new int[] {-1};
        }

        return toArrays(dividedNumbers, numbersSize);
    }

    private List<Integer> divideNumberByDivisor(int[] array, int divisor) {
        List<Integer> dividedNumbers = new ArrayList<>();

        for (int number : array) {
            if (number % divisor == 0) {
                dividedNumbers.add(number);
            }
        }
        return dividedNumbers;
    }

    private int[] toArrays(List<Integer> dividedNumbers, int numbersSize) {
        Collections.sort(dividedNumbers);
        int[] results = new int[numbersSize];

        for (int i = 0; i < numbersSize; i++) {
            results[i] = dividedNumbers.get(i);
        }
        return results;
    }

}
