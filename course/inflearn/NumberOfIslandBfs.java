/**
 * 쉽게 풀어보는 코딩 테스트 기출문제
 * Graph - NumberOfIsland(BFS)
 * Given a 2d grid map of '1's (land) and '0's (water),
 * count the number of islands.
 * An island is surrounded by water and
 * is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */
class Solution {

    private int[][] directions = new int[][]{
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
    };

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '0', '1'},
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '0', '0', '1'}
        };
        System.out.println(numberOfIsland(grid)); // 3
    }

    public int numberOfIsland(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    searchIsland(grid, i, j);
                }
            }
        }
        return count;
    }

    private void searchIsland(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] point = queue.poll();

            for (int line = 0; line < size; line++) {
                for (int[] direction : directions) {
                    int x = point[0] + direction[0];
                    int y = point[1] + direction[1];
                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == '1') {
                        grid[x][y] = '0';
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
    }

}
