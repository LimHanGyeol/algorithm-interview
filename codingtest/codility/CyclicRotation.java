/**
 * Codility
 * Arrays
 * CyclicRotation
 */
class Solution {

    public static void main(String[] args) {
        int[] array = new int[]{3, 8, 9, 7, 6};
        int k = 4;
        // 8, 9, 7, 6, 3
        System.out.println(Arrays.toString(getRotatedArray(array, k)));
    }

    public int[] getRotatedArray(int[] array, int rotationNumber) {
        if (array.length == 0) {
            return array;
        }
        return rotateArray(array, rotationNumber);
    }

    private int[] rotateArray(int[] array, int rotationNumber) {
        int prevNumber = array[0];
        int lastIndex = array.length - 1;

        for (int i = 0; i < rotationNumber; i++) {
            array[0] = array[lastIndex];
            prevNumber = rotateNumber(array, prevNumber);
        }

        return array;
    }

    private int rotateNumber(int[] array, int prevNumber) {
        int length = array.length;

        for (int i = 1; i < length; i++) {
            int currentNumber = array[j];
            array[j] = prevNumber;
            prevNumber = currentNumber;
        }

        return prevNumber;
    }

    /**
     * 다른 풀이
     */
    private int[] getRotatedArray(int[] array, int rotationNumber) {
        int length = array.length;
        int[] results = new int[length];

        if (length == 0) {
            return array;
        }

        for (int i = 0; i < length; i++) {
            int index = (i + rotationNumber) % length;

            results[index] = array[i];
        }

        return results;
    }


}
