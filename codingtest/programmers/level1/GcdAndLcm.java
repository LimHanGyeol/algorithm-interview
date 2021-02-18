/**
 * 프로그래머스
 * Level 1
 * 최대공약수와 최소공배수
 */
class Solution {

    public static void main(String[] args) {
        int n = 3;
        int m = 12;
        System.out.println(getResult(n, m)); // [3, 12]
    }

    public int[] getResult(int first, int second) {
        int result = calculateGcd(first, second);
        return new int[]{result, first * second / result};
    }

    private int calculateGcd(int first, int second) {
        if (second == 0) {
            return first;
        }
        return calculateGcd(second, first % second);
    }

}
