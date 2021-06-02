package algorithm.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static algorithm.util.IntegerParser.toInt;

/**
 * 이진 탐색
 */
public class BinarySearch {

    // iterator
    private static int binarySearch(int[] array, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (array[mid] == target) { // 찾은 경우 중간 인덱스 반환
                return mid;
            } else if (array[mid] > target) { // 중간점의 값보다 target 이 작은 경우 왼쪽 확인
                end = mid - 1;
            } else {
                start = mid + 1; // 중간점의 값보다 target 이 큰 경우 오른쪽 확인
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // 원소의 개수 n개와 찾고자 하는 값 입력
        int n = toInt(bufferedReader.readLine());
        int target = toInt(bufferedReader.readLine());

        // 전체 원소 입력
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = toInt(bufferedReader.readLine());
        }

        // 이진 탐색 수행 결과 출력
        int result = binarySearch(array, target, 0, n - 1);
        if (result == -1) {
            System.out.println("원소가 존재하지 않습니다.");
            return;
        }
        System.out.println(result + 1);
    }

}
