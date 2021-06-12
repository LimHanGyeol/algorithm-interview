package algorithm.structure;

/**
 * 조합
 */
public class Combination {

    private static int number;

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4};
        int n = array.length;
        int[] output = new int[n];
        boolean[] visited = new boolean[n];
        int start = 0;
        int r = 0;
        combination(array, output, visited, start, n, r);
    }

    private static void combination(int[] array, int[] output, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    System.out.println(array[i] + " ");
                }
            }
            number++;
            System.out.println("- " + number + "번째일 경우");
            return;
        }
        // combination을 재귀호출 할 때 start + 1을 하면
        // 1, 2를 뽑은 후 2, 1 처럼 역순으로 호출하게 되는 경우가 사라진다.
        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(array, output, visited, i + i, n, r - 1);
                visited[i] = false;
            }
        }
    }

    private void duplicateCombination(int[] array, int[] output, boolean[] visited, int start, int n, int r, int count) {
        if (count == r) {
            for (int i = 0; i < count; i++) {
                System.out.print(output[i] + " ");
            }
            number++;
            System.out.println(" - " + number + "번째의 경우");
            return;
        }
        for (int i = start - 1; i < n; i++) {
            visited[i] = true;
            output[count] = array[i];
            duplicateCombination(array, output, visited, i + 1, n, r, count + 1);
            visited[i] = false;
        }
    }
}
