import java.util.*;

/**
 * 프로그래머스
 * Level1. 2019 카카오 개발자 겨울 인턴쉽
 * 크레인 인형뽑기 게임
 */
class Solution {

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] moves = new int[]{1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(pullDoll(board, moves)); // 4
    }

    /**
     * 리팩토링한 문제 풀이
     */
    private int pullDoll(int[][] board, int[] moves) {
        Stack<Integer> bucket = new Stack<>();
        int brokenDoll = 0;

        for (int cranePosition : moves) {
            int doll = operateCrane(board, cranePosition - 1);
            brokenDoll += putInBucket(doll, bucket);
        }
        return brokenDoll;
    }

    private int operateCrane(int[][] board, int cranePosition) {
        for (int height = 0; height < board.length; height++) {
            int doll = board[height][cranePosition];

            if (doll != 0) {
                board[height][cranePosition] = 0;
                return doll;
            }

        }
        return 0;
    }

    private int putInBucket(int doll, Stack<Integer> bucket) {
        if (doll == 0) {
            return 0;
        }
        if (!bucket.isEmpty() && bucket.peek() == doll) {
            bucket.pop();
            return 2;
        }
        bucket.push(doll);
        return 0;
    }

    /**
     * 첫번째 풀이
     */
    private int pullDoll(int[][] board, int[] moves) {
        Stack<Integer> bucket = new Stack<>();
        int brokenDoll = 0;

        for (int i = 0; i < moves.length; i++) {
            int cranePosition = moves[i] - 1;

            for (int height = 0; height < board.length; height++) {
                int doll = board[height][cranePosition];
                if (doll != 0) {
                    if (!bucket.isEmpty() && bucket.peek() == doll) {
                        bucket.pop();
                        board[height][cranePosition] = 0;
                        brokenDoll += 2;
                        break;
                    }
                    bucket.push(doll);
                    board[height][cranePosition] = 0;
                    break;
                }

            }

        }
        return brokenDoll;
    }

}
