package algorithm.dynamic;

import java.io.BufferedReader;
import java.io.IOException;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * 이것이 취업을 위한 코딩 테스트다 with Python
 * Java
 * <p>
 * 개미 전사
 * 시간제한 1초, 메모리 제한 128MB
 * Input
 * - 첫째 줄에 식량 창고의 개수 N이 주어진다. (3 <= n <= 100)
 * - 둘째 줄에 공백을 기준으로 식량 창고에 저장된 식량의 개수 k가 주어진다.
 * - (0 <= K <= 1_000)
 * Output
 * - 첫째 줄에 개미 전사가 얻을 수 있는 식량의 최대값을 출력하라.
 * <p>
 * Ex
 * Input
 * 4
 * 1 3 1 5
 * Output : 8
 */
public class AntWarrior {

    private static int[] cache = new int[100];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        int number = toInt(bufferedReader.readLine());

        // 모든 식량 정보 입력 받기
        int[] array = new int[number];
        String[] input = bufferedReader.readLine().split(" ");
        for (int i = 0; i < number; i++) {
            array[i] = toInt(input[i]);
        }

        // Dynamic Programming 진행 (Bottom - Up)
        cache[0] = array[0];
        cache[1] = Math.max(array[0], array[1]);
        for (int i = 2; i < number; i++) {
            cache[i] = Math.max(cache[i - 1], cache[i - 2] + array[i]);
        }
        System.out.println(cache[number - 1]);
    }
}
