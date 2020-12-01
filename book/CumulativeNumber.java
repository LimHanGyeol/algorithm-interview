// 자바로 쉽게 배우는 알고리즘
// 누계 계산
// 배열 freq는 시험에서 등급 i를 받은 학생들의 수를 저장한다.
// 배열 cume는 i 이하의 등급을 받은 학생들의 수를 저장한다.
// 총 학생의 수를 구한다.
class Solution {

    public static void main(String[] args) {
        int[] freq = new int[] {1, 0, 7, 5, 4};

        System.out.println(calculateSum(freq); // 17

        System.out.println(computeCumulativeNumber(freq)); // 17
    }

    /**
     * 아래 알고리즘의 시간 복잡도는 O(n^2) 이다.
     */
    private int calculateSum(int[] freq) {
        int[] cume = getTotalStudents(freq);

        return cume[freq.length - 1];
    }

    private int[] getTotalStudents(int[] freq) {
        int n = freq.length;
        int[] cume = new int[n];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            sum = getStudentNumber(freq, i, sum);
            cume[i] = sum;
        }
        return cume;
    }

    private int getStudentNumber(int[] freq, int i, int sum) {
        for (int j = 0; j <= i; j++) {
            sum = sum + freq[j];
        }
        return sum;
    }

    /**
     * 위의 알고리즘을 개선한 알고리즘 이다.
     * 이전 알고리즘에서는 값을 구하는 과정에서 중복 계산을 많이 하고 있는 것을 알 수 있다.
     * 중복 계산을 제거하여 배열 cume의 각 요소를 계산한다.
     * 아래 알고리즘의 기본 연산은 반복문 내의 배정문이다.
     * 이 배정문은 i가 1부터 (n - 1)까지 (n - 1) 번 수행된다.
     * 따라서 이 알고리즘의 시간 복잡도는 O(n) 이다.
     * 이 알고리즘은 1차 선형 알고리즘이므로 위의 2차 선형 알고리즘보다 효율적이다.
     */
    private int computeCumulativeNumber(int[] freq) {
        int n = freq.length;
        int[] cume = new int[n];

        cume[0] = freq[0];

        for (int i = 1; i < n; i++) {
            cume[i] = cume[i - 1] + freq[i];
        }

        return cume[n - 1];
    }

}
