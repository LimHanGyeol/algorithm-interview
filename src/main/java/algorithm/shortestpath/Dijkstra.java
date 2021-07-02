package algorithm.shortestpath;

import algorithm.structure.heap.Edge;

import java.util.*;

public class Dijkstra {

    public static void main(String[] args) {
        Map<String, List<Edge>> graph = initGraph();
        Map<String, Integer> findPath = findShortestPath(graph, "A");
        System.out.println(findPath);
    }

    private static Map<String, Integer> findShortestPath(Map<String, List<Edge>> graph, String start) {
        Map<String, Integer> distances = new HashMap<>();
        for (String key : graph.keySet()) {
            distances.put(key, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(distances.get(start), start));

        while (!priorityQueue.isEmpty()) {
            Edge node = priorityQueue.poll();
            String currentNode = node.getVertex();
            int currentDistance = node.getDistance();

            if (distances.get(currentNode) < currentDistance) {
                continue;
            }

            List<Edge> edges = graph.get(currentNode);
            for (Edge adjacentEdge : edges) {
                String adjacentNode = adjacentEdge.getVertex();
                int adjacentDistance = adjacentEdge.getDistance();

                int resultDistance = currentDistance + adjacentDistance;

                if (resultDistance < distances.get(adjacentNode)) {
                    distances.put(adjacentNode, resultDistance);
                    priorityQueue.add(new Edge(resultDistance, adjacentNode));
                }
            }
        }
        return distances;
    }

    private static Map<String, List<Edge>> initGraph() {
        Map<String, List<Edge>> graph = new HashMap<>();
        graph.put("A", Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D")));
        graph.put("B", new ArrayList<>());
        graph.put("C", Arrays.asList(new Edge(5, "B"), new Edge(2, "D")));
        graph.put("D", Arrays.asList(new Edge(3, "E"), new Edge(5, "F")));
        graph.put("E", Arrays.asList(new Edge(1, "F")));
        graph.put("F", Arrays.asList(new Edge(5, "A")));
        return graph;
    }
}
