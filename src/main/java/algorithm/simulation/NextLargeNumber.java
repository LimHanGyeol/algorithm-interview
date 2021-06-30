package algorithm.simulation;

/**
 * Programmers
 * Level2
 * 다음 큰 숫자
 */
public class NextLargeNumber {

    public int solutionV1(int n) {
        String nToBinary = Integer.toBinaryString(n);
        char[] binaryElements = nToBinary.toCharArray();
        int nCount = findElementIsOneCount(binaryElements);

        int result = 0;

        int increase = 1;
        while (true) {
            int nextNumber = n += increase;
            String nextNumberToBinary = Integer.toBinaryString(nextNumber);
            char[] nextNumberBinaryElements = nextNumberToBinary.toCharArray();
            int nextNumberCount = findElementIsOneCount(nextNumberBinaryElements);

            if (nCount == nextNumberCount) {
                result = nextNumber;
                break;
            }
        }

        return result;
    }

    private int findElementIsOneCount(char[] binaryElements) {
        int nCount = 0;
        for (char element : binaryElements) {
            if (element == '1') {
                nCount++;
            }
        }
        return nCount;
    }

    /**
     * int 값을 binary로 변환 후 1의 개수를 반환하는 함수인 bitCount를 알게됐다.
     * 이를 사용하여 아래와 같이 코드를 수정했다.
     */
    public int solutionV2(int n) {
        int nCount = Integer.bitCount(n);

        int result;
        int increase = 1;
        while (true) {
            int nextNumber = n += increase;
            int nextNumberCount = Integer.bitCount(nextNumber);

            if (nCount == nextNumberCount) {
                result = nextNumber;
                break;
            }
        }

        return result;
    }
}
