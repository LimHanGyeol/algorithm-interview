package algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * Baekjoon. 2178
 * 미로 탐색 - Silver1
 * Graph - 최단거리 탐색
 * 인접 행렬과 인접 리스트를 이용한 풀이. 인접 리스트를 이용한 풀이가 더 권장된다.
 */
public class SearchMaze {

    private static int n;
    private static int m;

    private static final int[] DIRECTION_X = new int[]{-1, 1, 0, 0};
    private static final int[] DIRECTION_Y = new int[]{0, 0, -1, 1};

    private static List<Integer>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        String[] input = bufferedReader.readLine().split(" ");
        n = toInt(input[0]);
        m = toInt(input[1]);

//        int[][] map = new int[n][m];
        map = new ArrayList[n];

        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            String[] line = bufferedReader.readLine().split("");
            for (int j = 0; j < line.length; j++) {
//                map[i][j] = toInt(line[j]);
                map[i].add(toInt(line[j]));
            }
        }

        int result = searchMaze(0, 0);
        System.out.println(result);
    }

    //    private static int searchMaze(int x, int y, int[][] map) { 인접 행렬
    private static int searchMaze(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            x = node.x;
            y = node.y;

            for (int i = 0; i < 4; i++) {
                int newX = x + DIRECTION_X[i];
                int newY = y + DIRECTION_Y[i];

                // map을 벗어난 경우 // 인접 행렬 map[0].length
                if (newX < 0 || newX >= map.length || newY < 0 || newY >= map[0].size()) {
                    continue;
                }
                // 벽을 만난 경우
                if (map[newX].get(newY) == 0) {
                    continue;
                }
//                if (map[newX][newY] == 0) { // 인접 행렬
//                    continue;
//                }
                // 길을 처음 방문하는 경우 최단거리 기록
//                if (map[newX][newY] == 1) { // 인접 행렬
                if (map[newX].get(newY) == 1) {
                    map[newX].set(newY, map[x].get(y) + 1);
                    queue.offer(new Node(newX, newY));
                }
            }
        }
        return map[n - 1].get(m - 1);
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
