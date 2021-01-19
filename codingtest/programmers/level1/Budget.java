import java.util.*;

/**
 * 프로그래머스
 * Level1
 * 예산
 */
class Solution {

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 5, 4};
        int budget = 10;
        System.out.println(supportDepartmentCount(array, budget)); // 3
    }

    public int supportDepartmentCount(int[] array, int budget) {
        Arrays.sort(array);
        int count = 0;

        for (int necessaryBudget : array) {
            budget -= necessaryBudget;
            count += supportCount(budget);
            if (budget < 0) {
                return count;
            }
        }
        return count;
    }

    private int supportCount(int budget) {
        if (budget >= 0) {
            return 1;
        }
        return 0;
    }

}
