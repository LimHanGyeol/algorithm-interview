package algorithm.tree.heap;

import java.util.PriorityQueue;

/**
 * Programmers
 * Level2
 * 더 맵게 - Heap
 */
public class MoreSpicy {

    public int calculate(int[] scoville, int K) {
        PriorityQueue<Integer> heap = initQueue(scoville);
        int count = 0;

        // 우선순위 큐로 오름차순 정렬되어 K 보다 큰 값이 나올 경우 그 이후의 값은 모두 K보다 크다.
        while (heap.peek() < K) {
            if (heap.size() < 2) {
                return -1;
            }
            int firstNotSpicy = heap.poll();
            int secondNotSpicy = heap.poll();
            int mixedScoville = firstNotSpicy + (secondNotSpicy * 2);
            heap.offer(mixedScoville);
            count++;
        }
        return count;
    }

    private PriorityQueue<Integer> initQueue(int[] scoville) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int scovilleRate : scoville) {
            priorityQueue.offer(scovilleRate);
        }
        return priorityQueue;
    }
}
