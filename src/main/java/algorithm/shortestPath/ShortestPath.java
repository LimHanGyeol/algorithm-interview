package algorithm.shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

public class ShortestPath {

    private static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억 설정
    // 노드의 개수 n, 간선의 개수 m, 시작 노드 번호 start
    // 노드의 갯는 최대 100_000개라고 가정
    private static int n;
    private static int m;
    private static int start;

    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    private static final List<List<Node>> graph = new ArrayList<>();
    // 방문 여부를 확인하는 목적의 배열
    private static final boolean[] visited = new boolean[100001];
    // 최단 거리 테이블
    private static final int[] shortestPath = new int[100001];

    // 방문하지 않은 노드 중 가장 최단 거리가 짧은 노드의 번호 반환
    private static int getSmallestNode() {
        int min = INF;
        int index = 0; // 가장 최단 거리가 짧은 노드(인덱스)
        for (int i = 1; i <= n; i++) {
            if (shortestPath[i] < min && !visited[i]) {
                min = shortestPath[i];
                index = i;
            }
        }
        return index;
    }

    private static void dijkstra(int start) {
        // 시작 노드 초기화
        shortestPath[start] = 0;
        visited[start] = true;
        for (int j = 0; j < graph.get(start).size(); j++) {
            shortestPath[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
        }

        // 시작 노드를 제외한 전체 n - 1개의 노드에 대해 반복
        for (int i = 0; i < n - 1; i++) {
            // 현재 최단 거리가 가장 짧은 노드를 꺼내서 방문 처리
            int now = getSmallestNode();
            visited[now] = true;
            // 현재 노드와 연결된 다른 노드를 확인
            for (int j = 0; j < graph.get(now).size(); j++) {
                int cost = shortestPath[now] + graph.get(now).get(j).getDistance();
                // 현재 노드를 거쳐 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < shortestPath[graph.get(now).get(j).getIndex()]) {
                    shortestPath[graph.get(now).get(j).getIndex()] = cost;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();

        n = toInt(bufferedReader.readLine());
        m = toInt(bufferedReader.readLine());
        start = toInt(bufferedReader.readLine());

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 모든 간선 정보 입력
        for (int i = 0; i < m; i++) {
            int a = toInt(bufferedReader.readLine());
            int b = toInt(bufferedReader.readLine());
            int c = toInt(bufferedReader.readLine());
            // a 노드에서 b 노드로 가는 비용이 c 라는 의미
            graph.get(a).add(new Node(b, c));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(shortestPath, INF);

        // 다익스트라 수행
        dijkstra(start);

        // 모든 노드로 가기 위한 최단 거리 출력
        for (int i = 1; i <= n; i++) {
            // 도달할 수 없는 경우, INF 출력
            if (shortestPath[i] == INF) {
                System.out.println("INFINITY");
            } else {
                System.out.println(shortestPath[i]);
            }
        }
    }

    static class Node {
        private final int index;
        private final int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }
    }
}
