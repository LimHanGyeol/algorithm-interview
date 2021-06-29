package algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * BaekJoon
 * Simulation (구현)
 * 달팽이2 - 1952
 */
public class Snail2 {

    private static boolean[][] visited;
    private static final int[] DIRECTION_X = new int[]{-1, 0, 1, 0};
    private static final int[] DIRECTION_Y = new int[]{0, 1, 0, -1};

    private static int m;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        String[] input = bufferedReader.readLine().split(" ");
        m = toInt(input[0]);
        n = toInt(input[1]);

        visited = new boolean[m][n];

        int x = 0;
        int y = 0;
        int directionIndex = 1;
        int count = 0;

        // 5 3
        while (!visited[x][y]) {
            visited[x][y] = true;

            int newX = x + DIRECTION_X[directionIndex];
            int newY = y + DIRECTION_Y[directionIndex];

            if (newX < 0 || newX >= m || newY < 0 || newY >= n || visited[newX][newY]) {
                if (directionIndex == 3) {
                    directionIndex = 0;
                } else {
                    directionIndex++;
                }
                count++;
            }

            x = x + DIRECTION_X[directionIndex];
            y = y + DIRECTION_Y[directionIndex];
        }

        System.out.println(count - 1);
    }
}
