class Solution {

    private int[] solve(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i <numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(numbers[i], i);
        }
        throw new IllegalArgumentException();
    }

    public int[] twoSum(int[] nums, int target) {
        return solution(nums, target);
    }
    
    private int[] solution(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }

}
