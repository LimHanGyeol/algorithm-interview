import java.util.*;

/**
 * 프로그래머스
 * Level1
 * K 번째 수
 */
class Solution {

    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };
        System.out.println(Arrays.toString(getKNumber(array, commands)));
    }

    private int[] getKNumber(int[] array, int[][] commands) {
        return findElements(array, commands);
    }

    private int[] findElements(int[] array, int[][] commands) {
        int length = commands.length;

        int[] results = new int[length];

        for (int i = 0; i < length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int number = commands[i][2] - 1;

            List<Integer> cutList = cutArray(array, start, end);
            int kNumber = cutList.get(number);

            results[i] = kNumber;
        }
        return results;
    }

    private List<Integer> cutArray(int[] array, int start, int end) {
        List<Integer> cutList = new ArrayList<>();

        for (int cuttingNumber = start; cuttingNumber <= end; cuttingNumber++) {
            cutList.add(array[cuttingNumber]);
        }

        Collections.sort(cutList);
        return cutList;
    }

    /**
    * 모범 답안 - quick sort
    */
    private int[] kNumber(int[] array, int[][] commands) {
        int n = 0;
        int[] ret = new int[commands.length];

        while (n < commands.length) {
            int m = commands[n][1] - commands[n][0] + 1;

            if (m == 1) {
                ret[n] = array[commands[n++][0] - 1];
                continue;
            }

            int[] a = new int[m];
            int j = 0;
            for (int i = commands[n][0] - 1; i < commands[n][1]; i++)
                a[j++] = array[i];

            sort(a, 0, m - 1);

            ret[n] = a[commands[n++][2] - 1];
        }

        return ret;
    }

    void sort(int[] a, int left, int right) {
        int pl = left;
        int pr = right;
        int x = a[(pl + pr) / 2];

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;
            if (pl <= pr) {
                int temp = a[pl];
                a[pl] = a[pr];
                a[pr] = temp;
                pl++;
                pr--;
            }
        } while (pl <= pr);

        if (left < pr) sort(a, left, pr);
        if (right > pl) sort(a, pl, right);
    }

}
