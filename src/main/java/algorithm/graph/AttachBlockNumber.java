package algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * BaekJoon. 2267
 * 단지번호 붙이기
 * Graph
 */
public class AttachBlockNumber {

    private static int N;
    private static int groupCount;
    private static String[] block;
    private static boolean[][] visited;
    private static final int[][] DIRECTION = new int[][]{
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };
    private static List<Integer> group;
    private static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
    private static void input() throws IOException {
        BufferedReader bufferedReader = init();
        N = toInt(bufferedReader.readLine());
        block = new String[N];
        for (int i = 0; i < N; i++) {
            block[i] = bufferedReader.readLine();
        }
        visited = new boolean[N][N];
        stringBuilder = new StringBuilder();
    }

    private static void process() {
        // 단지를 찾을 때 마다 단지를 기록해주는 배열
        group = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 갈 수 있는 칸인데, 이미 방문처리 된, 즉 새롭게 만난 단지의 경우
                if (!visited[i][j] && block[i].charAt(j) == '1') {
                    groupCount = 0;
                    dfs(i, j);
                    group.add(groupCount);
                }
            }
        }
        Collections.sort(group);
        stringBuilder.append(group.size()).append('\n');
        for (int count : group) {
            stringBuilder.append(count).append('\n');
        }
        System.out.println(stringBuilder);
    }

    private static void dfs(int x, int y) {
        // 단지에 속한 집의 개수 증가, visited 체크
        groupCount++;
        visited[x][y] = true;

        // 인접한 집으로 새로운 방문
        for (int k = 0; k < 4; k++) {
            int newX = x + DIRECTION[k][0];
            int newY = y + DIRECTION[k][1];

            // 격자 (맵)을 벗어나는 경우
            if (newX < 0 || newY < 0 || newY >= N || newX >= N) {
                continue;
            }

            if (block[newX].charAt(newY) == '0') {
                continue;
            }

            if (visited[newX][newY]) {
                continue;
            }
            dfs(newX, newY);
        }
   }
}
