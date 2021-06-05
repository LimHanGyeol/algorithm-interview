package algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;

import static algorithm.util.InputReader.init;

/**
 * 이것이 취업을 위한 코딩 테스트다 with Python
 * Java
 * <p>
 * 왕실의 나이트
 * 시간 제한 1초, 메모리 제한 128MB
 * Input
 * - 첫째 줄에 8 * 8 좌표 평면상에서 현재 나이트가 위치한 곳의 좌표를 나타내는
 * 두 문자로 구성된 문자열이 입력된다. 입력 문자는 a1 처럼 열과 행으로 이뤄진다.
 * Output
 * - 첫째 줄에 나이트가 이동할 수 있는 경우의 수를 출력하라.
 * <p>
 * Ex
 * Input : a1
 * Output : 2
 */
public class RoyalNight {

    private static final int[] DIRECTIONS_X = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
    private static final int[] DIRECTIONS_Y = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        String input = bufferedReader.readLine();
        int row = input.charAt(1) - '0';
        int column = input.charAt(0) - 'a' + 1;

        int result = 0;
        for (int i = 0; i < 8; i++) {
            // 이동하고자 하는 위치 확인
            int nextRow = row + DIRECTIONS_X[i];
            int nextColumn = column + DIRECTIONS_Y[i];
            // 해당 위치로 이동이 가능하다면 카운트 증가
            if (nextRow >= 1 && nextRow <= 8 && nextColumn >= 1 && nextColumn <= 8) {
                result += 1;
            }
        }
        System.out.println(result);
    }

}
