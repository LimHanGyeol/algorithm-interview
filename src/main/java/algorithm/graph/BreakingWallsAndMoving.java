package algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * Baekjoon. 2206
 * 벽 부수고 이동하기 - Gold4
 * Graph - ShortestPath
 */
public class BreakingWallsAndMoving {

    private static int n;
    private static int m;
    private static int result = Integer.MAX_VALUE;
    private static final int[] DIRECTION_X = new int[]{-1, 1, 0, 0};
    private static final int[] DIRECTION_Y = new int[]{0, 0, -1, 1};

    private static int[][] map;
    private static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        String[] input = bufferedReader.readLine().split(" ");
        n = toInt(input[0]);
        m = toInt(input[1]);

        map = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] line = bufferedReader.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = toInt(line[j]);
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        searchMap(0, 0);

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(result);
    }

    private static void searchMap(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y, 1, 0));
        visited[x][y] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            x = node.x;
            y = node.y;
            int distance = node.distance;
            int breakCount = node.breakCount;

            if (x == n - 1 && y == m - 1) {
                result = node.distance;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newX = x + DIRECTION_X[i];
                int newY = y + DIRECTION_Y[i];

                // 맵을 벗어난 경우
                if (newX < 0 || newX >= map.length || newY < 0 || newY >= map[0].length) {
                    continue;
                }
                // 이미 벽을 부순 경우
                if (visited[newX][newY] <= breakCount) {
                    continue;
                }
                // 벽을 만난 경우
                if (map[newX][newY] == 1) {
                    if (breakCount == 0) {
                        visited[newX][newY] = breakCount + 1;
                        queue.offer(new Node(newX, newY, distance + 1, breakCount + 1));
                    }
                }
                // 길을 처음 방문하는 경우에만 최단 거리 기록
                if (map[newX][newY] == 0) {
                    visited[newX][newY] = breakCount;
                    queue.offer(new Node(newX, newY, distance + 1, breakCount));
                }
            }
        }
    }

    static class Node {
        int x;
        int y;
        int distance;
        int breakCount;

        public Node(int x, int y, int distance, int breakCount) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.breakCount = breakCount;
        }
    }
}
