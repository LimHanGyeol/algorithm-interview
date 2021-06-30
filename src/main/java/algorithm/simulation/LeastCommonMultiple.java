package algorithm.simulation;

/**
 * Programmers
 * Level2
 * N개의 최소공배수
 */
public class LeastCommonMultiple {

    public int solution(int[] arr) {
        int index = 1;

        while (index < arr.length) {
            int gcd = calculateGCD(arr[index - 1], arr[index]);
            int lcm = (arr[index - 1] * arr[index]) / gcd;
            arr[index] = lcm;

            index++;
        }

        return arr[index - 1];
    }

    public int calculateGCD(int first, int second) {
        if (second == 0) {
            return first;
        }
        return calculateGCD(second, first % second);
    }
}
