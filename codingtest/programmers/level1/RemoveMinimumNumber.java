/**
 * 프로그래머스
 * Level1
 * 제일 작은 수 제거하기
 */
class Solution {

    public static void main(String[] args) {
        int[] array = new int[]{4, 1, 2, 6, 61, 32};
        System.out.println(Arrays.toString(removeMinimumNumber(array)));
    }

    public int[] removeMinimumNumber(int[] array) {
        int length = array.length;

        if (length == 0 || array[0] == 10) {
            return new int[]{-1};
        }

        int minIndex = getMinIndex(array, length);

        moveArrayIndex(array, length, minIndex);

        return getResults(array, length);
    }

    private int getMinIndex(int[] array, int length) {
        int minIndex = 0;

        for (int i = 1; i < length; i++) {
            if (array[minIndex] > array[i]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    private void moveArrayIndex(int[] array, int length, int minIndex) {
        for (int i = minIndex + 1; i < length; i++) {
            array[i - 1] = array[i];
        }
    }

    private int[] getResults(int[] array, int length) {
        int[] results = new int[length - 1];

        for (int i = 0; i < results.length; i++) {
            results[i] = array[i];
        }

        return results;
    }

}
