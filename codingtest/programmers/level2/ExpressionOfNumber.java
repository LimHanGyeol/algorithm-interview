import java.util.*;

/**
 * 프로그래머스
 * 숫자의 표현
 */
class Solution {

  public int solution(int n) {
        int count = 0;
        int sum = 0;
        int intValue = 0;

        for (int i = 1; i < n/2 + 1; i++) {
            sum = 0;
            intValue = i;
            while (sum < n) {
                sum += intValue ++;
            }

            if (sum == n) {
                 count++;
            }
        }
        return count+1;
  }

}
