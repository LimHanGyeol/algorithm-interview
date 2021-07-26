package algorithm.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * Baekjoon. 1753
 * 최단 경로 - Gold5
 * Graph - Dijkstra
 * 최단경로 그래프를 풀때 주의해야할 점이 양방향, 단방향 여부이다.
 * initMap 에서 양방향 매핑을 하지 않으면 vertext 5와 1은 연결되지 않는다.
 * 해당 문제에서는 단방향 그래프가 되어서 풀이가 되지만,
 * 프로그래머스의 배달 문제에서는 양방향 그래프로 값을 매핑해줘야 했다.
 */
public class ShortestPathBaekjoon {

    private static int vertex;
    private static int edge;
    private static int start;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        String[] input = bufferedReader.readLine().split(" ");
        vertex = toInt(input[0]); // 정점의 수
        edge = toInt(input[1]); // 간선의 수
        start = toInt(bufferedReader.readLine()); // 시작 정점

        Map<Integer, List<Node>> matrix = initMap(vertex, bufferedReader);
        Map<Integer, Integer> visitedNodeMap = dijkstra(matrix, start);
        printResult(visitedNodeMap);
    }

    private static Map<Integer, List<Node>> initMap(int vertex, BufferedReader bufferedReader) throws IOException {
        Map<Integer, List<Node>> map = new HashMap<>();

        for (int i = 1; i <= vertex; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            String[] mapInfo = bufferedReader.readLine().split(" ");
            int u = toInt(mapInfo[0]);
            int v = toInt(mapInfo[1]);
            int w = toInt(mapInfo[2]);
            map.get(u).add(new Node(v, w));
            // map.get(v).add(new Node(u, w));
        }
        return map;
    }

    private static Map<Integer, Integer> dijkstra(Map<Integer, List<Node>> map, int start) {
        Map<Integer, Integer> distances = new HashMap<>();

        for (Integer key : map.keySet()) {
            distances.put(key, Integer.MAX_VALUE);
        }

        // 초기값 세팅
        distances.put(start, 0);

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(start, distances.get(start)));

        // 다익스트라 탐색 시작
        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            int currentNode = node.target;
            int currentDistance = node.distance;

            if (distances.get(currentNode) < currentDistance) {
                continue;
            }
            List<Node> nodes = map.get(currentNode);

            for (Node adjacencyNode : nodes) {
                int target = adjacencyNode.target;
                int distance = adjacencyNode.distance;

                int newShortestDistance = currentDistance + distance;

                if (newShortestDistance < distances.get(target)) {
                    distances.put(target, newShortestDistance);
                    priorityQueue.add(new Node(target, newShortestDistance));
                }
            }
        }
        return distances;
    }

    private static void printResult(Map<Integer, Integer> visitedNodeMap) {
        for (Integer key : visitedNodeMap.keySet()) {
            Integer result = visitedNodeMap.get(key);
            if (result == Integer.MAX_VALUE) {
                System.out.println("INF");
                continue;
            }
            System.out.println(result);
        }
    }

    static class Node implements Comparable<Node> {

        int target;
        int distance;

        public Node(int target, int distance) {
            this.target = target;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node node) {
            return this.distance - node.distance;
        }
    }
}
