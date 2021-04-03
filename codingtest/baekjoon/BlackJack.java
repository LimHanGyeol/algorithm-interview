import java.io.*;
import java.util.*;
/**
 * 백준
 * 블랙잭 - 2798. 브루트 포스
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputNM = bufferedReader.readLine().split(" ");
        String[] inputCards = bufferedReader.readLine().split(" ");

        int N = toInt(inputNM[0]);
        int M = toInt(inputNM[1]);

        int[] array = new int[N];

        for (int i = 0; i < array.length; i++) {
            array[i] = toInt(inputCards[i]);
        }

        int result = playBlackJack(array, N, M);
        System.out.println(result);
    }

    private static int playBlackJack(int[] array, int N, int M) {
        int result = 0;

        for (int i = 0; i < N - 2; i++) {
            if (array[i] > M) {
                continue;
            }
            for (int j = i + 1; j < N - 1; j++) {
                if (array[i] + array[j] > M) {
                    continue;
                }
                for (int k = j + 1; k < N; k++) {
                    int sum = array[i] + array[j] + array[k];
                    if (M == sum) {
                        return sum;
                    }
                    if (result < sum && sum < M) {
                        result = sum;
                    }
                }
            }
        }
        return result;
    }


    private static int toInt(String value) {
        return Integer.parseInt(value);
    }

}
