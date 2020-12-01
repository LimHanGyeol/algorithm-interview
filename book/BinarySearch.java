// 자바로 쉽게 배우는 알고리즘
// 이진 탐색
class Solution {

    public static void main(String[] args) {
        int[] array = new int[] {10, 12, 13, 14, 18, 20, 25, 27, 30, 35, 40, 45, 47};
        int result = binarySearch(array, 0, array.length, 18);
        System.out.println(result); // 4
    }

    /**
     * 문제의 입력 크기는 배열의 크기인 n 이다.
     * 알고리즘의 기본 연산은 target과 배열의 중간 요소와의 비교이다.
     * 중간 요소와 한 번 비교할 때마다 탐색이 필요한 배열의 크기는 반으로 줄어 든다.
     * 총 비교 횟수는 탐색이 필요한 배열의 크기가 1일 될 때 한번 더 비교 하므로 log2n + 1이다.
     * 따라서 이진 탐색은 로그 시간 알고리즘이다.
     * 반면 순차 탐색은 최대 n번 비교해야 하므로 O(n) 알고리즘 이다.
     * 따라서 이진 탐색의 시간 복잡도는 O(log n) 이며,
     * 이진 탐색이 순차 탐색보다 훨씬 더 효율적인 알고리즘임을 알 수 있다.
     */
    private int binarySearch(int[] array, int first, int last, int target) {
        int mid = (first + last) / 2;

        if (first > last) {
            return - 1;
        }
        if (target == array[mid]) {
            return mid;
        }
        if (target < array[mid]) {
            return binarySearch(array, first, mid - 1, target);
        }
        return binarySearch(array, mid + 1, last, target);
    }

}
