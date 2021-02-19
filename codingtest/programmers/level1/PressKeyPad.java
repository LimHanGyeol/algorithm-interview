/**
 * 프로그래머스
 * Level1. 2020 카카오 인턴쉽
 * 키패드 누르기
 */
class Solution {

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(getResult(numbers, hand)); // LRLLLRLLRRL
    }

    private static final String PRESS_LEFT_MESSAGE = "L";
    private static final String PRESS_RIGHT_MESSAGE = "R";

    private static final int[][] keypad = new int[][]{
            {0, 0}, {0, 1}, {0, 2},
            {1, 0}, {1, 1}, {1, 2},
            {2, 0}, {2, 1}, {2, 2},
            {3, 0}, {3, 1}, {3, 2}
    };

    /**
     * 1, 2, 3
     * 4, 5, 6
     * 7, 8, 9
     * 10, 11, 12
     */
    public String getResult(int[] numbers, String hand) {
        StringBuilder result = new StringBuilder();
        int leftFingerPosition = 10;
        int rightFingerPosition = 12;

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                result.append(PUSH_LEFT_MESSAGE);
                leftFingerPosition = number;
            } else if (number == 3 || number == 6 || number == 9) {
                result.append(PUSH_RIGHT_MESSAGE);
                rightFingerPosition = number;
            } else {
                if (number == 0) {
                    number = 11;
                }
                int[] leftNumberPosition = keypad[leftFingerPosition - 1];
                int[] rightNumberPosition = keypad[rightFingerPosition - 1];

                int[] pushNumberPosition = keypad[number - 1];

                int leftDistance = getDistance(leftNumberPosition, pushNumberPosition);
                int rightDistance = getDistance(rightNumberPosition, pushNumberPosition);

                if (leftDistance < rightDistance) {
                    result.append(PUSH_LEFT_MESSAGE);
                    leftFingerPosition = number;
                } else if (rightDistance < leftDistance) {
                    result.append(PUSH_RIGHT_MESSAGE);
                    rightFingerPosition = number;
                } else {
                    if (hand.equals("left")) {
                        result.append(PUSH_LEFT_MESSAGE);
                        leftFingerPosition = number;
                    } else {
                        result.append(PUSH_RIGHT_MESSAGE);
                        rightFingerPosition = number;
                    }
                }
            }
        }

        return result.toString();
    }

    private int getDistance(int[] fingerPosition, int[] numberPosition) {
        int leftPosition = Math.abs(fingerPosition[0] - numberPosition[0]);
        int rightPosition = Math.abs(fingerPosition[1] - numberPosition[1]);
        return leftPosition + rightPosition;
    }

}
