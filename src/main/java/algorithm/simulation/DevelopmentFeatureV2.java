package algorithm.simulation;

import java.util.*;

/**
 * Programmers
 * Level2 - Queue
 * 기능 개발
 */
public class DevelopmentFeatureV2 {

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> workingDayQueue = initWorkingDayQueue(progresses, speeds);
        List<Integer> results = calculateProgressResults(workingDayQueue);
        return getAnswers(results);
    }

    private Queue<Integer> initWorkingDayQueue(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        int maximumRate = 100;

        for (int i = 0; i < progresses.length; i++) {
            int workingDay = maximumRate - progresses[i]; // 일해야 되는 날
            queue.offer(calculateRemainingDays(workingDay, speeds, i));
        }
        return queue;
    }

    private int calculateRemainingDays(int workingDay, int[] speeds, int i) {
        int remainingWorkingDay = workingDay / speeds[i]; // 남은 작업량 / 작업 속도 = 추가로 일해야 되는 날

        if (workingDay % speeds[i] != 0) {
            return remainingWorkingDay + 1;
        }
        return remainingWorkingDay;
    }

    private List<Integer> calculateProgressResults(Queue<Integer> progressesQueue) {
        List<Integer> results = new ArrayList<>();
        int count = 1;

        int prevFeature = 0;
        if (progressesQueue.peek() != null) {
            prevFeature = progressesQueue.poll();
        }

        while (!progressesQueue.isEmpty()) {
            int currentFeature = progressesQueue.poll();

            if (prevFeature >= currentFeature) {
                count++;
            } else {
                results.add(count);
                count = 1;
                prevFeature = currentFeature;
            }
        }
        results.add(count);
        return results;
    }

    private int[] getAnswers(List<Integer> results) {
        int[] answer = new int[results.size()];

        for (int i = 0; i < results.size(); i++) {
            answer[i] = results.get(i);
        }
        return answer;
    }
}
