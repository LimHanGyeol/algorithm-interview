package algorithm.twopointer;

import java.io.BufferedReader;
import java.io.IOException;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * BaekJoon. 1806
 * 부분 합
 * Two Pointers
 */
public class PartialSum {

    private static int n;
    private static int s;
    private static int[] sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        String[] firstInput = bufferedReader.readLine().split(" ");
        n = toInt(firstInput[0]);
        s = toInt(firstInput[1]);

        String[] secondInput = bufferedReader.readLine().split(" ");
        sequence = new int[n];
        for (int i = 0; i < secondInput.length; i++) {
            sequence[i] = toInt(secondInput[i]);
        }

        process();
    }

    private static void process() {
        int R = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;

        for (int L = 0; L < n; L++) {
            // R을 옮길 수 잇을 때 까지 옮기기
            while (R < n && sum < s) {
                sum += sequence[R];
                R++;
            }

            // [L ... R]의 합, 즉 sum이 조건을 만족하면 정답 갱신하기기
            if (sum >= s) {
                sum -= sequence[L];
                answer = Math.min(answer, R - L);
            }
        }

        if (answer == Integer.MAX_VALUE) {
            answer = 0;
        }
        System.out.println(answer);
    }
}
