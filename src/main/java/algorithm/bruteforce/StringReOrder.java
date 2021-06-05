package algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static algorithm.util.InputReader.init;

/**
 * 이것이 취업을 위한 코딩 테스트다 with Python
 * Java
 * <p>
 * 문자열 재정렬
 * 시간제한 1초, 메모리 제한 128MB
 * Input
 * - 첫째 줄에 하나의 문자열 S가 주어진다. (1 <= S.length <= 10_000)
 * Output
 * - 첫째 줄에 문제에서 요구하는 정답을 출력한다.
 * <p>
 * Ex
 * Input : K1KA5CB7
 * Output : ABCKK13
 * <p>
 * Input : AJKDLSI412K4JSJ9D
 * Output : ADDIJJJKKLSS20
 */
public class StringReOrder {

    private static final List<Character> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        String input = bufferedReader.readLine();

        // 문자를 하나씩 확인
        int value = 0;
        for (int i = 0; i < input.length(); i++) {
            // 알파벳인 경우 결과 리스트에 삽입
            if (Character.isLetter(input.charAt(i))) {
                results.add(input.charAt(i));
            } else { // 숫자는 따로 더하기
                value += input.charAt(i) - '0';
            }
        }

        // 알파벳 오름차순 정렬
        Collections.sort(results);

        // 알파벳 출력
        for (Character result : results) {
            System.out.print(result);
        }

        // 숫자가 하나라도 존재하는 경우 가장 뒤에 출력
        if (value != 0) {
            System.out.print(value);
        }
    }
}
