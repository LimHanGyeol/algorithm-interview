package algorithm.stringhandleing;

import java.util.ArrayList;
import java.util.List;

import static algorithm.util.IntegerParser.toInt;

/**
 * programmers
 * Level2
 * 소수 찾기
 */
public class FindPrimeNumber {

    private static List<Integer> results;
    private static boolean[] visited;

    public int solution(String inputNumber) {
        int size = inputNumber.length();
        results = new ArrayList<>();
        visited = new boolean[size];
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = toInt(inputNumber.charAt(i) + "");
        }

        //자리 수 마다 해당 배열을 perm 메서드에 보낸다.
        for (int i = 1; i <= size; i++) {    //1개 부터 numbers의 길이까지 숫자의 순열을 구한다.
            int[] rSize = new int[i];
            findPermutation(numbers, rSize, i, 0);
        }
        return results.size();
    }

    // n개중 r개를 뽑는다. nPr
    public void findPermutation(int[] numbers, int[] rSize, int r, int depth) {
        if (depth == r) {
            //0이먼저오는지, 소수인지, 이미 results에 있는지 확인
            StringBuilder casesNumber = new StringBuilder();
            for (int number : rSize) {
                casesNumber.append(number);
            }

            int number = toInt(casesNumber.toString());
            if (isPrimeNumber(number)) {
                if (!results.contains(number)) {
                    results.add(number);
                }
            }
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                rSize[depth] = numbers[i];
                findPermutation(numbers, rSize, r, depth + 1);
                visited[i] = false;
                rSize[depth] = 0;
            }
        }
    }

    public boolean isPrimeNumber(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
