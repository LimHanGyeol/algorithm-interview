import java.util.*;

// 두 개 뽑아서 더하기
class Solution {

    private static final int NUMBER_ZERO = 0;
    private static final int NUMBER_ONE = 1;

    public int[] solution(int[] numbers) {
        Set<Integer> answer = new TreeSet<>();
        sumNumbers(numbers, answer);
        return toArray(answer);
    }
    
    private void sumNumbers(int[] numbers, Set<Integer> answer) {
        for (int i = NUMBER_ZERO; i < numbers.length; i++) {
            for (int j = i + NUMBER_ONE; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                answer.add(sum);
            }
        }
    }

    private int[] toArray(Set<Integer> answer) {
        int[] results = new int[answer.size()];
        Iterator<Integer> iterator = answer.iterator();
        int index = NUMBER_ZERO;
        
        while (index < results.length) {
            results[index] = iterator.next();
            index++;
        }
        return results;
    }
}
