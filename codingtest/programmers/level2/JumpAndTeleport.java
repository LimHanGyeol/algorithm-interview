/**
 * 프로그래머스
 * Level2
 * 점프와 순간이동
 */
class Solution {

    public int solution(int n) {
        int count = 0; // 건전지 사용량

        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                count++;
            }
        }

        return count;
    }

}
