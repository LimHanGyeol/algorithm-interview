package algorithm.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * 이것이 취업을 위한 코딩 테스트다 with Python
 * Java
 * <p>
 * 효율적인 화폐 구성
 * 시간제한 1초, 메모리 제한 128MB
 * Input
 * - 첫째 줄에 n, m이 주어진다. (1 <= n <= 100, 1 <= m <= 10_000)
 * - 이후 n개의 줄에는 각 화폐의 가치가 주어진다.
 * - 화폐의 가치는 10_000 보다 작거나 같은 자연수이다.
 * Output
 * - 첫째 줄에 최소 화폐 개수를 출력한다.
 * - 불가능 할때는 -1을 출력한다.
 * <p>
 * Ex
 * Input
 * 2 15
 * 2
 * 3
 * Output : 5
 * <p>
 * Input
 * 3 4
 * 3
 * 5
 * 7
 * Output : -1
 */
public class EfficientMonetaryComposition {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        String[] input = bufferedReader.readLine().split(" ");
        int n = toInt(input[0]);
        int m = toInt(input[1]);

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = toInt(bufferedReader.readLine());
        }

        int[] cache = new int[m + 1];
        Arrays.fill(cache, 10001);

        // Dynamic Programming 진행 (Bottom - Up)
        cache[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = array[i]; j <= m; j++) {
                // (i - k)원을 만드는 방법이 존재하는 경우
                if (cache[j - array[i]] != 10001) {
                    cache[j] = Math.min(cache[j], cache[j - array[i]] + 1);
                }
            }
        }
        if (cache[m] == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(cache[m]);
        }
    }
}
