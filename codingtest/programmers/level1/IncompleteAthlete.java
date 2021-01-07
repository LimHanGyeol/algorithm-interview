import java.util.*;

// 완주하지 못한 선수
class Solution {

    public String solution(String[] participant, String[] completion) {
        return incompleteAthlete(participant, completion);
    }

    private String incompleteAthlete(String[] participant, String[] completion) {
        Map<String, Integer> participantMap = getParticipant(participant);
        getFinishedRunners(participantMap, completion);
        return getResult(participantMap);
    }

    private String getResult(Map<String, Integer> participantMap) {
        for (String athlete : participantMap.keySet()) {
            if (participantMap.get(athlete) != 0) {
                return athlete;
            }
        }
        throw new IllegalArgumentException();
    }

    private Map<String, Integer> getParticipant(String[] participant) {
        Map<String, Integer> participantMap = new HashMap<>();
        for (String athlete : participant) {
            Integer person = participantMap.getOrDefault(athlete, 0);
            participantMap.put(athlete, person + 1);
        }
        return participantMap;
    }

    private void getFinishedRunners(Map<String, Integer> participantMap, String[] completion) {
        for (String athlete : completion) {
            finishMarathon(athlete, participantMap);
        }
    }

    private void finishMarathon(String athlete, Map<String, Integer> participantMap) {
        if (participantMap.containsKey(athlete)) {
            Integer person = participantMap.get(athlete);
            participantMap.put(athlete, person - 1);
        }
    }

}
