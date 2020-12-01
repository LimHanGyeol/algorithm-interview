// 자바로 쉽게 배우는 알고리즘
// 계승 계산 (Factorial)
class Solution {

    public static void main(String[] args) {
        System.out.println(factorial(5)); // 120
        System.out.println(factorial(10)); // 3628800
    }

    /**
     * 계승 계산의 점화식은 F(n) = F(n - 1) * n 이다.
     * 해당 알고리즘의 시간 복잡도는 O(n) 이다.
     */
    private int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

}
