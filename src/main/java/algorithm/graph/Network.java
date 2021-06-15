package algorithm.graph;

/**
 * Programmers
 * Level3
 * 네트워크 - DFS
 */
public class Network {

    private static int[][] networks;
    private static boolean[] visited;
    private static int result;

    public int solution(int n, int[][] computers) {
        networks = computers;
        visited = new boolean[n];

        for (int i = 0; i < networks.length; i++) {
            if (!visited[i]) {
                result++;
                dfs(i);
            }
        }
        return result;
    }

    private void dfs(int x) {
        visited[x] = true;

        for (int i = 0; i < networks.length; i++) {
            if (networks[x][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
