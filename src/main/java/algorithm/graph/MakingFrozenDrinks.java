package algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static algorithm.util.IntegerParser.toInt;

/**
 * 이것이 취업을 위한 코딩 테스트다 with Python
 * Java
 * <p>
 * 음료수 얼려 먹기
 * 시간제한 1초, 메모리 제한 128MB
 * Input
 * - 첫 번째 줄에 얼음 틀의 세로 길이 N과 가로 길이 M이 주어진다. (1 <= N, M <= 1000)
 * - 두 번째 줄부터 N + 1번째 줄까지 얼음 틀의 형태가 주어진다.
 * - 이때 구멍이 뚫려있는 부분은 0, 그렇지 않은 부분은 1이다.
 * Output
 * - 한번에 만들 수 있는 아이스크림의 개수를 출력하라.
 * <p>
 * Ex
 * Input
 * - 4 5
 * - 00110
 * - 00011
 * - 11111
 * - 00000
 * Output : 3
 */
public class MakingFrozenDrinks {

    private static int n;
    private static int m;
    private static final int[][] GRAPH = new int[1000][1000];

    private static boolean dfs(int x, int y) {
        // 주어진 범위를 벗어나는 경우 종료
        if (x <= -1 || x >= n || y <= -1 || y >= m) {
            return false;
        }
        // 현재 노드를 아직 방문하지 않았다면 방문 처리
        if (GRAPH[x][y] == 0) {
            GRAPH[x][y] = 1;
            // 상 하 좌 우의 노드들 모두 재귀 호출
            dfs(x - 1, y); // 좌
            dfs(x + 1, y); // 우
            dfs(x, y + 1); // 상
            dfs(x, y - 1); // 하
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");
        n = toInt(input[0]);
        m = toInt(input[1]);

        // 2차원 리스트에 주어진 map 정보 입력받기
        for (int i = 0; i < n; i++) {
            String mapLine = bufferedReader.readLine();
            for (int j = 0; j < m; j++) {
                GRAPH[i][j] = mapLine.charAt(j) - '0'; // 아스키 코드로 값 제거 0: 15, 1 : 16
            }
        }

        // 모든 노드에 대하여 음료수 채우기
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 현재 위치에서 dfs 수행
                if (dfs(i, j)) {
                    result += 1;
                }
            }
        }
        System.out.println("result = " + result);
    }
}
