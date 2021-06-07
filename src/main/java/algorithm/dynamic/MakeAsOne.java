package algorithm.dynamic;

import java.io.BufferedReader;
import java.io.IOException;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * 이것이 취업을 위한 코딩 테스트다 with Python
 * Java
 * <p>
 * 1로 만들기
 * 시간제한 1초, 메모리 제한 128MB
 * Input
 * - 첫째 줄에 정수 x가 주어진다. (1 <= x <= 30_000)
 * Output
 * - 첫째 줄에 연산을 하는 횟수의 최소값을 출력한다.
 * <p>
 * Ex
 * Input : 26
 * Output : 3
 */
public class MakeAsOne {

    private static final int[] cache = new int[30001];

    /**
     * 최적 부분 구조와 중복되는 부분 문제를 만족한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();

        int x = toInt(bufferedReader.readLine());

        // Dynamic Programming 진행 (Bottom - Up)
        for (int i = 2; i <= x; i++) {
            // 현재의 수에서 1을 빼는 경우
            cache[i] = cache[i - 1] + 1;
            // 현재의 수가 2로 나누어 떨어지는 경우
            if (i % 2 == 0) {
                cache[i] = Math.min(cache[i], cache[i / 2] + 1);
            }
            if (i % 3 == 0) {
                cache[i] = Math.min(cache[i], cache[i / 3] + 1);
            }
            if (i % 5 == 0) {
                cache[i] = Math.min(cache[i], cache[i / 5] + 1);
            }
        }
        System.out.println(cache[x]);
    }
}
