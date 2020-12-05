// 자바로 쉽게 배우는 알고리즘
// 최대값 구하기 - 순차 탐색
class Solution {

    public static void main(String[] args) {
        int[] array = new int[] {72, 60, 83, 47, 89, 95};
        System.out.println(findMaxNumber(array));
    }

    private int findMaxNumber(int[] array) {
        int maxNumber = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxNumber) {
                maxNumber = array[i];
            }
        }
        return maxNumber;
    }

}
