/**
 * 자바로 쉽게 배우는 알고리즘
 * 탐욕 기법 - Prim 알고리즘 (Greedy - Prim Algorithms)
 * 최소 비용 신장 트리 (MST, Minimum Spanning Tree)
 */
 class Solution {

    private static final int X = 9999;

    public static void main(String[] args) {
        int[][] graph = new int[][] {
                {0, 2, X, X, 4},
                {2, 0, 8, X, 4},
                {X, 8, 0, 7, 6},
                {X, X, 7, 0, 3},
                {4, 4, 6, 3, 0}
        };
        prim(graph, 5);
    }

    /**
     * Prim 알고리즘의 시간 복잡도는 O(n^2) 이다.
     * @param graph 비방향 가중 그래프
     * @param n 입력의 크기. 그래프 내의 정점들의 수
     */
    private void prim(int[][] graph, int n) {
        int[] redNodes = new int[n];
        boolean[] blueNodes = new boolean[n];

        // 정점 0을 적색 정점으로 초기화 한다.
        blueNodes[0] = false;
        int newRedNode = 0;

        // 정점 0을 제외한 모든 정점을 청색으로 초기화 한다.
        for (int i = 1; i < n; i++) {
            blueNodes[i] = true;
        }

        // 각 반복에서 한 적색 정점과 한 청색 정점을 연결하는
        // 가장 가중치가 작은 간선을 선택한 후 그 간선을 최소 비용 신장 트리에 추가한다.
        for (int i = 1; i <= n - 1; i++) {
            int minEdge = X;

            // 적색 정점들에 가장 가까운 청색 정점을 찾는다.
            for (int blueNode = 0; blueNode < n; blueNode++) {
                if (blueNodes[blueNode]) {
                    if (graph[blueNode][redNodes[blueNode]] < minEdge) {
                        minEdge = graph[blueNode][redNodes[blueNode]];
                        newRedNode = blueNode;
                    }
                }
            }

            // 위에서 적색 정점들에서 가장 가까운 청색 정점을 찾았다.
            // 해당 청색 정점을 적색으로 변경한다.
            blueNodes[newRedNode] = false;

            // 최소 비용 신장 트리에 새롭게 추가된 간선을 출력한다.
            print(redNodes, newRedNode, graph);

            // 청색 정점에서
            // 가장 가까운 적색 정점을
            // 새롭게 적색이 된 정점을 반영하여 갱신한다.
            for (int b = 0; b < n; b++) {
                if (blueNodes[b]) {
                    if (graph[b][newRedNode] < graph[b][redNodes[b]]) {
                        redNodes[b] = newRedNode;
                    }
                }
            }

        }

    }

    private void print(int[] redNodes, int newRedNode, int[][] graph) {
        System.out.println(redNodes[newRedNode] + " - " + newRedNode + "\t " +
                graph[newRedNode][redNodes[newRedNode]]);
    }

 }
