package algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * BaekJoon. 2581
 * 소수
 * Prime Number
 */
public class PrimeNumberV2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        int m = toInt(bufferedReader.readLine());
        int n = toInt(bufferedReader.readLine());

        int size = n - m;
        int[] numbers = initArray(m, size);

        List<Integer> primeNumbers = findPrimeNumbers(numbers);

        if (primeNumbers.isEmpty()) {
            System.out.println("-1");
            return;
        }

        int sum = primeNumbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        OptionalInt min = primeNumbers.stream()
                .mapToInt(Integer::intValue)
                .min();

        System.out.println(sum);
        System.out.println(min.getAsInt());
    }

    private static List<Integer> findPrimeNumbers(int[] numbers) {
        List<Integer> primeNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (number != 1 && isPrimeNumber(number)) {
                primeNumbers.add(number);
            }
        }
        return primeNumbers;
    }

    private static int[] initArray(int m, int size) {
        int[] numbers = new int[size + 1];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = m++;
        }
        return numbers;
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
