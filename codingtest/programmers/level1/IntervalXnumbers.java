// x만큼 간격이 있는 n개의 숫자
class Solution {
    
    public long[] solution(int x, int n) {
        return multipleByNumbers(x, n);
    }
    
    private long[] multipleByNumbers(int x, int n) {
        long[] results = new long[n];
        
        for (int i = 0; i < n; i++) {
            results[i] = (long) x * (i + 1);
        }
        return results;
    }
    
}