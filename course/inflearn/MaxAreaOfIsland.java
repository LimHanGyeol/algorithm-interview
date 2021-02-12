/**
 * 쉽게 풀어보는 코딩 테스트 기출문제
 * Graph - DFS
 * MaxAreaOfIsland
 */
class Solution {

    private final int[][] directions = new int[][]{
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 1, 0, 1, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 0, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 1}
        };
        System.out.println(maxAreaOfIsland(grid)); // 8
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null == grid.length == 0) {
            return 0;
        }
        int rowLength = grid.length;
        int columnLength = grid[0].length;
        int max = 0;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (grid[i][j] == 1) {
                    int area = searchAreaOfIslandDfs(grid, i, j, 0);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    private int searchAreaOfIslandDfs(int[][] grid, int x, int y, int area) {
        if (x < 0 || x >= grid.length ||
            y < 0 || y >= grid[0].length ||
            grid[x][y] == 0) {
            return area;
        }
        grid[x][y] = 0;
        area++;

        for (int[] direction : directions) {
            area = searchAreaOfIslandDfs(grid, x + direction[0], y + direction[1], area);
        }
        return area;
    }

}
