package algorithm.bruteforce;

import java.io.*;

/**
 * BaekJoon. 15651
 * N과 M(1)
 * BruteForce - BackTracking
 */
public class NandM1 {

    private static int[] results;
    private static boolean[] visited;
    private static final StringBuilder stringBuilder = new StringBuilder();

    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        input();
        calculate(N, M, 0);
        System.out.println(stringBuilder);
    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine();
        String[] inputElements = input.split(" ");

        N = toInt(inputElements[0]);
        M = toInt(inputElements[1]);

        results = new int[M];
        visited = new boolean[N];
    }

    private static int toInt(String value) {
        return Integer.parseInt(value);
    }

    private static void calculate(int n, int m, int depth) {
        if (depth == m) {
            for (int result : results) {
                stringBuilder.append(result).append(' ');
            }
            stringBuilder.append('\n');
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                results[depth] = i + 1;
                calculate(n, m, depth + 1);
                visited[i] = false;
            }
        }
    }
}
