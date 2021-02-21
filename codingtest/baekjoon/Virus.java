import java.io.*;
import java.util.*;
/**
 * 백준
 * Graph - 바이러스. 2606 번
 */
class Main {

    private static int[][] graph;
    private static boolean[] visited;
    private static int node;
    private static edge;
    private static int count = 0;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int node = toInt(bufferedReader.readLine());
        int edge = toInt(bufferedReader.readLine());
        int count = 0;

        int[][] graph = new int[node + 1][node + 1];
        boolean[] visited = new boolean[node + 1];

        for (int i = 1; i <= edge; i++) {
            int x = toInt(bufferedReader.readLine());
            int y = toInt(bufferedReader.readLine());

            graph[x][y] = graph[y][x] = 1;
        }

        getVirusInfectionDfs(1);

        System.out.println(count);

    }

    public static void getVirusInfectionDfs(int startNode) {
        visited[startNode] = true;
        for (int i = 1; i<= node; i++) {
            if (graph[startNode][i] == 1 && !visited[i]) {
                count++;
                getVirusInfectionDfs(i);
            }
        }
    }

    public static int toInt(String value) {
        return Integer.parseInt(value);
    }

}
