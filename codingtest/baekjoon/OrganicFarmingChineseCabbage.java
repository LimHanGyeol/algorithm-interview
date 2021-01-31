import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 백준
 * Graph - 유기농 배추. 1012
 */
class Main {

    private static final int[][] directions = new int[][]{
        {-1, 0}, {1, 0}, {0, 1}, {0, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNumber = Integer.parseInt(bufferedReader.readLine());

        for (int testCase = 0; testCase < testCaseNumber; testCase++) {
            String[] input = bufferedReader.readLine().split(" ");
            int width = Integer.parseInt(input[0]);
            int height = Integer.parseInt(input[1]);
            int node = Integer.parseInt(input[2]);

            int[][] farms = new int[width][height];

            for (int edge = 0; edge < node; edge++) {
                String[] inputEdges = bufferedReader.readLine().split(" ");
                int x = Integer.parseInt(inputEdges[0]);
                int y = Integer.parseInt(inputEdges[1]);

                farms[x][y] = 1;
            }

            System.out.println(calculate(farms));
        }
    }

    private static int calculate(int[][] farms) {
        int (farms.length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < farms.length; i++) {
            for (int j = 0; j < farms[i].length; j++) {
                if (farms[i][j] == 1) {
                    count++;
                    searchFarmsBfs(farms, i, j);
                }
            }
        }
        return count;
    }

    private static void searchFarmsBfs(int[][] farms, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] point = queue.poll();

            for (int line = 0; line < size; line++) {
                for (int[] direction : directions) {
                    int x = point[0] + direction[0];
                    int y = point[1] + direction[1];
                    if (x >= 0 && y >= 0 && x < farms.length && y < farms[0].length &&
                        farms[x][y] == 1) {
                        farms[x][y] = 0;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
    }

    private static void searchFarmsDfs(int[][] farms, int x, int y) {
        int lineLength = farms.length;
        int columnLength = farms[0].length;

        if (x < 0 || x >= lineLength ||
                y < 0 || y >= columnLength ||
                farms[x][y] != 1) {
            return;
        }

        farms[x][y] = 0;
        searchFarmsDfs(farms, x - 1, y);
        searchFarmsDfs(farms, x + 1, y);
        searchFarmsDfs(farms, x, y - 1);
        searchFarmsDfs(farms, x, y + 1);
    }

}
