package algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * BaekJoon. 1182
 * 부분수열의 합
 * BruteForce - BackTracking
 */
public class SumOfSubsequences {

    private static int n;
    private static int s;
    private static int count = 0;
    private static int[] sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        String[] input = bufferedReader.readLine().split(" ");
        n = toInt(input[0]);
        s = toInt(input[1]);

        String[] inputSequence = bufferedReader.readLine().split(" ");
        sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = toInt(inputSequence[i]);
        }

        calculate(0, 0);
        if (s == 0) {
            count--;
        }
        System.out.println(count);
    }

    private static void calculate(int index, int value) {
        if (index == n) {
            if (value == s) {
                count++;
            }
            return;
        }
        // Include
        calculate(index + 1, value + sequence[index]);
        // Exclude
        calculate(index + 1, value);
    }
}
