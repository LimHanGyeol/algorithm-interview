import java.io.*;
import java.util.*;
/**
 * 백준
 * Graph - 블록 번호 붙이기
 */
class Main {

    private static int houseNumber = 0; // DFS 일 경우 사용
    private static final int[][] directions = new int[][] {
        {-1, 0}, {1, 0}, {0, 1}, {0, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(bufferedReader.readLine());
        if (size >= 4 && size <= 25) {
            int[][] apartmentBlock = new int[size][size];

            for (int i = 0; i < size; i++) {
                String[] rows = bufferedReader.readLine().split("");
                for (int j = 0; j < rows.length; j++) {
                    apartmentBlock[i][j] = Integer.parseInt(rows[j]);
                }
            }

            List<Integer> apartmentNumbers = new ArrayList<>();
            int blockCount = calculate(apartmentBlock, apartmentNumbers);
            System.out.println(blockCount);

            Collections.sort(apartmentNumbers);
            for (int number : apartmentNumbers) {
                System.out.println(number);
            }
        }
    }

    private static int calculate(int[][] apartmentBlock, List<Integer> apartmentNumbers) {
        if (apartmentBlock == null || apartmentBlock.length == 0) {
            return 0;
        }

        int houseCount = 0;
        for (int i = 0; i < apartmentBlock.length; i++) {
            for (int j = 0; j < apartmentBlock[0].length; j++) {
                if (apartmentBlock[i][j] == 1) {
                    houseCount++;
                    int result = searchApartmentBlockBFS(apartmentBlock, i, j);
                    // searchApartmentBlockDFS(apartmentBlock, i, j); // DFS
                    apartmentNumbers.add(result); // BFS
                    // apartmentNumbers.add(houseNumber); // DFS
                    // houseNumber = 0; // DFS
                }
            }
        }
        return houseCount;
    }

    private static int searchApartmentBlockBFS(int[][] apartmentBlock, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        int apartmentCount = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] point queue.poll();

            for (int line = 0; line < size; line++) {
                for (int[] direction : directions) {
                    int x = point[0] + direction[0];
                    int y = point[1] + direction[1];
                    if (x >= 0 && y >= 0
                        && x < apartmentBlock.length
                        && y < apartmentBlock[0].length
                        && apartmentBlock[x][y] == 1) {

                        apartmentBlock[x][y] = 0;
                        queue.offer(new int[]{x, y});
                        apartmentCount++;
                    }
                }
            }
        }
        if (apartmentCount == 0) { // 상하좌우에 인접한 아파트가 없을 경우
            return 1;
        }
        return apartmentCount;
    }

    private static void searchApartmentBlockDFS(int[][] apartmentBlock, int x, int y) {
        if (x < 0 || x >= block.length ||
            y < 0 || y >= block[0].length ||
            block[x][y] != 1) {
            return;
        }
        block[x][y] = 0;
        houseNumber++;
        searchApartmentBlockDFS(block, x - 1, y);
        searchApartmentBlockDFS(block, x + 1, y);
        searchApartmentBlockDFS(block, x, y - 1);
        searchApartmentBlockDFS(block, x, y + 1);
    }

}
