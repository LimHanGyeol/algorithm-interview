/**
 * 쉽게 풀어보는 코딩 테스트 기출문제
 * String & Array
 * Move Zeros
 */
class Solution {

    public static void main(String[] args) {
        int[] numbers = new int[] {0, 3, 2, 0, 8, 5};
        // 3, 2, 8, 5, 0, 0
        System.out.println(Arrays.toString(moveZeros(numbers)));
    }

    private int[] moveZeros(int[] numbers) {
        int index = 0;

        index = disposeNumber(numbers, index);

        disposeZero(numbers, index);

        return numbers;
    }

    private int disposeNumber(int[] numbers, int index) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                numbers[index] = numbers[i];
                index++;
            }
        }
        return index;
    }

    private void disposeZero(int[] numbers, int index) {
        while (index < numbers.length) {
            numbers[index] = 0;
            index++;
        }
    }

}
