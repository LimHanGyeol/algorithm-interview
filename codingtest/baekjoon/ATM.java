import java.io.*;
import java.util.*;
/**
 * 백준
 * Greedy - 11399. ATM
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = bufferedReader.read();
        int count = 0;
        int result = 0;
        int[] array = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            array[i] = bufferedReader.read();
        }
        Arrays.sort(array);

        for (int i = 1; i <= n; i++) {
            count += array[i];
            result += count;
        }

        System.out.println(result);
    }

}
