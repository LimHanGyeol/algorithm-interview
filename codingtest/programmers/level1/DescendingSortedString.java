import java.util.*;

// 문자열 내림차순으로 배치하기
class Solution {
    
    public String solution(String s) {
        char[] inputArrays = s.toCharArray();
        Arrays.sort(inputArrays);
        
        return new StringBuilder()
                .append(inputArrays)
                .reverse()
                .toString();
    }
}