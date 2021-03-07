import java.util.*;

/**
 * 프로그래머스
 * Level2
 * 폰켓몬
 */
class Solution {

    public int solution(int[] nums) {
        int pick = nums.length / 2;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int result = set.size();

        if (pick == result || pick < result) {
            return pick;
        }
        return result;
    }

}
