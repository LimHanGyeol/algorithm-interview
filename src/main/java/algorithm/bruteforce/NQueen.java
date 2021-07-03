package algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * BaekJoon. 9663
 * N Queen
 * BruteForce - BackTracking
 */
public class NQueen {

    private static int[] map;
    private static int n;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        n = toInt(bufferedReader.readLine());
        map = new int[n];
        count = 0;

        nQueen(0);
        System.out.println(count);
    }

    private static void nQueen(int depth) {
        // 행을 다 채우면 카운트를 1 증가시키고 return 한다.
        if (depth == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            map[depth] = i;
            // 해당 열에서 i 번째 행에 놓을 수 있는지 검사하는 함수
            if (validatePosition(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    private static boolean validatePosition(int column) {
        for (int i = 0; i < column; i++) {
            // 해당 열의 행과 i열의 행이 일치할 경우 (같은 행에 존재할 경우)
            if (map[column] == map[i]) {
                return false;
            }

            // 대각선 상에 놓여있는 경우
            // 열의 차와 행의 차가 같을 경우 대각선에 놓여있다.
            if (Math.abs(column - i) == Math.abs(map[column] - map[i])) {
                return false;
            }
        }
        return true;
    }
}
