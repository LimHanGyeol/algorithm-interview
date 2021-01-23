/**
 * 프로그래머스
 * Level1
 * 정수 제곱근 판별
 */
class Solution {

    public static void main(String[] args) {
        System.out.println(makeDistinctionSquareRoot(121)); // 144
    }

    public long makeDistinctionSquareRoot(long n) {
        double result = Math.sqrt(n);

        if (result % 1 == 0) {
            return (long) Math.pow(result + 1, 2);
        }
        return -1;
    }

}
