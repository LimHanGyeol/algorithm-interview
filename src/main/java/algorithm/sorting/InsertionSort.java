package algorithm.sorting;

import java.util.Arrays;

/**
 * 삽입 정렬
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] array = new int[]{7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        int n = array.length;

        for (int i = 1; i < n; i++) {
            // 인덱스 i부터 1까지 감소하며 반복하는 문법
            for (int j = i; j > 0; j--) {
                // 한 칸씩 왼쪽으로 이동
                if (array[j] < array[j - 1]) {
                    // swap
                    int swap = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = swap;
                    continue;
                }
                break;
            }
        }

        Arrays.stream(array)
                .mapToObj(j -> j + " ")
                .forEach(System.out::print);
    }
}
