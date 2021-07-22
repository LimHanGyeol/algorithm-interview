package algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * Baekjoon. 1141
 * 접두사 - Silver2
 * StringHandling, Sort
 */
public class PrefixX {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        int n = toInt(bufferedReader.readLine());
        List<String> words = initWords(bufferedReader, n);

        int index = 0;
        while (index != words.size() - 1) {
            String prevWord = words.get(index);
            for (int i = index + 1; i < words.size(); i++) {
                String nextWord = words.get(i);

                if (nextWord.startsWith(prevWord)) {
                    words.remove(index);
                    index = i - 1;
                } else {
                    index++;
                }
                break;
            }
        }

        System.out.println(words.size());
    }

    private static List<String> initWords(BufferedReader bufferedReader, int n) throws IOException {
        List<String> words = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String word = bufferedReader.readLine();
            words.add(word);
        }
        words.sort(String::compareTo);
        return words;
    }
}

/*
 * 다른 사람의 좋은 접근이라고 생각하는 풀이
 *      int N = Integer.parseInt(br.readLine());

		String[] str = new String[N];
		for (int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}

		Arrays.sort(str);

		int cnt = N;
		for (int i = 0; i < N - 1; i++) {
			int min = Math.min(str[i].length(), str[i + 1].length());
			if (str[i].substring(0, min).equals(str[i + 1].substring(0, min))) {
				cnt--;
			}
		}

		System.out.println(cnt);
 */
