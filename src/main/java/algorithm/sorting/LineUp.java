package algorithm.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * BaekJoon. 2252
 * 줄 세우기
 * Graph, Topological Sort
 */
public class LineUp {

    private static int n;
    private static int m;
    private static List<Integer>[] adjacencyList;
    private static int[] indegree;
    private static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        String[] input = bufferedReader.readLine().split(" ");
        n = toInt(input[0]);
        m = toInt(input[1]);
        adjacencyList = new ArrayList[n + 1];
        indegree = new int[n + 1];
        stringBuilder = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] inputHeight = bufferedReader.readLine().split(" ");
            int x = toInt(inputHeight[0]);
            int y = toInt(inputHeight[1]);
            adjacencyList[x].add(y);
            indegree[y]++;
        }

        process();

    }

    private static void process() {
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            stringBuilder.append(x).append(" ");

            for (int y : adjacencyList[x]) {
                indegree[y]--;
                if (indegree[y] == 0) {
                    queue.add(y);
                }
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
