// 서울에서 김서방 찾기
class Solution {
    
    public String solution(String[] seoul) {
        StringBuffer result = new StringBuffer();
        
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                result.append("김서방은 ");
                result.append(i);
                result.append("에 있다");
            }
        }
        
        return result.toString();
    }
}
