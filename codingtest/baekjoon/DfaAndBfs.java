import java.io.*;
import java.util.*;
/**
 * 백준
 * Graph - DFS 와 BFS. 1260
 */
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int node = toInt(bufferedReader.readLine());
        int edge = toInt(bufferedReader.readLine());

        int[][] matrix = new int[node + 1][node + 1];
        boolean[] visited = new boolean[node + 1];

        for (int i = 0; i < edge; i++) {
            String[] inputEdge = bufferedReader.readLine().split(" ");
            int x = toInt(inputEdge[0]);
            int y = toInt(inputEdge[1]);

            matrix[x][y] = matrix[y][x] = 1;
        }

        int count = dfs(1, matrix, visited, 0);
        System.out.println(count);
        System.out.println();

       visited = new boolean[node + 1];

       bfs(matrix, visited, startNode);
    }

    private static int dfs(int startNode, int[][] matrix, boolean[] visited, int count) {
        visited[startNode] = true;

        if (startNode == matrix.length) {
            return 0;
        }

        for (int i = 1; i < matrix.length - 1; i++) {
            if (matrix[startNode][i] == 1 && !visited[i]) {
                count++;
                dfs(i, matrix, visited, count);
            }
        }
        return count;
    }

    private static void bfs(int[][] matrix, boolean[] visited, int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int i = 1; i < matrix.length; i++) {
                if (matrix[node][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }

        }
    }

    private static int toInt(String value) {
        return Integer.parseInt(value);
    }

}
