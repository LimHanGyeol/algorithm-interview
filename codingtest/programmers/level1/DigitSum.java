// 자릿수 더하기
public class Solution {

    public int solution(int n) {
        String[] results = String.valueOf(n).split("");
        
        return getResult(results);
    }
    
    private int getResult(String[] results) {
        int result = 0;
        for (String number : results) {
            result += Integer.parseInt(number);
        }
        return result;
    }
}
