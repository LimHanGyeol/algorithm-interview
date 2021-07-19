package algorithm.graph;

/**
 * programmers
 * Level2 - DFS
 * 타겟 넘버
 */
public class TargetNumberV2 {

    public int solution(int[] numbers, int target) {
        int count = 0;
        count += dfs(0, target, 0, numbers);
        return count;
    }

    private int dfs(int number, int target, int index, int[] numbers) {
        if (index == numbers.length) {
            if (number == target) {
                return 1;
            }
            return 0;
        }
        int additionalResult = dfs(number + numbers[index], target, index + 1, numbers);
        int subtractionResult = dfs(number - numbers[index], target, index + 1, numbers);
        return additionalResult + subtractionResult;
    }
}
