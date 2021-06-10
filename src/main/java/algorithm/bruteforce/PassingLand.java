package algorithm.bruteforce;

import java.util.Arrays;

/**
 * Programmers
 * Level2
 * 땅따먹기
 */
public class PassingLand {

    private static final int[] cache = new int[100001];

    public int play(int[][] land) {
        for (int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
            land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
        }
        for (int[] landLine : land) {
            Arrays.sort(landLine);
        }
        return land[land.length - 1][3];
    }

    public int solution(int[][] land) {
        int answer = Integer.MIN_VALUE;
        int n = land.length;
        int[][] dp = new int[n][land[0].length];
        // land의 0번째 행은 그대로 dp의 0번째 행에 저장
        for (int i = 0; i < land[0].length; i++) {
            dp[0][i] = land[0][i];
        }

        // 1 번째 행부터 순회
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < land[i].length; j++) {
                int max = Integer.MIN_VALUE;
                for (int k = 0; k < 4; k++) {
                    if (j == k) {
                        continue;
                    }
                    max = Math.max(max, dp[i - 1][k]);
                }
                dp[i][j] = land[i][j] + max;
            }
        }

        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[n - 1][i]);
        }
        return answer;
    }
}
