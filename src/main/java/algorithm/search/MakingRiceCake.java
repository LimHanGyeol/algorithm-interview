package algorithm.search;

import java.io.BufferedReader;
import java.io.IOException;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * 이것이 취업을 위한 코딩 테스트다 with Python
 * Java
 * <p>
 * 떡볶이 떡 만들기
 * 시간제한 2초, 메모리 제한 128MB
 * Input
 * - 첫 번째 줄에 떡의 개수 N과 요청한 떡의 길이 M이 주어진다.
 * - (1 <= N <= 1_00_000, 1<= M <= 2_000_000_000)
 * - 두 번째 줄에는 떡의 개별 높이가 주어진다. 떡 높이의 총합은 항상 M 이상이다.
 * - 손님은 필요한 양만큼 떡을 사갈 수 있다. 높이는 10억보다 작거나 같은 양의 정수 혹은 0이다.
 * Output
 * - 적어도 M 만큼의 떡을 집에 가져가기 위해 절단기에 설정할 수 있는 높이의 최대값을 출력하라.
 * <p>
 * Ex
 * Input
 * - 4 6
 * - 19 15 10 17
 * Output : 15
 */
public class MakingRiceCake {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();

        // 떡의 개수 n과 요청한 떡이 길이 m
        String[] input = bufferedReader.readLine().split(" ");
        int n = toInt(input[0]);
        int m = toInt(input[1]);

        // 각 떡의 개별 높이 정보
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = toInt(bufferedReader.readLine());
        }

        // 이진 탐색을 위해 시작점과 끝점 설정
        int start = 0;
        int end = (int) 2e9;
        // 이진 탐색
        int result = 0;
        while (start <= end) {
            long total = 0;
            int mid = (start + end) / 2;

            for (int i = 0; i < n; i++) {
                // 잘랐을 때의 떡 양 계산
                if (array[i] > mid) {
                    total += array[i] - mid;
                }
            }
            if (total < m) { // 떡의 양이 부족한 경우 더 많이 자르기 (왼쪽 부분 탐색)
                end = mid - 1;
            } else { // 떡의 양이 충분한 경우 덜 자르기 (오른쪽 부분 탐색)
                result = mid; // 최대한 덜 잘랐을 때가 정답
                start = mid + 1;
            }
        }
        System.out.println(result);
    }
}
