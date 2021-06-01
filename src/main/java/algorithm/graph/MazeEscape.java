package algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import static algorithm.util.IntegerParser.toInt;

/**
 * 이것이 취업을 위한 코딩 테스트다 with Python
 * Java
 * <p>
 * 미로 탈출
 * 시간제한 1초, 메모리 제한 128MB
 * Input
 * - 첫 번째 줄에 두 정수 N, M(4 <= N, M <= 200)이 주어진다.
 * - 다음 N개의 줄에는 각각 M개의 정수(0 & 1)로 미로의 정보가 주어진다.
 * - 괴물이 있는 부분은 0, 괴물이 없는 부분은 1이다.
 * - 각각의 수들은 공백 없이 붙어서 입력된다.
 * - 시작 칸과 마지막 칸은 항상 1이다.
 * Output
 * - 첫째 줄에 최소 이동 칸의 개수를 출력하라.
 * <p>
 * Ex
 * Input
 * - 5 6
 * - 101010
 * - 111111
 * - 000001
 * - 111111
 * - 111111
 * Output : 10
 */
public class MazeEscape {

    private static int n;
    private static int m;
    private static final int[][] GRAPH = new int[200][200];

    // 이동할 네 가지 방향 정의 (상, 하, 좌, 우)
    private static final int[] DIRECTION_X = new int[]{-1, 1, 0, 0};
    private static final int[] DIRECTION_Y = new int[]{0, 0, -1, 1};

    // BFS는 간선의 비용이 모두 같을 때 최단 거리를 탐색할 수 있다.
    private static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            x = node.getX();
            y = node.getY();
            // 현재 위치에서 4가지 방향으로 위치 확인
            for (int i = 0; i < 4; i++) {
                int newX = x + DIRECTION_X[i];
                int newY = y + DIRECTION_Y[i];
                // 미로 찾기 공간을 벗어난 경우 무시
                if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
                    continue;
                }
                // 벽인 경우 무시
                if (GRAPH[newX][newY] == 0) {
                    continue;
                }
                // 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
                if (GRAPH[newX][newY] == 1) {
                    GRAPH[newX][newY] = GRAPH[x][y] + 1;
                    queue.offer(new Node(newX, newY));
                }
            }
        }
        // 가장 오른쪽 아래까지의 최단 거리 반환
        return GRAPH[n - 1][m - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");
        n = toInt(input[0]);
        m = toInt(input[1]);

        // graph에 map 입력
        for (int i = 0; i < n; i++) {
            String mapLine = bufferedReader.readLine();
            for (int j = 0; j < m; j++) {
                GRAPH[i][j] = mapLine.charAt(j) - '0';
            }
        }
        System.out.println(bfs(0, 0));
    }

    static class Node {
        private final int x;
        private final int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
