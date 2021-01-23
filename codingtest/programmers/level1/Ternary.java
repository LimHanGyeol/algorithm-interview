/**
 * 프로그래머스
 * Level1
 * 3진법 뒤집기
 */
class Solution {

    public static void main(String[] args) {
        System.out.println(toThree(45)); // 7
    }

    public int getTernary(int number) {
        StringBuffer result = new StringBuffer();
        while (number > 0) {
            result.append(number % 3);
            number /= 3;
        }
        return Integer.parseInt(result.toString(), 3);
    }

}
