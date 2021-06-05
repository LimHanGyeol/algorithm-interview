package algorithm.dynamic;

/**
 * 이것이 취업을 위한 코딩 테스트다 with Python
 * Java
 * <p>
 * 피보나치 수열의 효율적인 해법 : 다이나믹 프로그래밍
 * 다이나믹 프로그래밍의 사용 조건을 만족하는지 확인한다.
 * 1. 최적 부분 구조 : 큰 문제를 작은 문제로 나눌 수 있다.
 * 2. 중복되는 부분 문제 : 동일한 작은 문제를 반복적으로 해결한다.
 * 피보나치 수열은 다이나믹 프로그래밍의 사용 조건을 만족한다.
 * <p>
 * 하향식(Top - Down) - 메모이제이션 (Memoization)
 * 메모이제이션은 다이나믹 프로그래밍을 구현하는 방법 중 하나이다.
 * 한 번 계산한 결과를 메모리 공간에 메모하는 기법이다.
 * - 같은 문제를 다시 호출하면 메모했던 결과를 그대로 가져온다.
 * - 값을 기록해 놓는다는 점에서 캐싱(Caching)이라고도 한다.
 *
 * Ex
 * Input : 50
 * Output : 12586269025
 */
public class Fibonacci {

    private static final long[] cache = new long[100];

    public static void main(String[] args) {
        // 재귀
        // System.out.println(fibonacci(4));

        // DP - 메모이제이션을 사용하는 경우 피보나치 수열 함수의 시간 복잡도는 O(N) 이다.
        // 첫 번째 피보나치 수와 두 번째 피보나치 수는 1
        cache[1] = 1;
        cache[2] = 1;
        int number = 50; // 50번째 피보나치 수를 계산

        // 피보나치 함수(Fibonacci Function) 반복문으로 구현(바텀 - 업 DP)
        for (int i = 3; i <= number; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        System.out.println(cache[number]);
    }

    /**
     * 단순 재귀로 피보나치 수열을 구현하면 지수 시간 복잡도를 갖게 된다.
     * 그래서 큰 수가 호출되면 메모리 부하가 커진다. O(2^n)
     * 빅오 표기법을 기준으로 f(30)을 계산하기 위해 약 10억 가량의 연산을 수행해야 한다.
     */
    private static int fibonacci(int number) {
        if (number == 1 || number == 2) {
            return 1;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
    }
}
