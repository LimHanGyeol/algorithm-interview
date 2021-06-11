package algorithm.stringhandleing;

/**
 * Programmers
 * Level2
 * 행렬 테두리 회전
 */
public class MatrixBorderRotation {

    private static int[][] matrix;
    private static int min;

    public int[] solution(int rows, int columns, int[][] queries) {
        matrix = initMatrix(rows, columns);
        int[] results = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            results[i] = rotateMatrixBorder(queries[i]);
        }

        return results;
    }

    private int[][] initMatrix(int rows, int columns) {
        matrix = new int[rows + 1][columns + 1];
        int value = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                matrix[i][j] = value;
                value++;
            }
        }
        return matrix;
    }

    private int rotateMatrixBorder(int[] query) {
        // 가로, 세로 길이
        int xLength = query[2] - query[0];
        int yLength = query[3] - query[1];

        // 현재 위치 및 현재 값
        int x1 = query[0];
        int y1 = query[1];
        int currentNumber = matrix[x1][y1];

        // 현재 값을 최소값으로 초기화
        min = currentNumber;

        // 시계방향 회전
        // 오른쪽 이동
        for (int i = 0; i < yLength; i++) {
            y1 += 1;
            currentNumber = moveNumber(x1, y1, currentNumber);
        }
        // 아래 이동
        for (int i = 0; i < xLength; i++) {
            x1 += 1;
            currentNumber = moveNumber(x1, y1, currentNumber);
        }

        // 왼쪽 이동
        for (int i = 0; i < yLength; i++) {
            y1 -= 1;
            currentNumber = moveNumber(x1, y1, currentNumber);
        }

        // 위 이동
        for (int i = 0; i < xLength; i++) {
            x1 -= 1;
            currentNumber = moveNumber(x1, y1, currentNumber);
        }
        return min;
    }

    private int moveNumber(int x, int y, int beforeNumber) {
        // 이동한 지점의 숫자 저장
        int movedNumber = matrix[x][y];

        // 최소값 초기화
        min = Math.min(min, movedNumber);

        // 이동한 지점의 숫자를 이전 지점의 숫자로 초기화
        matrix[x][y] = beforeNumber;
        return movedNumber;
    }
}
