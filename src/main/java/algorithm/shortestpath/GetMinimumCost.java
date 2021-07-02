package algorithm.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * BaekJoon. 1916
 * 최소비용 구하기
 * Graph, Dijkstra
 */
public class GetMinimumCost {

    private static int N;
    private static int M;
    private static int start;
    private static int end;
    private static int[] distance;
    private static List<Edge>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        N = toInt(bufferedReader.readLine());
        M = toInt(bufferedReader.readLine());
        distance = new int[N + 1];
        edges = new ArrayList[N + 1];

        // 인접 리스트 초기화
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int from = toInt(input[0]);
            int to = toInt(input[1]);
            int weight = toInt(input[2]);
            edges[from].add(new Edge(to, weight));
        }

        String[] startAndEnd = bufferedReader.readLine().split(" ");
        start = toInt(startAndEnd[0]);
        end = toInt(startAndEnd[1]);

        dijkstra(start);
        System.out.println(distance[end]);
    }

    private static void dijkstra(int start) {
        // 모든 정점까지에 대한 거리를 무한대로 초기화 해주기
        for (int i = 1; i <= N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        // 최소 힙 생성
        PriorityQueue<Info> priorityQueue = new PriorityQueue<>(Comparator.comparing(o -> o.distance));

        // 시작점에 대한 정보(Information)을 기록에 추가하고,
        // 거리배열에 갱신한다
        priorityQueue.add(new Info(start, 0));
        distance[start] = 0;

        // 거리 정보들이 모두 소진될 때까지 거리 갱신을 반복한다.
        while (!priorityQueue.isEmpty()) {
            Info info = priorityQueue.poll();

            if (distance[info.index] < info.distance) {
                continue;
            }

            for (Edge edge : edges[info.index]) {
                if (distance[info.index] + edge.weight >= distance[edge.to]) {
                    continue;
                }

                distance[edge.to] = distance[info.index] + edge.weight;
                priorityQueue.add(new Info(edge.to, distance[edge.to]));
            }
        }
    }

    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Info {
        int index;
        int distance;

        public Info(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
}
