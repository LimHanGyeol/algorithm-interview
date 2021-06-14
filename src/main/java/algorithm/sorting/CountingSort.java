package algorithm.sorting;

/**
 * 계수 정렬
 * 계수 정렬은 각각의 데이터가 몇 번씩 등장했는지 세는 방식으로 동작하는 정렬 알고리즘이다.
 * 가장 작은 데이터부터 큰 데이터까지
 * 모든 범위를 포함할 수 있는 배열을 만들어야 해서 공간 복잡도가 높다.
 * <p>
 * 하지만 퀵 정렬과 비교해서 조건만 만족하면 더 빠르게 동작할 수 있다.
 */
public class CountingSort {

    private static final int MAX_VALUE = 9;

    public static void main(String[] args) {
        int[] array = new int[]{7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
        int[] count = new int[MAX_VALUE + 1];
        int n = array.length;

        for (int i = 0; i < n; i++) {
            // 각 데이터에 해당하는 인덱스 값 증가
            count[array[i]] += 1;
        }

        for (int i = 0; i <= MAX_VALUE; i++) {
            for (int j = 0; j < count[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }
}
