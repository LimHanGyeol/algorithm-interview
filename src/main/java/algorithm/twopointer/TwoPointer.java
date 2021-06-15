package algorithm.twopointer;

/**
 * Two Pointer
 * 특정한 합을 가지는 부분 연속 수열 찾기
 */
public class TwoPointer {

    private static int n = 5; // 데이터의 개수 N
    private static int m = 5; // 찾고자 하는 부분합 M
    private static int[] array = new int[]{1, 2, 3, 2, 5};

    public static void main(String[] args) {
        int count = 0;
        int intervalSum = 0; // 부분합
        int end = 0;

        // start를 차례대로 증가시키며 반복
        for (int start = 0; start < n; start++) {
            // end를 가능한 만큼 이동시키기
            while (intervalSum < m && end < n) {
                intervalSum += array[end];
                end += 1;
            }
            // 부분합이 m일 때 카운트 증가
            if (intervalSum == m) {
                count += 1;
            }
            intervalSum -= array[start];
        }
        System.out.println("count = " + count);
    }
}
