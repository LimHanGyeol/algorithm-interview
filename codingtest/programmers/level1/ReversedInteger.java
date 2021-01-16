/**
 * 프로그래머스
 * Level1
 * 자연수 뒤집어 배열로 만들기
 */
class Solution {

    public static void main(String[] args) {
        int n = 12345;
        System.out.println(Arrays.toString(reversedInteger(n)));
    }

    private int[] reversedInteger(long n) {
        int length = String.valueOf(n).length();
        int[] numbers = new int[length];

        for (int i = 0; n != 0; i++) {
            numbers[i] = (int) (n % 10);
            n /= 10;
        }
        return numbers;
    }

}
