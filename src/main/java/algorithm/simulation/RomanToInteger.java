package algorithm.simulation;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode
 * Easy
 * Roman to Integer
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        Map<Character, Integer> romanIntegerMap = initRomanIntegerMap();
        int length = s.length();
        int result = 0;

        for (int i = 0; i < length - 1; i++) {
            int now = romanIntegerMap.get(s.charAt(i));
            int next = romanIntegerMap.get(s.charAt(i + 1));

            if (now < next) {
                result = result - now;
                continue;
            }
            result = result + now;
        }

        result += romanIntegerMap.get(s.charAt(length - 1));

        return result;
    }

    private Map<Character, Integer> initRomanIntegerMap() {
        Map<Character, Integer> romanIntegerMap = new HashMap<>();
        romanIntegerMap.put('I', 1);
        romanIntegerMap.put('V', 5);
        romanIntegerMap.put('X', 10);
        romanIntegerMap.put('L', 50);
        romanIntegerMap.put('C', 100);
        romanIntegerMap.put('D', 500);
        romanIntegerMap.put('M', 1000);
        return romanIntegerMap;
    }
}
