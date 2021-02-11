import java.io.*;
import java.util.*;
/**
 * 백준
 * Graph - DFS 와 BFS. 1260
 */
class Main {

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstInputs = bufferedReader.readLine().split(" ");

        int node = toInt(firstInputs[0]);
        int edge = toInt(firstInputs[1]);
        int startNode = toInt(firstInputs[2]);

        int[][] matrix = new int[node + 1][node + 1];

        for (int i = 0; i < edge; i++) {
            String[] secondInputs = bufferedReader.readLine().split(" ");
            int x = toInt(secondInputs[0]);
            int y = toInt(secondInputs[1]);

            matrix[x][y] = matrix[y][x] = 1;
        }

        boolean[] visited = new boolean[node + 1];
        dfs(matrix, visited, startNode);

        System.out.println();

        visited = new boolean[node + 1];
        bfs(matrix, visited, startNode);
    }

    private static int toInt(String value) {
        return Integer.parseInt(value);
    }

    private static void dfs(int[][] matrix, boolean[] visited, int startNode) {
        int matrixLength = matrix.length;
        if (startNode == matrixLength) {
            return;
        }

        visited[startNode] = true;
        System.out.print(startNode + " ");

        for (int i = 1; i < matrixLength; i++) {
            if (matrix[startNode][i] == 1 && !visited[i]) {
                dfs(matrix, visited, i);
            }
        }
    }

    private static void bfs(int[][] matrix, boolean[] visited, int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        visited[startNode] = true;
        System.out.print(startNode + " ");

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i = 1; i < matrix.length; i++) {
                if (matrix[node][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }

}
