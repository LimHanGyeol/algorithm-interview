/**
 * 쉽게 풀어보는 코딩 테스트 기출문제
 * Graph - NumberOfIsland(DFS)
 * Given a 2d grid map of '1's (land) and '0's (water),
 * count the number of islands.
 * An island is surrounded by water and
 * is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */
class Solution {

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '0', '1'},
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '0', '0', '1'}
        };
        System.out.println(numberOfIsland(grid)); // 3
    }

    private int numberOfIsland(char[][] grid) {
        int count = 0;
        int lineLength = grid.length;

        if (grid == null || grid.length == 0) {
            return 0;
        }

        for (int i = 0; i < lineLength; i++) { // 행
            for (int j = 0; j < grid[i].length; j++) { // 열
                if (grid[i][j] == '1') {
                    count++;
                    searchIsland(grid, i, j);
                }
            }
        }
        return count;
    }

    private void searchIsland(char[][] grid, int i, int j) {
        int lineLength = grid.length;
        int columnLength = grid[0].length;

        if (i < 0 || i >= lineLength ||
            j < 0 || j >= columnLength ||
            grid[i][j] != '1') {
                return;
        }

        grid[i][j] = 'X';
        searchIsland(grid, i - 1, j);
        searchIsland(grid, i + 1, j);
        searchIsland(grid, i, j - 1);
        searchIsland(grid, i, j + 1);
    }

}
