import java.io.*;
import java.util.*;
/**
 * 백준
 * Graph - 바이러스. 2606 번
 */
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int node = toInt(bufferedReader.readLine());
        int edge = toInt(bufferedReader.readLine());

        int[][] matrix = new int[node + 1][node + 1];
        int length = matrix.length;
        boolean[] visited = new boolean[node + 1];

        for (int i = 0; i < edge; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int x = toInt(input[0]);
            int y = toInt(input[1]);

            matrix[x][y] = matrix[y][x] = 1;
        }

        System.out.println(bfs(matrix, visited, 1));
    }

    private static int bfs(int[][] matrix, boolean[] visited, int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        visited[startNode] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i = 1; i < matrix.length; i++) {
                if (matrix[node][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
        return count;
    }

    private static int toInt(String value) {
        return Integer.parseInt(value);
    }

}
