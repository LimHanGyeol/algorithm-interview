package algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * Baekjoon. 1929
 * 소수 구하기 - Silver2
 * PrimeNumber
 */
public class MakePrimeNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        String[] input = bufferedReader.readLine().split(" ");
        int m = toInt(input[0]);
        int n = toInt(input[1]);

        int[] array = initArray(m, n);

        validatePrint(array);
    }

    private static int[] initArray(int start, int end) {
        int size = end - start;
        int[] array = new int[size + 1];
        for (int i = 0; i < array.length; i++) {
            array[i] = start;
            start++;
        }
        return array;
    }

    private static void validatePrint(int[] array) {
        for (int number : array) {
            if (number > 1 && isPrimeNumber(number)) {
                System.out.println(number);
            }
        }
    }

    private static boolean isPrimeNumber(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
