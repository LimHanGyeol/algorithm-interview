// 자바로 쉽게 배우는 알고리즘
// 빠른 정렬 (Quick Sort)
// 재귀를 이용한 퀵 정렬이다.
class Solution {

    public static void main(String[] args) {
        int[] array = new int[] {15, 22, 13, 27, 12, 10, 20, 25, 32};
        // 10, 12, 13, 15, 20, 22, 25, 27, 32
        System.out.println(Arrays.toString(quickSort(array, 0, array.length - 1)));
    }

    /*
     * QuickSort 의 입력의 크기는 배열의 크기 n 이다.
     * quickSort 의 시간 복잡도는 O(n log n) 이다.
     */
    private int[] quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            // 배열 array[startIndex .. endIndex] 를 분할할 중간 값을 계산한다.
            int pivotPoint = partition(array, startIndex, endIndex);

            // array[startIndex .. pivotPoint - 1] 를 quickSort 를 이용하여 정렬한다.
            quickSort(array, startIndex, pivotPoint - 1);

            // array[pivotPoint + 1 .. endIndex] 를 quickSort 를 이용하여 정렬한다.
            quickSort(array, pivotPoint + 1, endIndex);
        }
        return array;
    }

    // 배열을 array[startIndex] 를 기준으로 하여
    // array[startIndex] 보다 큰 요소는 배열의 오른쪽으로,
    // 작은 요소는 배열의 왼쪽으로 옮긴다.
    private int partition(int[] array, int startIndex, int endIndex) {
        int nextIndex = startIndex + 1;
        int lastIndex = endIndex;
        int numberContainer;

        // 배열을 array[startIndex] 를 기준으로 하여
        // array[startIndex] 보다 큰 요소는 배열의 오른쪽으로, 작은 요소는 왼쪽으로 옮긴다.
        while (nextIndex <= lastIndex) {
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

        // array[startIndex]를 array[startIndex] 보다
        // 작거나 같은 요소들의 구역의 마지막 요소와 교환한다.
        numberContainer = array[startIndex];
        array[startIndex] = array[lastIndex];
        array[lastIndex] = numberContainer;

        return lastIndex;
    }

}
