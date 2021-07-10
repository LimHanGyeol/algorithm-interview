package algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * Baekjoon. 1913
 * 달팽이
 * Simulation
 */
public class Snail {

    private static int n;
    private static int findNumber;

    public static void main1(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        n = toInt(bufferedReader.readLine());
        findNumber = toInt(bufferedReader.readLine());
        int[][] map = new int[n][n];
        int number = n * n;

        int leftAndTop = 0;
        int bottomAndRight = 1;
        while (number > 2) {
            // 왼쪽
            for (int i = 0; i < map.length; i++) {
                if (map[i][leftAndTop] == 0) {
                    map[i][leftAndTop] = number;
                    number -= 1;
                }
            }

            // 아래쪽
            for (int i = 1; i < map[0].length; i++) {
                if (map[n - bottomAndRight][i] == 0) {
                    map[n - bottomAndRight][i] = number;
                    number -= 1;
                }
            }

            // 오른쪽
            for (int i = n - 2; i >= 0; i--) {
                if (map[i][n - bottomAndRight] == 0) {
                    map[i][n - bottomAndRight] = number;
                    number -= 1;
                }
            }

            // 위쪽
            for (int i = n - 2; i > 0; i--) {
                if (map[leftAndTop][i] == 0) {
                    map[leftAndTop][i] = number;
                    number -= 1;
                }
            }

            leftAndTop++;
            bottomAndRight++;
        }

        int central = n / 2;
        map[central][central] = 1;

        int x = 0;
        int y = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j] + " ");
                if (map[i][j] == findNumber) {
                    x = i;
                    y = j;
                }
            }
            System.out.println();
        }

        System.out.println((x + 1) + " " + (y + 1));
    }

    // 다른 사람의 풀이 비교
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();

        n = toInt(bufferedReader.readLine());
        findNumber = toInt(bufferedReader.readLine());

        int number = n * n;
        int[][] map = new int[n][n];

        int row = -1; // 행 위치 변수
        int column = 0; // 열 위치 변수
        int count = 1; // 행렬에 더해줄 변수

        while (true) {
            // 열은 고정하고 행을 변화시킨다.
            for (int i = 1; i <= n; i++) {
                row += count;
                map[row][column] = number;
                number--;
            }
            // 행부터 하나씩 작아진다.
            n--;
            // 열은 고정하고 행을 변화시키는 반복문 후에 반복횟수가 하나씩 적어진다.
            if (n <= 0) {
                break;
            }

            // n이 0보다 작거나 같으면 더 이상 들어갈 자리가 없다.
            // 행은 고정하고 열을 변화시킨다.
            for (int i = 1; i <= n; i++) {
                column += count;
                map[row][column] = number;
                number--;
            }
            // 한 루프가 다 돌면 행렬이 감소하거나 증가하는 순서가 바뀐다.
            // 그래서 더해주는 값을 1 또는 -1로 변경해줘야 한다.
            count *= -1;
        }


        int x = 0;
        int y = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j] + " ");
                if (map[i][j] == findNumber) {
                    x = i;
                    y = j;
                }
            }
            System.out.println();
        }

        System.out.println((x + 1) + " " + (y + 1));
    }
}
