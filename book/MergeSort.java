// 자바로 쉽게 배우는 알고리즘
// 합병 정렬 (Merge Sort)
// 재귀를 이용한 합병 정렬이다.
// 재귀는 입력크기가 커지면 실행시간이 증가한다.
// 스택을 이용한 합병 정렬도 알아봄이 좋다.
class Solution {

    public static void main(String[] args) {
        int[] array = new int[] {91, 82, 13, 85, 68, 70, 98, 24};
        // 13, 24, 68, 70, 82, 85, 91, 98
        System.out.println(Arrays.toString(mergeSort(array, 0, array.length - 1)));
    }

    // MergeSort 의 시간 복잡도는 O(n log n) 이다.
    private int[] mergeSort(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            // 중앙 요소를 계산한다.
            int middleIndex = (startIndex + endIndex) / 2;

            // 왼쪽 절반 array[startIndex .. middleIndex]를 합병 정렬을 이용하여 정렬한다.
            array = mergeSort(array, startIndex, middleIndex);

            // 오른쪽 절반 array[middleIndex + 1 .. endIndex]를 합병 정렬을 이용하여 정렬한다.
            array = mergeSort(array, middleIndex + 1, endIndex);

            // 정렬된 array[startIndex .. middleIndex]와 그 외 array[middleIndex + 1 .. endIndex] 를 합병한다.
            return merge(array, startIndex, middleIndex, endIndex);
        }
        return array;
    }

    // 정렬된 array를 합병한다.
    private int[] merge(int[] array, int startIndex, int middleIndex, int endIndex) {
        // 정렬된 결과를 저장하기 위한 배열
        int[] sortedArray = new int[endIndex + 1];

        int i = startIndex;
        int j = middleIndex + 1;
        int index = startIndex;

        // 왼쪽 절반의 요소와 오른쪽 절반의 요소를 순서대로 비교하여 작은 값을 배열 sortedArray 로 옮긴다.
        while (i <= middleIndex && j <= endIndex) {
            if (array[i] <= array[j]) {
                sortedArray[index] = array[i];
                i++;
            } else {
                sortedArray[index] = array[j]
                j++;
            }
            index++;
        }

        if (i > middleIndex) {
            // 오른쪽 절발에 남아있는 요소들을 sortedArray 로 옮긴다.
            for (int k = j; k <= endIndex; k++) {
                sortedArray[index] = array[k];
                index++;
            }
        } else {
            // 왼쪽 절반에 남아있는 요소들을 sortedArray 로 옮긴다.
            for (int k = i; k <= middleIndex; k++) {
                sortedArray[index] = array[k];
                index++;
            }
        }

        // 배열 sortedArray 를 배열 array로 옮긴다.
        for (int k = startIndex; k <= endIndex; k++) {
            array[k] = sortedArray[k];
        }

        return array;
    }

}
