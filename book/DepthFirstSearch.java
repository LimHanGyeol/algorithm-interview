import java.util.List;

// 자바로 쉽게 배우는 알고리즘
// Depth First Search
//       2
//    /  |
//  /    |
// 1 --- 3 --- 4
//  \    | \   |
//    \  |   \ |
//       5     6
class Solution {

    public static void main(String[] args) {
        Node[] nodes = new Node[6];
        int size = nodes.length;

        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i + 1);
        }

        // 그래프 세팅
        nodes[0].addAdjacentNodes(nodes[1]);
        nodes[0].addAdjacentNodes(nodes[2]);
        nodes[0].addAdjacentNodes(nodes[4]);

        nodes[1].addAdjacentNodes(nodes[0]);
        nodes[1].addAdjacentNodes(nodes[2]);

        nodes[2].addAdjacentNodes(nodes[0]);
        nodes[2].addAdjacentNodes(nodes[1]);
        nodes[2].addAdjacentNodes(nodes[3]);
        nodes[2].addAdjacentNodes(nodes[4]);

        nodes[3].addAdjacentNodes(nodes[2]);
        nodes[3].addAdjacentNodes(nodes[5]);

        nodes[4].addAdjacentNodes(nodes[0]);
        nodes[4].addAdjacentNodes(nodes[2]);

        nodes[5].addAdjacentNodes(nodes[2]);
        nodes[5].addAdjacentNodes(nodes[3]);

        System.out.print("result : ");
        depthFirstSearch(nodes[0]); // 1 2 3 4 6 5
    }

    /**
     * 깊이 우선 탐색은 주어진 그래프가 인접 목록으로 표현되어 있으면,
     * 각 노드를 한번 방문하고 각 간선도 두 번 고려되기 때문에
     * 시간 복잡도는 O(V + E) 이다. V (Vertex == Node)
     * 하지만 그래프가 인접 행렬로 주어진다면 시간 복잡도는 O(V^2) 이다.
     */
    private void depthFirstSearch(Node node) {
        System.out.print(node.getNode() + " ");

        node.setVisited(true);

        List<Node> adjacentNodes = node.getAdjacentNodes();

        for (Node adjacentNode : adjacentNodes) {
            if (adjacentNode != null && !adjacentNode.isVisited()) {
                depthFirstSearch(adjacentNode);
            }
        }

    }

}
