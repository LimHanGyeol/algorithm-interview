package algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Programmers
 * Level2
 * 게임 맵 최단거리
 */
public class GameMapShortest {

    private static int n;
    private static int m;

    private static final int[] DIRECTION_X = new int[]{-1, 1, 0, 0};
    private static final int[] DIRECTION_Y = new int[]{0, 0, -1, 1};


    public int solution(int[][] maps) {
        n = maps.length - 1;
        m = maps[n].length - 1;


        int result = playGame(0, 0, maps);

        return result;
    }

    private int playGame(int x, int y, int[][] maps) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            x = node.getX();
            y = node.getY();

            for (int i = 0; i < 4; i++) {
                int newX = x + DIRECTION_X[i];
                int newY = y + DIRECTION_Y[i];

                // 맵을 벗어난 경우
                if (newX < 0 || newX >= maps.length || newY < 0 || newY >= maps[0].length) {
                    continue;
                }
                // 벽을 만난 경우
                if (maps[newX][newY] == 0) {
                    continue;
                }
                // 길을 처음 방문하는 경우에만 최단 거리 기록
                if (maps[newX][newY] == 1) {
                    maps[newX][newY] = maps[x][y] + 1;
                    queue.offer(new Node(newX, newY));
                }
            }
        }
        if (maps[n][m] == 1) {
            return -1;
        }
        return maps[n][m];
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
