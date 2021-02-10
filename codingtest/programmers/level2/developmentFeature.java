import java.util.*;

/**
 * 프로그래머스
 * Level2 - 스택/큐
 * 기능 개발
 */
class Solution {

    public static void main(String[] args) {
        int[] progresses = new int[]{93, 30, 55};
        int[] speeds = new int[]{1, 30, 5};

        System.out.println(Arrays.toString(getDevelopFeatures(progresses, speeds))); // 2, 1
    }

    public int[] getDevelopFeatures(int[] progresses, int[] speeds) {
        Queue<Integer> queue = initRemainingDaysQueue(progresses, speeds);
        List<Integer> deploymentFeatures = getCalculate(queue);
        return getResults(deploymentFeatures);
    }

    private List<Integer> getCalculate(Queue<Intger> queue) {
        List<Integer> deploymentFeatures = new ArrayList<>();
        int prevFeature = 0;

        if (queue.peek() != null) {
            prevFeature = queue.poll();
        }

        int count = 1;

        while (!queue.isEmpty()) {
            int currentFeature = queue.poll();

            if (prevFeature >= currentFeature) {
                count++;
            } else {
                deploymentFeatures.add(count);
                count = 1;
                prevFeature = currentFeature;
            }
        }
        deploymentFeatures.add(count);
        return deploymentFeatures;
    }

    private Queue<Integer> initRemainingDaysQueue(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        final int maximumRate = 100;

        for (int i = 0; i < progresses.length; i++) {
            int workingDay = maximumRate - progresses[i];
            queue.offer(calculateRemainingDays(workingDay, speeds, i));
        }
        return queue;
    }

    private int calculateRemainingDays(int workingDay, int[] speeds, int i) {
        int division = workingDay / speeds[i];

        if (workingDay % speeds[i] == 0) {
           return division;
        }
        return division + 1;
    }

    private int[] getResults(List<Integer> deploymentFeatures) {
        int[] results = new int[deploymentFeatures.size()];
        int resultsLength = results.length;

        for (int i = 0; i < resultsLength; i++) {
            results[i] = deploymentFeatures.get(i);
        }
        return results;
    }
}
