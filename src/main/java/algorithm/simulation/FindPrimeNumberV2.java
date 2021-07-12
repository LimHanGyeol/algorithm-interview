package algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * BaekJoon. 1978
 * 소수 찾기
 * Prime Number
 */
public class FindPrimeNumberV2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        int testCase = toInt(bufferedReader.readLine());
        String[] input = bufferedReader.readLine().split(" ");

        int[] array = initArray(testCase, input);

        int count = getCount(array);
        System.out.println(count);
    }

    private static int[] initArray(int testCase, String[] input) {
        int[] array = new int[testCase];
        for (int i = 0; i < testCase; i++) {
            int number = toInt(input[i]);
            array[i] = number;
        }
        return array;
    }

    private static int getCount(int[] array) {
        int count = 0;
        for (int number : array) {
            if (number > 2 && isPrimeNumber(number)) {
                count++;
            }
        }
        return count;
    }

    // 에라토스테네스의 체
    private static boolean isPrimeNumber(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
