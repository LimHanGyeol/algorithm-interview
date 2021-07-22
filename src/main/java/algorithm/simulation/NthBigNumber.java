package algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * baekjoon. 2693
 * N번째 큰 수
 * 정렬
 */
public class NthBigNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        int n = toInt(bufferedReader.readLine());
        Integer[] array = new Integer[10];

        for (int i = 0; i < n; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            for (int j = 0; j < 10; j++) {
                array[j] = toInt(input[j]);
            }

            Arrays.sort(array);

            System.out.println(array[7]);
        }

    }
}
