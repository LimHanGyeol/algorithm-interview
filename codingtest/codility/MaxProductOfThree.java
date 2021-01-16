/**
 * Codility
 * Sorting
 * MaxProductOfThree
 */
class Solution {

    public static void main(String[] args) {
        int[] array = new int[]{-3, 1, 2, -2, 5, 6};
        int[] array2 = new int[]{-5, -5, 4, 5};
        int[] array3 = new int[]{10, 10, 10};
        System.out.println(maximumNumber(array3));
    }

    public int maximumNumber(int[] array) {
        int length = array.length;
        Arrays.sort(array); // quickSort(array, 0, length - 1);

        int first = array[length - 1] * array[length - 2] * array[length - 3];
        int second = array[0] * array[1] * array[length - 1];

        return first > second ? first : second;
    }

    private int[] quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int pivotPoint = partition(array, startIndex, endIndex);

            quickSort(array, startIndex, pivotPoint - 1);

            quickSort(array, pivotPoint + 1, endIndex);
        }
        return array;
    }

    private int partition(int[] array, int startIndex, int endIndex) {
        int nextIndex = startIndex + 1;
        int lastIndex = endIndex;
        int numberContainer;

        while(nextIndex <= lastIndex) {
            if (array[nextIndex] <= array[startIndex]) {
                nextIndex++;
            } else if (array[startIndex] < array[lastIndex]) {
                lastIndex--;
            } else {
                numberContainer = array[nextIndex];
                array[nextIndex] = array[lastIndex];
                array[lastIndex] = numberContainer;
                nextIndex++;
                lastIndex--;
            }
        }
        numberContainer = array[startIndex];
        array[startIndex] = array[lastIndex];
        array[lastIndex] = numberContainer;
        return lastIndex;
    }

}

