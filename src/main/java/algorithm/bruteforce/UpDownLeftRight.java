package algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * 이것이 취업을 위한 코딩 테스트다 with Python
 * Java
 * <p>
 * 상하좌우
 * 시간제한 2초, 메모리 제한 128MB
 * Input
 * - 첫 번째 줄에 공간의 크기를 나타내는 N이 주어진다. (1 <= n <= 100)
 * - 두 번째 줄에 여행가 A가 이동할 계획서 내용이 주어진다. (1 <= 이동 횟수 <= 100)
 * Output
 * - 첫째 줄에 여행가 A가 최종적으로 도착할 지점의 좌표 x, y 를 공백을 기준으로 구분하려 출력한다.
 * <p>
 * Ex
 * Input
 * 5
 * R R R U D D
 * Output : 3 4
 */
public class UpDownLeftRight {

    // 좌우하상
    private static final int[] DIRECTION_X = new int[]{0, 0, -1, 1};// {1, -1, 0, 0};//
    private static final int[] DIRECTION_Y = new int[]{-1, 1, 0, 0};// {0, 0, -1, 1};//
    private static final char[] MOVE_TYPE = new char[]{'L', 'R', 'U', 'D'};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        int space = toInt(bufferedReader.readLine());
        String[] plans = bufferedReader.readLine().split(" ");

        int x = 1;
        int y = 1;

        for (int i = 0; i < plans.length; i++) {
            char plan = plans[i].charAt(0);
            // 이동 후 좌표 구하기
            int newX = -1;
            int newY = -1;
            for (int j = 0; j < 4; j++) {
                if (plan == MOVE_TYPE[j]) {
                    newX = x + DIRECTION_X[j];
                    newY = y + DIRECTION_Y[j];
                }
            }

            // 공간을 벗어나는 경우 무시
            if (newX < 1 || newY < 1 || newX > space || newY > space) {
                continue;
            }
            x = newX;
            y = newY;
        }
        System.out.println(x + " " + y);
    }
}
