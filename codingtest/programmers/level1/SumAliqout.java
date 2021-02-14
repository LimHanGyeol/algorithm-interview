/**
 * 프로그래머스
 * Level 1
 * 약수의 합
 */
class Solution {

    public static void main(String[] args) {
        System.out.println(getSumAliquot(12));
    }

    public int getSumAliquot(int n) {
        int result = 0;
        int repeat = n / 2;

        for (int i = 1; i <= repeat; i++) {
            if (n % i == 0) {
                result += i;
            }
        }

        return result + n;
    }

}
