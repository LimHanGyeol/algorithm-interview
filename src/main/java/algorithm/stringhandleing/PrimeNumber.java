package algorithm.stringhandleing;

/**
 * 이것이 취업을 위한 코딩 테스트다 with Python
 * Java
 *
 * 소수 판별 알고리즘
 */
public class PrimeNumber {

    /**
     * 개선된 소수 판별 알고리즘 (제곱근을 기준으로 구한다.)
     * O(N-1/2)
     */
    private boolean isPrimeNumberV2(int number) {
        // 2부터 x의 제곱근까지 모든 수를 확인한다.
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) { // 순회하는 값으로 나누어 떨어지면 소수가 아니다.
                return false;
            }
        }
        return true;
    }

    /**
     * 시간 복잡도 O(N)
     */
    private boolean isPrimeNumber(int number) {
        // 2부터 (number - 1)까지 모든 수를 확인한다.
        for (int i = 2; i < number; i++) {
            if (number % i == 0) { // 순회하는 값으로 나누어 떨어지면 소수가 아니다.
                return false;
            }
        }
        return true; // 1혹은 number의 값으로만 나누어 떨어져야지 소수이다.
    }
}
