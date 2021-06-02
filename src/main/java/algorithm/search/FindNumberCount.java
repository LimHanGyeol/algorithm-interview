package algorithm.search;

import java.io.BufferedReader;
import java.io.IOException;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * 이것이 취업을 위한 코딩 테스트다 with Python
 * Java
 * <p>
 * 정렬된 배열에서 특정 수의 개수 구하기
 * 시간제한 1초, 메모리 제한 128MB
 * Input
 * - 첫 번째 줄에 N과 x가 정수 형태로 공백으로 구분되어 입력된다.
 * - (1 <= n <= 1_000_000), (-10^9 <= x <= 10^9)
 * - 두 번째 줄에 N개의 원소가 정수 형태로 공백으로 구분되어 입력된다.
 * - (-10^9 <= 각 원소의 값 <= 10^9)
 * Output
 * - 수열의 원소 중에서 값이 x인 원소의 개수를 출력한다.
 * - 값이 x인 원소가 하나도 없다면 -1을 출력한다.
 * <p>
 * Ex
 * Input
 * - 7 2
 * - 1 1 2 2 2 2 3
 * Output : 4
 */
public class FindNumberCount {

    private static int lowerBound(int[] array, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (array[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    private static int upperBound(int[] array, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (array[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    // 값이 leftValue, rightValue인 데이터의 개수를 반환하는 함수
    private static int countByRange(int[] array, int leftValue, int rightValue) {
        // 유의 : lowerBound와 upperBound는 end 변수의 값을 배열의 길이로 설정한다.
        int rightIndex = upperBound(array, rightValue, 0, array.length);
        int leftIndex = lowerBound(array, leftValue, 0, array.length);
        return rightIndex - leftIndex;
    }

    /**
     * 시간 복잡도 O(logN)으로 동작하는 알고리즘을 요구하고 있다.
     * 선형 탐색으로 하면 시간 초과가 된다.
     * 하지만 데이터가 정렬되어 있기 때문에 이진 탐색을 수행할 수 있다.
     * 특정 값이 등장한느 첫 번째 위치와 마지막 위치를 찾아 위치 차이를 계산해 문제를 해결할 수 있다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();

        String[] input = bufferedReader.readLine().split(" ");
        int n = toInt(input[0]);
        int x = toInt(input[1]);

        int[] array = new int[n];
        String[] inputArray = bufferedReader.readLine().split(" ");
        for (int i = 0; i < inputArray.length; i++) {
            array[i] = toInt(inputArray[i]);
        }

        // 값이 x, x 범위에 있는 데이터의 개수 계산
        int count = countByRange(array, x, x);

        if (count == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(count);
    }

}
