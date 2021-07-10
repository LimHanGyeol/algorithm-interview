package algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * BaekJoon. 1158
 * 요세푸스 문제
 * Queue
 */
public class Josephus {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        String[] input = bufferedReader.readLine().split(" ");
        int n = toInt(input[0]);
        int k = toInt(input[1]);

        Queue<Integer> peopleQueue = initQueue(n);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<");

        // 3 6 2 7 5 1 4
        while (peopleQueue.size() != 1) {
            for (int i = 0; i < k - 1; i++) {
                Integer person = peopleQueue.poll();
                peopleQueue.offer(person);
            }

            stringBuilder
                    .append(peopleQueue.poll())
                    .append(", ");
        }

        stringBuilder
                .append(peopleQueue.poll())
                .append(">");

        System.out.println(stringBuilder);
    }

    private static Queue<Integer> initQueue(int n) {
        Queue<Integer> peopleQueue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            peopleQueue.offer(i);
        }
        return peopleQueue;
    }
}
