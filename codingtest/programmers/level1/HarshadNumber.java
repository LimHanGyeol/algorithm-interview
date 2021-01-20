/**
 * 프로그래머스
 * Level1
 * 하샤드 수
 */
class Solution {

    public static void main(String[] args) {
        System.out.println(isHarshadNumber(10)); // true
    }

    public boolean isHarshadNumber(int x) {
        String[] numbers = String.valueOf(x).split("");
        int division = 0;

        for (String number : numbers) {
            division += Integer.parseInt(number);
        }
        return (x % division) == 0;
    }

    public boolean isHarshadNumber(int x) {
        char[] numbers = String.valueOf(x).toCharArray();
        int division = 0;

        for (char number : numbers) {
            division += (int) number - 48;
        }

        return (x % division) == 0;
    }

    /**
     * Stream API 이용한 풀이
     */
    public boolean isHarshadNumber(int x) {
        int sum = String.valueOf(x)
                        .chars()
                        .map(ch -> ch - '0')
                        .sum();
        return (x % sum) == 0;
    }

}
