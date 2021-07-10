package algorithm.tree.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * BaekJoon. 11279
 * 최대 힙, 절대값 힙
 * Priority Queue
 */
public class MaxHeap {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        int n = toInt(bufferedReader.readLine());
        // reverseOrder를 사용할 경우 최대힙이 된다.
        // PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int first = Math.abs(o1);
                int second = Math.abs(o2);

                if (first == second) {
                    return Integer.compare(o1, o2);
                }
                return Integer.compare(first, second);
            }
        });

        int value;
        for (int i = 0; i < n; i++) {
            int number = toInt(bufferedReader.readLine());
            if (number == 0) {
                if (priorityQueue.isEmpty()) {
                    value = 0;
                    System.out.println(value);
                    continue;
                }
                value = priorityQueue.poll();
                System.out.println(value);
                continue;
            }
            priorityQueue.add(number);
        }
    }
}
