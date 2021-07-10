package algorithm.simulation;

/**
 * 정수 4를 1, 2, 3의 조합으로 나타내는 방법은 총 7가지가 있다.
 * 정수 n이 입력으로 주어졌을 때 n을 1, 2, 3의 합으로 나타낼 수 있는 방법을 구하라.
 * Ex)
 * 1 + 1 + 1 + 1
 * 1 + 1 + 2
 * 1 + 2 + 1
 * 2 + 1 + 1
 * 2 + 2
 * 1 + 3
 * 3 + 1
 * <p>
 * 정수 n을 만들 수 있는 경우의 수를 리턴하는 함수를 f(n)이라고 하면,
 * f(n)은 f(n - 1) + f(n - 2) + f(n - 3)과 동일하다.
 */
public class Recursive {

    public int recursive(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        return recursive(n - 1) + recursive(n - 2) + recursive(n - 3);
    }

    public int factorial(int n) {
        if (n <= 1) {
            return n;
        }
        return factorial(n - 1) + factorial(n - 2);
    }

    public int dynamicFactorial(int n) {
        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }
}
