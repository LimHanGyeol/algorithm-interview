import java.util.ArrayList;
import java.util.List;

// 자바로 쉽게 배우는 알고리즘
// Graph 알고리즘의 Node 클래스
public class Node {

    /**
     * 기준 노드
     */
    private final int node;

    /**
     * 방문 여부
     */
    private boolean visited;

    /**
     * 기준 노드에 인접한 노드목록
     */
    private final List<Node> adjacentNodes;

    public Node(int node) {
        this.node = node;
        this.visited = false;
        this.adjacentNodes = new ArrayList<>();
    }

    /**
     * 기준 노드에 인접한 노드를 저장한다.
     */
    public void addAdjacentNodes(Node adjacentNode) {
        this.adjacentNodes.add(adjacentNode);
    }

    public List<Node> getAdjacentNodes() {
        return adjacentNodes;
    }

    public int getNode() {
        return node;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "" + node;
    }

}
