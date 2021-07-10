package algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * BaekJoon. 11725
 * 트리의 부모 찾기
 * Graph - GraphSearch, Tree, DFS
 */
public class FindParentTree {

    private static int n;
    private static List<Integer>[] adjacencyList;
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        input();
        dfs(1, -1); // -1은 부모가 없다는 것을 의미한다.
        output();
    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = init();
        n = toInt(bufferedReader.readLine());
        adjacencyList = new ArrayList[n + 1];
        parents = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int x = toInt(input[0]);
            int y = toInt(input[1]);
            adjacencyList[x].add(y);
            adjacencyList[y].add(x);
        }
    }

    private static void dfs(int x, int parent) {
        for (int y : adjacencyList[x]) {
            if (y == parent) {
                continue;
            }
            parents[y] = x;
            dfs(y, x);
        }
    }

    private static void output() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            stringBuilder.append(parents[i]).append('\n');
        }
        System.out.println(stringBuilder);
    }

}
