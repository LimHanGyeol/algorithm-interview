package algorithm.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * 이것이 취업을 위한 코딩 테스트다 with Python
 * Java
 *
 * 두 배열의 원소 교체
 * 시간제한 2초, 메모리 제한 128MB
 * Input
 * - 첫 번째 줄에서 N, K가 공백을 기준으로 구분되어 입려된다. (1 <= N <= 100_000, 0 <= K <= N)
 * - 두 번째 줄에 배열 A의 원소들이 공백을 기준으로 구분되어 입력된다.
 *   모든 원소는 10_000_000보다 작은 자연수이다.
 * - 세 번째 줄에 배열 B의 원소들이 공백을 기준으로 구분되어 입력된다.
 *   모든 원소는 10_000_000보다 작은 자연수이다.
 * Output
 * - 최대 K번의 바꿔치기 연산을 수행하여 만들 수 있는 배열 A의 모든 원소의 합의 최대값 출력하라
 *
 * Ex
 * Input
 * 5 3
 * 1 2 5 4 3
 * 5 5 6 6 5
 * Output - 26
 */
public class ReplaceElementsTwoArray {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();

        String[] input = bufferedReader.readLine().split(" ");
        int n = toInt(input[0]);
        int k = toInt(input[1]);

        // 배열 A의 모든 원소 입력
        Integer[] arrayA = initIntArray(bufferedReader.readLine());
        Integer[] arrayB = initIntArray(bufferedReader.readLine());

        // Arrays.sort의 매개변수 타입은 T[] 이다. 래퍼 타입을 고려하자.
        Arrays.sort(arrayA); // 오름차순
        Arrays.sort(arrayB, Collections.reverseOrder()); // 내림차순

        // 첫 번째 인덱스부터 확인하며, 두 배열의 원소를 최대 K번 비교
        for (int i = 0; i < k; i++) {
            // A의 원소가 B의 원소보다 작은 경우
            if (arrayA[i] < arrayB[i]) {
                // 두 원소 교체
                int swap = arrayA[i];
                arrayA[i] = arrayB[i];
                arrayB[i] = swap;
                continue;
            }
            break; // A의 원소가 B의 원소보다 크거나 같을 때 반복문 탈출
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            result += arrayA[i];
        }
        System.out.println(result);
    }

    private static Integer[] initIntArray(String inputArray) {
        String[] array = inputArray.split(" ");
        int length = array.length;
        Integer[] numbers = new Integer[length];

        for (int i = 0; i < length; i++) {
            numbers[i] = toInt(array[i]);
        }
        return numbers;
    }
}
