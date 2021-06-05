package algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * 이것이 취업을 위한 코딩 테스트다 with Python
 * Java
 * <p>
 * 시각
 * 시간제한 2초, 메모리 제한 128MB
 * Input
 * - 첫째 줄에 정수 n이 입력된다. (0 <= n <= 23)
 * Output
 * - 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서
 * 3이 하나라도 포함되는 모든 경우의 수를 출력하라.
 * <p>
 * Ex
 * Input : 5
 * Output : 11475
 */
public class Hour {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        int hour = toInt(bufferedReader.readLine());
        int count = 0;

        for (int i = 0; i <= hour; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    // 매 시각 안에 3이 포함되어 있으면 카운트 증가
                    if (checkHour(i, j, k)) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }

    // 특정한 시각 안에 3이 포함되어 있는지 확인
    private static boolean checkHour(int hour, int minute, int second) {
        return hour % 10 == 3 || minute / 10 == 3 || minute % 10 == 3 || second / 10 == 3 || second % 10 == 3;
    }
}
