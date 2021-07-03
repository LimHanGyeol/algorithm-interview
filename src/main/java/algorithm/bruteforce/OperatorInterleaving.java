package algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * BaekJoon. 14888
 * 연산자 끼워넣기
 * BruteForce - BackTracking
 */
public class OperatorInterleaving {

    private static int n;
    private static int[] numbers;
    private static int[] operators;
    private static int max;
    private static int min;

    public static void main(String[] args) throws IOException {
        input();
        dfs(numbers[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = init();
        n = toInt(bufferedReader.readLine());
        numbers = new int[n];
        operators = new int[4];

        String[] numberCount = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = toInt(numberCount[i]);
        }

        String[] inputOperators = bufferedReader.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            operators[i] = toInt(inputOperators[i]);
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    private static void dfs(int number, int index) {
        if (index == n) {
            max = Math.max(max, number);
            min = Math.min(min, number);
            return;
        }
        for (int i = 0; i < 4; i++) {
            // 연산자 개수가 1개 이상인 경우
            if (operators[i] > 0) {
                // 해당 연산자 개수를 1 감소 시킨다.
                operators[i]--;

                if (i == 0) {
                    dfs(number + numbers[index], index + 1);
                }
                if (i == 1) {
                    dfs(number - numbers[index], index + 1);
                }
                if (i == 2) {
                    dfs(number * numbers[index], index + 1);
                }
                if (i == 3) {
                    dfs(number / numbers[index], index + 1);
                }
                operators[i]++;
            }
        }
    }
}
