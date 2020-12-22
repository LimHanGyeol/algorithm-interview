// 자바로 쉽게 배우는 알고리즘
// 분할 정복 (DivideAndConquer)
// 최대값, 최소값 구하기
class Solution {

    public static void main(String[] args) {
        int[] array = new int[] {24, 75, 92, 83, 61, 48, 97, 50};
        // 24, 97
        System.out.println(Arrays.toString(findMaxMinNumber(array, 0, array.length - 1)));
    }

    private int[] findMaxMinNumber(int[] array, int i, int j) {
        int results = new int[2]; // 최대값과 최소값을 저장하는 배열

        // 배열에 1개의 요소만 있는 경우우
       if (i == j) {
            return new int[] {i, i};
        }
        // 배열에 2개의 요소들이 있는 경우
        if (i == j - 1) {
            if (array[i] < array[j]) {
                return new int[] {array[i], array[j]};
            }
            return new int[] {array[j], array[i]};
        }
        if (i != j - 1) {
            int mid = (i + j) / 2; // array 의 중앙 요소를 구한다.

            // 분할한 왼쪽 배열의 최대값과 최소값을 구하는 배열
            int[] leftResults = findMaxMinNumber(array, i, mid);

            // 분할한 오른쪽 배열의 최대값과 최소값을 구하는 배열
            int[] rightResults = findMaxMinNumber(array, mid + 1, j);

            // 위의 결과를 구한 마지막 해로 최대값, 최소값을 구한다.
            if (leftResults[0] < rightResults[0]) {
                results[0] = leftResults[0];
            }
            if (leftResults[1] < rightResults[1]) {
                results[1] = rightResults[1];
            }
        }
        return results;
    }
}
