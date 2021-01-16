import java.util.*;

/**
 * Codility
 * Arrays
 * OddOccurrencesInArray
 */
class Solution {

    public static void main(String[] args) {
        int[] array = new int[]{9, 3, 9, 3, 9, 7, 9};
        System.out.println(invalidPairNumber(array));
    }

    private int invalidPairNumber(int[] array) {
        Map<Integer, Integer> numberMap = checkPairNumber(array);
        return getInvalidNumber(numberMap);
    }

    private Map<Integer, Integer> checkPairNumber(int[] array) {
        Map<Integer, Integer> numberMap = new HashMap<>();

        for (int number : array) {
            int pairNumber = numberMap.getOrDefault(number, 0);
            numberMap.put(number, pairNumber + 1);
        }
        return numberMap;
    }

    private int getInvalidNumber(Map<Integer, Integer> numberMap) {
        for (int index : numberMap.keySet()) {
            int pairNumber = numberMap.get(index);
            if (pairNumber % 2 != 0) {
                return index;
            }
        }
        return 0;
    }

    /**
     * 다른 풀이
     */
    private int getInvalidNumber(int[] array) {
        int result = 0;

        for (int number : array) {
            result ^= number;
        }
        return result;
    }

}
