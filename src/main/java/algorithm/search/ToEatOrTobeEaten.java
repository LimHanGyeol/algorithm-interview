package algorithm.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import static algorithm.util.InputReader.init;
import static algorithm.util.IntegerParser.toInt;

/**
 * BaekJoon. 7795
 * 먹을 것인가 먹힐 것인가
 * BinarySearch, Sort, Two Pointer
 */
public class ToEatOrTobeEaten {

    private static int testCase;
    private static String[] a;
    private static String[] b;
    private static int aLength;
    private static int bLength;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = init();
        testCase = toInt(bufferedReader.readLine());

        for (int i = 0; i < testCase; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            aLength = toInt(input[0]);
            bLength = toInt(input[1]);

            a = bufferedReader.readLine().split(" ");
            int[] arrayA = new int[aLength];
            for (int sizeA = 0; sizeA < aLength; sizeA++) {
                arrayA[sizeA] = toInt(a[sizeA]);
            }

            b = bufferedReader.readLine().split(" ");
            int[] arrayB = new int[bLength];
            for (int sizeB = 0; sizeB < bLength; sizeB++) {
                arrayB[sizeB] = toInt(b[sizeB]);
            }

            Arrays.sort(arrayB);
            process(arrayA, arrayB);
        }
    }

    private static void process(int[] a, int[] b) {
        int count = 0;
        for (int i = 0; i < aLength; i++) {
            // a[i]를 선택했을 때, b에서는 a[i]보다 작은게 몇 개나 있는지 count 하기
            count += lowerBound(b, 0, bLength - 1, a[i]);
        }
        System.out.println(count);
    }

    private static int lowerBound(int[] a, int l, int r, int x) {
        // a[L...R] 에서 x 미만의 수(x보다 작은 수) 중에서 제일 오른쪽 인덱스를 return
        // 없다면 L - 1을 return
        int result = l;
        while (l <= r) {
            int middle = (l + r) / 2;

            if (a[middle] < x) {
                result = middle + 1;
                l = middle + 1;
            } else {
                r = middle - 1;
            }
        }
        return result;
    }
}
