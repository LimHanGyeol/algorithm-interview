package algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;

import static algorithm.util.InputReader.init;

/**
 * 이것이 취업을 위한 코딩 테스트다 with Python
 * Java
 *
 * 곱하기 혹은 더하기
 * 시간제한 1초, 메모리 제한 128MB
 * Input
 * - 첫째 줄에 여러 개의 숫자로 구성된 하나의 문자열 S가 주어진다.
 * - (1 <= S의 길이 <= 20)
 * Output
 * - 첫째 줄에 만들어질 수 있는 가장 큰 수를 출력한다.
 *
 * Ex
 * Input : 02984
 * Output : 576
 *
 * Input : 567
 * Output : 210
 */
public class MultiplyOrAdd {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        String input = bufferedReader.readLine();

        long result = input.charAt(0) - '0'; // String 값에 아스키 코드 0을 제거하여 숫자 값으로 만든다.
        for (int i = 1; i < input.length(); i++) {
            // 두 수 중에서 하나라도 0, 1인 경우 더하기를 수행한다.
            int number = input.charAt(i) - '0';
            if (number <= 1 || result <= 1) {
                result += number;
            } else {
                result *= number;
            }
        }
        System.out.println(result);
    }
}
