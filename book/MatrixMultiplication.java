// 자바로 쉽게 배우는 알고리즘
// 동적 계획법 (Dynamic Programming)
// 연속 행렬 곱셈
class Solution {

    public static void main(String[] args) {
        int[] array = new int[] {10, 20, 50, 1, 100};
        int size = array.length;

        System.out.println(matrixMultiplication(array, size)); // 2200
    }

    /**
     * M1 * M2 * . . . * Mn 을 계산하기 위한 최소 곱셈 횟수를 동적 계획법을 이용하여 계산한다.
     * 곱한 행렬들의 수는 n 이다.
     * 행렬 Mi, i = 1 .. n, 은 array[i - 1] * array[i] 행렬이다.
     */
    private int matrixMultiplication() {
        // 프로그램을 단순화 하기 위해 배열 matrix 의
        // 첫 번째 행과 열은 사용하지 않는다.
        int[][] matrix = new int[n][n];

        // matrix[i, j] = Mi * Mi + 1 * ... Mj 를 계산하기 위한 최소 곱셈 횟수

        // 행렬이 하나만 있으면 곱할 필요가 없다.
        for (int i = 1; i < n; i++) {
            matrix[i][i] = 0;
        }

        // len 은 행렬 곱셉들의 수 이다.
        for (int len = 1; len < n - 1; len++) {
            for (int i = 1; i < n - len; i++) {
                int j = i + len;
                matrix[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    // quantity 는 두개의 행렬 곱으로 분할한 후 곱하는 경우의 최소 곱셈 횟수 이다.
                    int quantity = matrix[i][k] + matrix[k + 1][j] + array[i - 1] * array[k] * array[j];

                    if (quantity < matrix[i][j]) {
                        matrix[i][j] = quantity;
                    }
                }
            }
        }
        return matrix[1][n - 1];
    }

}
