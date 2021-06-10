package algorithm.structure;

/**
 * 순열
 */
public class Permutation {

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 1};
        int[] output = new int[array.length];
        boolean[] visited = new boolean[array.length];
        int n = array.length;
        int r = 3;

        permutation(array, output, visited, 0, n, r);
    }

    private static void permutation(int[] array, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            for (int i = 0; i < r; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = array[i];
                permutation(array, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

    // 중복 수열
    private static void duplicatePermutation(int[] array, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            for (int i = 0; i < r; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            output[depth] = array[i];
            duplicatePermutation(array, output, visited, depth + 1, n, r);
            visited[i] = false;
        }
    }
}
