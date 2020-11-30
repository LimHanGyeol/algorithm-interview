// 자바로 쉽게 배우는 알고리즘
// 제곱 계산
class Solution {

    /**
     * 아래 알고리즘은 number * number 연산을 한 번 수행한다.
     * 알고리즘의 시간 복잡도는 O(1) 이다.
     */
    private int computeSquare1(int number) {
        return number * number;
    }

    /**
     * 아래 알고리즘은 n^2를 계산하기 위해 0에 n을 n번 더한다.
     * 아래 알고리즘의 기본 연산은 반복문 내의 배정문 (square = square + n)이다.
     * 이 배정문은 i가 1부터 n까지 n번 수행된다.
     * 따라서 이 알고리즘의 시간 복잡도는 O(n) 이다.
     */
    private int computeSquare2(int number) {
        int square = 0;

        for (int i = 1; i <= number; i++) {
            square = square + number;
        }
        return square;
    }

    /**
     * 아래 알고리즘은 의도적으로 n^2를 계산하기 위해 0에 1을 n^2번 더한다.
     * 알고리즘의 기본 연산은 중첩 반복문의 가장 안쪽 반복분 내의 배정문인 (square = square + 1) 이다.
     * 이 배정문은 i가 1일 때 n번, 2일 때 n번 ... n일 때 n번 수행 된다.
     * 따라서 총 반복 횟수는 n + n + ... + n = n^2 이다.
     * 따라서 이 알고리즘의 시간 복잡도는 O(n^2) 이다.
     */
    private int computeSquare3(int number) {
        int square = 0;

        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number; j++) {
                square = square + 1;
            }
        }

        return square;
    }

}

