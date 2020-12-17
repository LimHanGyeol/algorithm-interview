// 자바로 쉽게 배우는 알고리즘
// Topological Sort (위상 정렬)
//                        2
//                    /-* | --\
//                /--     |     --\
//              /         *         *
// 0  -------* 1 -------* 4 -------* 6 ------* 7
//   \                   *          *         *
//     -\               /       --/          /
//        \           /       /          --/
//         *3 -----------* 5 ----------/
class Solution {

    public static void main(String[] args) {
        Node[] nodes = new Node[8];
        int size = nodes.length;

        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }

        nodes[0].addAdjacentNodes(nodes[1]);
        nodes[0].addAdjacentNodes(nodes[3]);

        nodes[1].addAdjacentNodes(nodes[2]);
        nodes[1].addAdjacentNodes(nodes[4]);

        nodes[2].addAdjacentNodes(nodes[4]);
        nodes[2].addAdjacentNodes(nodes[6]);

        nodes[3].addAdjacentNodes(nodes[4]);
        nodes[3].addAdjacentNodes(nodes[5]);

        nodes[4].addAdjacentNodes(nodes[6]);

        nodes[5].addAdjacentNodes(nodes[6]);
        nodes[5].addAdjacentNodes(nodes[7]);

        nodes[6].addAdjacentNodes(nodes[7]);

        System.out.println("result");
        nodes[0].setVisited(true);

        Stack<Node> stack = new Stack<>();

        topologicalSort(stack, nodes[0]);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " "); // 0 3 5 1 2 4 6 7
        }

    }

    /**
     * 위상 정렬의 시간 복잡도는 깊이 우선 탐색과 같다.
     * 그래프가 인접 목록으로 표현된다면 시간 복잡도는 O(V + E) 이다.
     */
    private void topologicalSort(Stack<Node> stack, Node node) {
        // 기준 노드의 인접 노드를 가져온다.
        List<Node> adjacentNodes = node.getAdjacentNodes();

        // 기준 노드의 인접노드에 대해 DFS를 한다.
        for (Node adjacentNode : adjacentNodes) {
            if (adjacentNode != null && !adjacentNode.isVisited()) {
                adjacentNode.setVisited(true);
                topologicalSort(stack, adjacentNode);
            }
        }

        stack.push(node);
    }

}
