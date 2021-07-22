package algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * Baekjoon. 2702
 * 초6 수학
 * 최대 공약수와 최소 공배수
 */
public class SixthGradeMath {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        int n = toInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int first = toInt(input[0]);
            int second = toInt(input[1]);

            int gcd = calculateGCD(first, second);
            int lcm = first * second / gcd;

            System.out.print(lcm + " " + gcd);
            System.out.println();
        }
    }

    private static int calculateGCD(int first, int second) {
        if (second == 0) {
            return first;
        }
        return calculateGCD(second, first % second);
    }
}
