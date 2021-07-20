package algorithm.simulation;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * programmers
 * Level2 - Hash
 * 전화번호 목록
 */
public class PhoneNumberList {

    public boolean solution(String[] phoneBook) {
        Map<String, Integer> phoneNumberMap = initPhoneNumberMap(phoneBook);

        for (String phoneNumber : phoneNumberMap.keySet()) {
            for (int i = 1; i <= phoneNumber.length() - 1; i++) {
                String startWithKey = phoneNumber.substring(0, i);
                if (phoneNumberMap.containsKey(startWithKey)) {
                    return false;
                }
            }
        }
        return true;
    }

    private Map<String, Integer> initPhoneNumberMap(String[] phoneBook) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String phoneNumber : phoneBook) {
            map.put(phoneNumber, 0);
        }
        return map;
    }
}
