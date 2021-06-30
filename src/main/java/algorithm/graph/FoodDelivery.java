package algorithm.graph;

import java.util.*;

/**
 * Programmers
 * Level2 - 다익스트라
 * 배달
 */
public class FoodDelivery {

    public int solution(int N, int[][] road, int K) {
        Map<Integer, List<Node>> map = initMap(N, road);

        Map<Integer, Integer> visitedVillage = findVisitedVillage(map, 1);

        return getCount(K, visitedVillage);
    }

    private Map<Integer, List<Node>> initMap(int n, int[][] road) {
        Map<Integer, List<Node>> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] village : road) {
            if (map.containsKey(village[0])) {
                map.get(village[0]).add(new Node(village[1], village[2]));
                map.get(village[1]).add(new Node(village[0], village[2]));
            }
        }
        return map;
    }

    private Map<Integer, Integer> findVisitedVillage(Map<Integer, List<Node>> map, int start) {
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
            Node node = priorityQueue.poll(); // 1, 0
            Integer currentVillage = node.getTarget(); // 1
            int currentDistance = node.getDistance(); // 0

            if (distances.get(currentVillage) < currentDistance) {
                continue;
            }

            List<Node> adjacentVillages = map.get(currentVillage);

            for (Node adjacentVillage : adjacentVillages) {
                Integer village = adjacentVillage.getTarget();
                int distance = adjacentVillage.getDistance();

                int resultDistance = currentDistance + distance;

                if (resultDistance < distances.get(village)) {
                    distances.put(village, resultDistance);
                    priorityQueue.add(new Node(village, resultDistance));
                }
            }
        }

        return distances;
    }

    private int getCount(int K, Map<Integer, Integer> visitedVillage) {
        int count = 0;
        for (int value : visitedVillage.values()) {
            if (value <= K) {
                count++;
            }
        }

        return count;
    }

    static class Node implements Comparable<Node> {

        private final int target;
        private final int distance;

        public Node(int target, int distance) {
            this.target = target;
            this.distance = distance;
        }

        public int getTarget() {
            return target;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.getDistance();
        }
    }
}
