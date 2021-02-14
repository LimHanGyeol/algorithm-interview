import java.util.Arrays;
/**
 * 프로그래머스
 * Level 1
 * 비밀 지도
 */
class Solution {

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = new int[]{9, 20, 28, 18, 11};
        int[] arr2 = new int[]{30, 1, 21, 17, 28};
        System.out.println(Arrays.toString(getSecretMap(n, arr1, arr2)));
    }

    public String[] getSecretMap(int n, int[] arr1, int[] arr2) {
        String[] binaryArray1 = parseToBinaryArray(n, arr1);
        String[] binaryArray2 = parseToBinaryArray(n, arr2);
        String[] results = mergeArray(n, binaryArray1, binaryArray2);
        return getResults(results);
    }

    private String[] getResults(String[] results) {
        for (int i = 0; i < results.length; i++) {
            char[] characters = results[i].toCharArray();

            for (int j = 0; j < characters.length; j++) {
                if (characters[j] == '1') {
                    characters[j] = '#';
                } else {
                    characters[j] = ' ';
                }
            }
            results[i] = String.valueOf(characters);
        }
        return results;
    }

    private String[] mergeArray(int n, String[] binaryArray1, String[] binaryArray2) {
        String[] results = new String[n];

        for (int i = 0; i < binaryArray1.length; i++) {
            char[] characters = binaryArray1[i].toCharArray();
            char[] characters2 = binaryArray2[i].toCharArray();

            for (int j = 0; j < characters.length; j++) {
                if (characters2[j] == '1') {
                    characters[j] = '1';
                }
            }
            results[i] = String.valueOf(characters);
        }

        return results;
    }

    private String[] parseToBinaryArray(int n, int[] array) {
        String[] binaryArray = new String[n];

        for (int i = 0; i < n; i++) {
            String binaryString = parseToBinary(n, array[i]);

            if (!binaryString.isBlank() && binaryString.length() == n) {
                binaryArray[i] = binaryString;
            }
        }

        return binaryArray;
    }

    private String parseToBinary(int n, int number) {
        StringBuffer result = new StringBuffer();

        while (number > 0) {
            result.insert(0, (number % 2));
            number /= 2;
        }

        if (result.length() != n) {
            addZeroCharacter(n, result);
        }
        return result.toString();
    }

    private void addZeroCharacter(int n, StringBuffer binaryString) {
        int remainingLength = n - binaryString.length();

        for (int i = 0; i < remainingLength; i++) {
            binaryString.insert(0, "0");
        }
    }

}
