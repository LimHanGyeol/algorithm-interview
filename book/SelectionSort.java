// 자바로 쉽게 배우는 알고리즘
// 선택 정렬
class Solution {

    public static void main(String[] args) {
        int[] array = new int[] {89, 45, 67, 92, 39, 74, 26, 90};
        System.out.println(Arrays.toString(selectSort(array)));
    }

    /**
     * 선택 정렬 알고리즘의 입력 크기는 배열의 크기인 array.length 이다.
     * 기본 연산은 가장 많이 실행되는 (array[j] < array[minIndex]) 이다.
     * 선택 정렬의 시간 복잡도는 어떤 입력에 대해서도 동일한 O(n^2) 이다.
     * 선택 정렬은 이해하기 쉽지만 빠른 알고리즘은 아니다.
     * 그러나 배열 요소들 간의 교환은 (array.length - 1) 번 이루어진다.
     * 이는 선택 정렬을 다른 정렬 알고리즘과 차별화 시키는 장점이다.
     * 또한 선택 정렬은 제자리에서 정렬하기 때문에 추가 공간을 필요로 하지 않는다.
     * 따라서 선택 정렬은 입력 크기가 크지 않고 배열 요소들 간의 교환 비용이 큰 경우 적절하다.
     */
    private int[] selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i ++) {
            int minIndex = i;
            minIndex = getMinNumber(array, i, minIndex);

            int minContainer = array[minIndex];
            array[minIndex] = array[i];
            array[i] = minContainer;
        }
        return array;
    }

    private int getMinNumber(int[] array, int i, int minIndex) {
        for (int j = i + 1; j < array.length; j++) {
            if (array[j] < array[minIndex]) {
                minIndex = j;
            }
        }
        return minIndex;
    }

}
