import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> answer = new TreeSet<>();
        sumNumbers(numbers, answer);
        return toArray(answer);
    }
    
        private void sumNumbers(int[] numbers, Set<Integer> answer) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                answer.add(sum);
            }
        }
    }

    private int[] toArray(Set<Integer> answer) {
        int[] results = new int[answer.size()];
        Iterator<Integer> iterator = answer.iterator();
        int index = 0;
        
        while (index < results.length) {
            results[index] = iterator.next();
            index++;
        }
        return results;
    }
}