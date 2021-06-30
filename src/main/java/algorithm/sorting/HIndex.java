package algorithm.sorting;

import java.util.Arrays;

/**
 * Programmers
 * Level2
 * H - Index
 */
public class HIndex {

    public int solution(int[] citations) {
        Arrays.sort(citations);
        int excerpt = 0;

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                excerpt = h;
                break;
            }
        }
        return excerpt;
    }
}
