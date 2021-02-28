/**
 * 프로그래머스
 * Level2
 * 124 나라의 숫자
 */
class Solution {

    public static void main(String[] args) {
        System.out.println(getResult(1)); // 1
        System.out.println(getResult(2)); // 2
        System.out.println(getResult(3)); // 4
        System.out.println(getResult(4)); // 11
    }

    public String getResult(int n) {
        String[] numbers = new String[]{"4", "1", "2"};
        String result = "";

        int number = n;

        while (number > 0) {
            int index = number % 3;
            number /= 3;

            if (index == 0) {
                number--;
            }
            result = numbers[index] + result;
        }
        return result;
    }

}
