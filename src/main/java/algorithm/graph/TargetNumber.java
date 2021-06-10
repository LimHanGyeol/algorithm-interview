package algorithm.graph;

/**
 * Programmers
 * Level2
 * 타겟 넘버 - DFS
 */
public class TargetNumber {

    // +, -를 할 수 있는 모든 경우의 수 순회
    public int dfs(int[] numbers, int target, int index, int numberOfCases) {
        if (index == numbers.length) {
            if (numberOfCases == target) {
                return 1;
            }
            return 0;
        }
        int additionalResult = dfs(numbers, target, index + 1, numberOfCases + numbers[index]);
        int subtractionResult = dfs(numbers, target, index + 1, numberOfCases - numbers[index]);
        return additionalResult + subtractionResult;
    }
}
