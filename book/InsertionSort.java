// 자바로 쉽게 배우는 알고리즘
// 삽입 정렬
class Solution {

    public static void main(String[] args) {
        int[] array = new int[] {45, 89, 67, 92, 53, 74, 26, 80};
        System.out.println(Arrays.toString(insertionSort(array)));
    }

    /**
     * 삽입 정렬 알고리즘의 입력의 크기는 배열의 크기인 array.length 이다.
     * 기본 연산은 (array[j] > insertContainer) 이다.
     * 기본 연산이 수행되는 횟수는 배열 내의 값들에 의존한다.
     * 최악의 경우는 배열 내의 값들이 서로 다르고 내림차순으로 정렬되어 있는 경우이다.
     * 삽입 정렬의 시간 복잡도는 최악의 경우 O(n^2) 이다.
     * 삽입 정렬은 배열 내의 값들이 거의 정렬되어 있을 때,
     * 반복할 때마다 기본 연산이 수행되는 횟수가 적으므로 빠르게 실행된다.
     * 이 경우는 실제로 다양한 응용에서 발생한다.
     * 따라서 삽입 정렬은 입력의 크기가 크지 않고 배열 내의 값들이 거의 정렬되어 있을 때 적절하다.
     */
    private int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int insertContainer = array[i];
            int j = i - 1;

            while (j >= 0 && (array[j] > insertContainer)) {
                array[j + 1] = array[j];
                j = j - 1;

                array[j + 1] = insertContainer;
            }
        }
        return array;
    }

}
