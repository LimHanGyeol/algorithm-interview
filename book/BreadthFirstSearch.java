import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 자바로 쉽게 배우는 알고리즘
// Breadth First Search
//       2
//    /  |
//  /    |
// 1 --- 3 --- 4
//  \    | \   |
//    \  |   \ |
//       5     6
class Solution {

    public static void main(String args) {
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

        System.out.println("result");
        breadthFirstSearch(nodes[0]); // 1 2 3 5 4 6
    }

    /**
     * 너비 우선 탐색의 시간 복잡도는 깊이 우선 탐색과 같다.
     * 즉 그래프가 인접 목록으로 표현되어 있으면 시간 복잡도는 O(V + E) 이고,
     * 그래프가 인접 행렬로 주어진다면 O(V^2) 이다.
     */
    private void breadthFirstSearch(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        node.setVisited(true);

        while (!queue.isEmpty()) {
            // 큐의 맨 앞에 있는 노드(인접노드)를 꺼낸다.
            Node firstNode = queue.poll();
            System.out.print(firstNode.getNode() + " ");

            // 꺼낸 노드의 인접 노드를 가져온다.
            List<Node> adjacentNodes = firstNode.getAdjacentNodes();

            // 꺼낸 노드의 인접 노드 중 방문하지 않은 모든 노드에 대해 너비 우선 탐색을 한다.
            for (Node adjacentNode : adjacentNodes) {
                if (adjacentNode != null && !adjacentNode.isVisited()) {
                    adjacentNode.setVisited(true);
                    queue.offer(adjacentNode);
                }
            }

        }

    }

}
