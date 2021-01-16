/**
 * 프로그래머스
 * Level1
 * 콜라츠 추측
 */
class Solution {

    public int solution(long number) {
        int count = 0;

        for (int i = 0; i <500; i++) {
            if (number == 1) {
                return count;
            }
            number = calculateNumber(number);
            count++;
        }
        return -1;
    }

    private long calculateNumber(long number) {
        if (number % 2 == 0) {
            return number / 2;
        }
        return (number * 3) + 1;
    }
    
}
