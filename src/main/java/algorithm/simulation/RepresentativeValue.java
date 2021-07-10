package algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * BaekJoon. 2592
 * 대표값
 * Math
 */
public class RepresentativeValue {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        Map<Integer, Integer> numberMap = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            int number = toInt(bufferedReader.readLine());
            numberMap.put(number, numberMap.getOrDefault(number, 0) + 1);
            sum += number;
        }

        int average = sum / 10;
        System.out.println(average);

        int count = 0;
        int mostFrequentValue = 0;

        for (int key : numberMap.keySet()) {
            int value = numberMap.get(key);
            if (value > count) {
                count = value;
                mostFrequentValue = key;
            }
        }
        System.out.println(mostFrequentValue);
    }
}
