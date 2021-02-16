/**
 * 프로그래머스
 * Level 1
 * 소수 찾기
 */
class Solution {

    public static void main(String[] args) {
        System.out.println(10); // 4
    }

    public int getPrimeNumberCount(int n) {
        int[] numbers = initNumbers(n);
        findPrimeNumbers(n, numbers);
        return getCount(numbers);
    }

    private int[] initNumbers(int n) {
        int[] numbers = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            numbers[i] = i;
        }
        return numbers;
    }

    private void findPrimeNumbers(int n, int[] numbers) {
        for (int i = 2; i <= n; i++) {
            if (numbers[i] == 0) {
                continue;
            }
            for (int j = 2 * i; j <= n; j += i) {
                numbers[j] = 0;
            }
        }
    }

    private int getCount(int[] numbers) {
        int count = 0;
        for (int number : numbers) {
            if (number != 0) {
                count++;
            }
        }
        return count;
    }

}
