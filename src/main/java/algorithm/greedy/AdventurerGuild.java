package algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * 이것이 취업을 위한 코딩 테스트다 with Python
 * Java
 * <p>
 * 모험가 길드
 * 시간제한 1초, 메모리 제한 128MB
 * Input
 * - 첫째 줄에 모험가의 수 N이 주어진다. (1 <= n <= 100_000)
 * - 둘째 주에 각 모험가의 공포도의 값을 n이하의 자연수로 주어지며, 각 자연수는 공백으로 구분한다.
 * Output
 * - 여행을 떠날 수 있는 그룹 수의 최대값을 출력하라.
 *
 * Ex
 * Input
 * 5
 * 2 3 1 2 2
 * Output : 2
 */
public class AdventurerGuild {

    private static int n;
    private static List<Integer> list = new ArrayList<>();

    /**
     * 오름차순 정렬 이후 공포도가 낮은 모험가로부터 하나씩 확인한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        n = toInt(bufferedReader.readLine());

        String[] fearRates = bufferedReader.readLine().split(" ");
        for (String fearRate : fearRates) {
            list.add(toInt(fearRate));
        }
        Collections.sort(list);

        int result = 0; // 총 그룹의 수
        int count = 0; // 현재 그룹에 포함된 모험가의 수
        for (int i = 0; i < n; i++) {
            count += 1;
            if (count >= list.get(i)) {
                result += 1;
                count = 0;
            }
        }
        System.out.println(result);
    }
}
