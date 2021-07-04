package algorithm.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * BaekJoon. 2470
 * 두 용액
 * BinarySearch, Sort, Two Pointer
 */
public class TwoSolutions {

    private static int n;
    private static int[] solutions;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        n = toInt(bufferedReader.readLine());
        String[] inputArray = bufferedReader.readLine().split(" ");
        solutions = new int[n];
        for (int i = 0; i < inputArray.length; i++) {
            solutions[i] = toInt(inputArray[i]);
        }

        Arrays.sort(solutions);

        int start = 0;
        int end = solutions.length - 1;
        long result = Integer.MAX_VALUE;
        int answer1 = 0;
        int answer2 = 0;

        while (start != end) {
            if (result > Math.abs(solutions[end] + solutions[start])) {
                result = Math.abs(solutions[end] + solutions[start]);
                answer1 = solutions[start];
                answer2 = solutions[end];
            }

            if (Math.abs(solutions[start] + solutions[end - 1]) < Math.abs(solutions[start + 1] + solutions[end])) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println(answer1 + " " + answer2);
    }
}
