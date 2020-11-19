import java.util.*;

class Solution {

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> userMap = initAllUsersMap(participant);

        findNotCompletionUser(completion, userMap);

        return getResult(userMap);
    }

    private Map<String, Integer> initAllUsersMap(String[] participant) {
        Map<String, Integer> userMap = new HashMap<>();
        for (String user : participant) {
            userMap.put(user, userMap.getOrDefault(user, 0) + 1);
        }
        return userMap;
    }

    private void findNotCompletionUser(String[] completion, Map<String, Integer> userMap) {
        for (String completionUser : completion) {
            if (userMap.containsKey(completionUser)) {
                int userNumber = userMap.get(completionUser);
                userMap.put(completionUser, userNumber -1);
            }
        }
    }

    private String getResult(Map<String, Integer> userMap) {
        for (String user : userMap.keySet()) {
            if (userMap.get(user) == 1) {
                return user;
            }
        }
        throw new RuntimeException();
    }

}
