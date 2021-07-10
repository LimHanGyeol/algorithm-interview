package algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static algorithm.util.InputReader.init;

/**
 * BaekJoon. 1157
 * 단어 공부
 * Simulation
 */
public class StudyingVocabulary {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        String[] input = bufferedReader.readLine().split("");
        Map<String, Integer> vocabularyMap = initVocabularyMap(input);

        String result = getMaxCountWord(vocabularyMap);
        System.out.println(result);
    }

    private static Map<String, Integer> initVocabularyMap(String[] input) {
        Map<String, Integer> vocabularyMap = new HashMap<>();
        for (String voca : input) {
            voca = voca.toUpperCase();
            if (!vocabularyMap.containsKey(voca)) {
                vocabularyMap.put(voca, 1);
            } else {
                Integer value = vocabularyMap.get(voca);
                vocabularyMap.put(voca, value + 1);
            }
        }
        return vocabularyMap;
    }

    private static String getMaxCountWord(Map<String, Integer> vocabularyMap) {
        int count = 0;
        String result = "";
        for (String voca : vocabularyMap.keySet()) {
            int value = vocabularyMap.get(voca);
            if (value > count) {
                count = value;
                result = voca;
            } else if (value == count) {
                result = "?";
            }
        }
        return result;
    }
}
