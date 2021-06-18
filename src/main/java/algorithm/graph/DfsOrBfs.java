package algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

public class DfsOrBfs {

    private static int n;
    private static int m;
    private static int v;

    private static int[][] adj; // 인접 행렬
    private static List<Integer>[] adjList; // 인접 리스트
    private static boolean[] visited;

    private static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = init();
        String[] input = bufferedReader.readLine().split(" ");
        n = toInt(input[0]);
        m = toInt(input[1]);
        v = toInt(input[2]);
        adj = new int[n + 1][n + 1];
        adjList = new ArrayList[n + 1];
        stringBuilder = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            String[] inputXY = bufferedReader.readLine().split(" ");
            int x = toInt(inputXY[0]);
            int y = toInt(inputXY[1]);
            adj[x][y] = 1;
            adj[y][x] = 1;
            adjList[x].add(y);
            adjList[y].add(x);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(adjList[i]);
        }
    }

    private static void process() {
        visited = new boolean[n + 1];
        dfs(v);
        stringBuilder.append('\n');
        visited = new boolean[n + 1];
        bfs(v);
        System.out.println(stringBuilder.toString());
    }

    private static void dfs(int x) {
        visited[x] = true;
        stringBuilder.append(x).append(' ');
        for (int y = 1; y <= n; y++) { // 인접 행렬을 이용한 DFS
            if (adj[x][y] == 0) {
                continue;
            }
            if (visited[y]) {
                continue;
            }
            dfs(y);
        }

        for (int y : adjList[x]) { // 인접 리스트를 이용한 DFS
            if (visited[y]) {
                continue;
            }
            dfs(y);
        }
    }

    private static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(x);
        visited[x] = true;

        while (!queue.isEmpty()) {
            x = queue.poll();
            stringBuilder.append(x).append(' ');
            for (int y = 1; y <= n; y++) { // 인접 행렬을 이용한 BFS
                if (adj[x][y] == 0) {
                    continue;
                }
                if (visited[y]) {
                    continue;
                }
                queue.add(y);
                visited[y] = true;
            }

            for (int y : adjList[x]) { // 인접 리스트를 이용한 BFS
                if (visited[y]) {
                    continue;
                }

                queue.add(y);
                visited[y] = true;
            }
        }
    }
}
