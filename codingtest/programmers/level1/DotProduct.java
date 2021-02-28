/**
 * 프로그래머스
 * Level1
 * 내적
 */
class Solution {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4};
        int[] b = new int[]{-3, -1, 0, 2};
        System.out.println(getDotProduct(a, b)); // 3
    }

    public int getDotProduct(int[] a, int[] b) {
        int result = 0;

        for (int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }

        return result;
    }

}
