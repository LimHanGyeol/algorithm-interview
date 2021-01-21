import java.util.*;

/**
 * 프로그래머스
 * Level1
 * 하샤드 수
 */
class Solution {

    public static void main(String[] args) {
        int n = 5;
        int[] stages = new int[]{2, 1, 2, 6, 2, 4, 3, 3};
        // [3,4,2,1,5]
        System.out.println(Arrays.toString(getFailureRate(n, stages)));
    }

    public int[] getFailureRate(int n, int[] stages) {
        int allUsersNumber = stages.length;
        int totalStage = n + 1;

        Map<Integer, Integer> stagesMap = initStagesMap(stages);

        Map<Integer, Double> failureRateMap = new HashMap<>();

        for (int i = 1; i <= totalStage; i++) {
            allUsersNumber = getFailureRate(allUsersNumber, stagesMap, failureRateMap, i);
        }

        List<Double> list = initFailureRateList(n, failureRateMap);

        return getResults(n, failureRateMap, list);
    }

    private int[] getResults(int n, Map<Integer, Double> failureRateMap, List<Double> list) {
        int[] results = new int[n];

        for (int i = 1; i <= failureRateMap.size() - 1; i++) {
            double failureRate = failureRateMap.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (results[j] != 0) {
                    continue;
                }
                if (list.get(j).equals(failureRate)) {
                    results[j] = i;
                    break;
                }
            }
        }

        return results;
    }

    private List<Double> initFailureRateList(int n, Map<Integer, Double> failureRateMap) {
        List<Double> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(failureRateMap.get(i + 1));
        }
        list.sort(Collections.reverseOrder());
        return list;
    }

    private int getFailureRate(int allUsersNumber, Map<Integer, Integer> stagesMap, Map<Integer, Double> failureRateMap, int i) {
        if (stagesMap.containsKey(i)) {
            int currentStageNumber = stagesMap.get(i);
            double failureRate = (double) currentStageNumber / allUsersNumber;

            failureRateMap.put(i, failureRate);
            return allUsersNumber - currentStageNumber;
        }
        failureRateMap.put(i, 0.0);
        return allUsersNumber;
    }

    private Map<Integer, Integer> initStagesMap(int[] stages) {
        Map<Integer, Integer> stagesMap = new HashMap<>();

        for (int stage : stages) {
            int user = stagesMap.getOrDefault(stage, 0);
            stagesMap.put(stage, user + 1);
        }
        return stagesMap;
    }

}
