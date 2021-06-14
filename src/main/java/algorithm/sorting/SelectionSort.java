package algorithm.sorting;

/**
 * 선택 정렬
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = new int[]{7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        int n = array.length;

        for (int i = 0; i < n; i++) {
            int minIndex = i; // 가장 작은 원소의 인덱스
            for (int j = i + 1; j < n; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            // swap
            int value = array[i];
            array[i] = array[minIndex];
            array[minIndex] = value;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
