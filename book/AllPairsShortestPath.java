// 자바로 쉽게 배우는 알고리즘
// 동적 계획법 (Dynamic Programming)
// 모든 쌍 최단 경로 찾기 (Floyd 알고리즘)
class Solution {

    public static final int INFINITE = 9999;

    public static void main(String[] args) {
        int[][] graph = {{0, INFINITE, 2, INFINITE},
                         {1, 0, INFINITE, INFINITE},
                         {INFINITE, 8, 0, 3},
                         {6, 4, INFINITE, 0}};

        findAllPairShortestPath(graph, 4);
        // 0 9 2 5
        // 1 0 3 6
        // 8 7 0 3
        // 5 4 7 0
    }

    /**
     * 모든 쌍 최단 경로 찾기 알고리즘은
     * 포털의 지도 서비스, 자동차 내비게이션 서비스,
     * 지리 정보 시스템, 통신 네트워크, 교통 공학, 산업 공학과 반도체 회로 설계 등에서
     * 광범위하게 활용되고 있다.
     */
    private void findAllPairShortestPath(int[][] graph, int n) {
        int[][] distance = new int[n][n];

        // 행렬 D를 가중치 행렬 graph 로 초기화 한다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = graph[i][j];
            }
        }

        // 모든 정점들을 한 번에 하나씩 중간 정점들의 집합에 추가한다.
        // 반복 전에는 최단 경로들은 {0, 1, 2, .. k - 1} 에 있는 정점들 만들 경우한다.
        // 반복 후에는 정점 k가 중간 정점들의 집합에 추가되고
        // 최단 경로들은 {0, 1, 2, .. k}에 있는 정점들 만을 경우한다.
        for (int k = 0; k < n; k++) {
            // 모든 정점들을 한 번에 하나씩 시작 정점으로 선택한다.
            for (int i = 0; i < n; i++) {
                // 모든 정점들을 위에서 선택된 시작 종점에 대한 목적지
                // 정점으로 선택한다.
                for (int j = 0; j < n; j++) {
                    // 정점 k가 정점 i에서 정점 j로 가는 최단 경로상에 있으면
                    // distance[i][j] 의 값을 그 경로의 거리로 갱신한다.
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }


        }
        // 최단 거리 행렬 distance 를 출력한다.
        printSolution(distance, n);
    }

    private void printSolution(int[][] dist, int n) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (dist[i][j] == INFINITE) {
                    System.out.print("INF : ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }


}
