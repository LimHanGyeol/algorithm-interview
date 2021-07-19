package algorithm.tree.heap;

import java.util.PriorityQueue;

/**
 * programmers
 * Level2
 * 더 맵게
 */
public class MoreSpicyV2 {

    public int solution(int[] scoville, long K) {
        PriorityQueue<Integer> scovilleQueue = initScovilleQueue(scoville);
        int count = 0;

        while (scovilleQueue.peek() < K) {
            if (scovilleQueue.size() < 2) {
                return -1;
            }
            int firstScoville = scovilleQueue.poll();
            int secondScoville = scovilleQueue.poll();

            int mixedScoville = firstScoville + (secondScoville * 2);
            scovilleQueue.offer(mixedScoville);
            count++;
        }

        return count;
    }

    private PriorityQueue<Integer> initScovilleQueue(int[] scoville) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int scovilleRate : scoville) {
            queue.offer(scovilleRate);
        }
        return queue;
    }
}
