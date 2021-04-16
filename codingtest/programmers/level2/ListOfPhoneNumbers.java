import java.util.*;

/**
 * 프로그래머스
 * 해시
 * 전화번호 목록
 */
class Solution {

    public boolean solution(String[] phone_book) {
        int minLength = phone_book.length;
        String keyValue;
        List<String> keySetList = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (String phoneNum : phone_book) {
            int phoneNumLen = phoneNum.length();
            if (phoneNumLen < minLength) minLength = phoneNumLen;
        }

        for (String phoneNum : phone_book) {
            keyValue = phoneNum.substring(0, minLength);
            keySetList.add(keyValue);
            map.put(keyValue, map.getOrDefault(keyValue, 0) + 1);
        }

        for (int i = 0; i < keySetList.size(); i++) {
            if (map.get(keySetList.get(i)) > 1) {
                return false;
            }
                break;

        }

        return true;
    }

}
