package algorithm.simulation;

/**
 * Programmers
 * Level2
 * 삼각 달팽이
 */
public class TriangleSnail {

    public int[] solution(int n) {
        int[][] snail = new int[n][n];
        int[] answer = new int[n * (n + 1) / 2];

        int x = -1;
        int y = 0;
        int number = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    x++;
                } else if (i % 3 == 1) {
                    y++;
                } else if (i % 3 == 2) {
                    x--;
                    y--;
                }
                snail[x][y] = number++;
            }
        }

        return getResult(snail, answer);
    }

    public int[] solution2(int n) {
        if (n == 1) {
            return new int[]{1};
        }
        int[] answer = new int[n * (n + 1) / 2];

        int[][] map = new int[n][n];
        int count = 1; // 배열 값
        int row = -1;
        int column = 0;

        while (true) {
            // 아래 방향
            for (int i = 0; i < n; i++) {
                row += 1;
                map[row][column] = count;
                count++;
            }

            n--;
            if (n == 0) {
                break;
            }

            // 오른쪽 방향
            for (int i = 0; i < n; i++) {
                column += 1;
                map[row][column] = count;
                count++;
            }

            n--;
            if (n == 0) {
                break;
            }

            // 대각선 방향
            for (int i = 0; i < n; i++) {
                row -= 1;
                column -= 1;
                map[row][column] = count;
                count++;
            }

            n--;
            if (n == 0) {
                break;
            }
        }

        return getResult(map, answer);
    }

    private int[] getResult(int[][] snail, int[] answer) {
        int index = 0;
        for (int i = 0; i < snail.length; i++) {
            for (int j = 0; j < snail[i].length; j++) {
                if (snail[i][j] == 0) {
                    break;
                }
                answer[index] = snail[i][j];
                index++;
            }
        }

        return answer;
    }
}
