package algorithm.structure.heap;

public class Edge implements Comparable<Edge> {

    private final int distance;
    private final String vertex;

    public Edge(int distance, String vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }

    public int getDistance() {
        return distance;
    }

    public String getVertex() {
        return vertex;
    }

    @Override
    public int compareTo(Edge edge) {
        return this.getDistance() - edge.getDistance();
    }

    @Override
    public String toString() {
        return "Edge{" +
                "distance=" + distance +
                ", vertex='" + vertex + '\'' +
                '}';
    }
}
