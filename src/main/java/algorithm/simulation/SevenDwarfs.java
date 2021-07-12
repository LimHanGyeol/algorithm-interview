package algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * BaekJoon. 2309
 * 일곱 난쟁이
 * Combination
 */
public class SevenDwarfs {

    public static final int n = 9;
    public static final int r = 7;
    public static int[] dwarfs = new int[n + 1];
    public static int[] output = new int[r];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();

        for (int i = 0; i < n; i++) {
            dwarfs[i] = toInt(bufferedReader.readLine());
        }

        findDwarfs(n, r, 0, 0);
    }

    // 9C7
    private static void findDwarfs(int n, int r, int index, int target) {
        if (r == 0) {
            int sum = 0;
            for (int height : output) {
                sum += height;
            }

            if (sum == 100) {
                Arrays.sort(output);
                for (int number : output) {
                    System.out.println(number);
                }
            }
            return;
        }
        if (target == n) { // 탐색은 다 했지만 필요한 개수만큼 뽑지 못한 경우
            return;
        }

        // 현재 위치에 target 인덱스에 존재하는 난쟁이의 키 삽입
        output[index] = dwarfs[target];
        // array[target]을 뽑은 경우
        findDwarfs(n, r - 1, index + 1, target + 1);

        // array[target]을 뽑지 않은 경우
        findDwarfs(n, r, index, target + 1);
    }
}
