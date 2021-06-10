package algorithm.stringhandleing;

import java.util.Arrays;

/**
 * 이것이 취업을 위한 코딩 테스트다 with Python
 * Java
 * <p>
 * 에라토스테네스의 체
 */
public class FindPrimeNumberAlgorithm {

    private static final int NUMBER = 1000;
    private static boolean[] array = new boolean[NUMBER + 1];

    private void findPrimeNumber(int number) {
        Arrays.fill(array, true); // 모든 수가 소수(True)인 것으로 초기화
        // 에라토스테네스의 체 수행
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (array[i]) { // i가 소수인 경우 (남은 수인 경우)
                int multiply = 2; // i를 제외한 i의 모든 배수 지우기
                while (i * multiply <= number) {
                    array[i * multiply] = false;
                    multiply += 1;
                }
            }
        }

        // 모든 소수 출력
        for (int i = 2; i <= number; i++) {
            if (array[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
