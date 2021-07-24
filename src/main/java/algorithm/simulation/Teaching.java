package algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * Baekjoon. 1062
 * 가르침 - Gold4
 * Brute Force - Combination
 */
public class Teaching {

    private static int n;
    private static int k;
    private static boolean[] visitedAlphabet = new boolean[26];
    private static String[] apprehendString;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        String[] input = bufferedReader.readLine().split(" ");
        n = toInt(input[0]);
        k = toInt(input[1]);
        apprehendString = new String[n];

        if (k < 5) {
            System.out.println(0);
            return;
        }
        if (k == 26) { // 모든 알파벳이 가능할 경우
            System.out.println(n);
            return;
        }

        for (int i = 0; i < n; i++) {
            String word = bufferedReader.readLine();
            // prefix : anta, suffix : tica 제거
            apprehendString[i] = word.substring(4, word.length() - 4);
        }

        // a, n, t, i, c 처리
        visitedAlphabet['a' - 97] = true; // visitedAlphabet[0] = true
        visitedAlphabet['n' - 97] = true;
        visitedAlphabet['t' - 97] = true;
        visitedAlphabet['i' - 97] = true;
        visitedAlphabet['c' - 97] = true;

        // 조합 (Combination), DFS 를 이용하여 계산
        int[] numbers = new int[k - 5];
        max = 0;
        combination(0, 0);
        System.out.println(max);
    }

    private static void combination(int index, int start) {
        // 총 단어가 6개일 경우 a, n, t, i, c를 제외한 조합 k - 5 : 1개
        if (index == k - 5) {
            int count = 0;

            // 단어만큼 반복
            for (int i = 0; i < n; i++) {
                boolean isValid = true;

                // 앞, 뒤 4개씩 자른 단어를 한 개씩 비교해서 단어가 포함될 경우
                for (int j = 0; j < apprehendString[i].length(); j++) {
                    if (!visitedAlphabet[apprehendString[i].charAt(j) - 97]) {
                        // 조합으로 뽑힌 알파벳에 없으면 불가능
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    count++;
                }
            }
            max = Math.max(max, count);
            return;
        }

        // 알파벳을 탐색하며 가능한 조합 찾기
        for (int i = start; i < 26; i++) {
            // 이미 방문한 index는 통과
            if (!visitedAlphabet[i]) {
                visitedAlphabet[i] = true;
                combination(index + 1, i + 1);
                visitedAlphabet[i] = false;
            }
        }
    }
}
