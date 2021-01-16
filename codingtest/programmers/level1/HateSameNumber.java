/**
 * 프로그래머스
 * Level1
 * 같은 숫자는 싫어
 */
class Solution {

    public static void main(String[] args) {
        int[] results = hateSameNumber(new int[]{1, 1, 3, 3, 0, 1, 1});
        System.out.println(Arrays.toString(results));
    }

    private int[] hateSameNumber(int[] array) {
        List<Integer> results = getHateSameNumbers(array);
        return toArrays(results);
    }

    private List<Integer> getHateSameNumbers(int[] array) {
        List<Integer> results = new ArrayList<>();
        results.add(array[0]);

        int arrayLength = array.length;
        for (int i = 1; i < arrayLength; i++) {
            if (array[i] != array[i - 1]) {
                results.add(array[i]);
            }
        }
        return results;
    }

    private int[] toArrays(List<Integer> results) {
        int resultsSize = results.size();
        int[] numbers = new int[resultsSize];

        for (int i = 0; i < resultsSize; i++) {
            numbers[i] = results.get(i);
        }
        return numbers;
    }


    /**
     * 다른 사람의 풀이
     */
    private List<Integer> getHateSameNumbers(int[] array) {
        List<Integer> results = new ArrayList<>();
        int current = 10;

        int arrayLength = array.length;
        for (int i = 0; i < arrayLength; i++) {
            if (array[i] != current) {
                results.add(array[i]);
                current = array[i];
            }
        }
        return results;
    }
}
