// 자바로 쉽게 배우는 알고리즘
// Selection (선택 알고리즘)
class Solution {

    public static void main(String[] args) {
        int[] array = new int[]{48, 12, 70, 38, 75, 67, 96, 52, 81};
        int k = 5;
        // 67
        System.out.println(selection(array, 0, array.length - 1, k));
    }

    // 선택 알고리즘의 시간 복잡도는 O(n) 이다.
    // 배열 array[startIndex .. endIndex] 내에서 k 번째 작은 요소를 찾아서 반환한다.
    private int selection(int[] array, int startIndex, int endIndex, int k) {
        // 배열 array[startIndex .. endIndex] 를 분할할 지수를 계산한다.
        int pivotPoint = partition(array, startIndex, endIndex);

        // array[pivotPoint] 보다 작거나 같은 요소들의 수를 계산한다.
        int smallElements = (pivotPoint - 1) - startIndex + 1;

        // array[pivotPoint] 보다 작거나 같은 요소들의 small 그룹에서 찾는다.
        if (k <= smallElements) {
            return selection(array, startIndex, pivotPoint - 1, k);
        }
        // k 번째 작은 요소를 리턴한다.
        if (k == smallElements + 1) {
            return array[pivotPoint];
        }
        // array[pivotPoint] 보다 큰 요소들의 large 그룹에서 찾는다.
        return selection(array, pivotPoint + 1, endIndex, (k - smallElements) - 1);
    }

    // 배열 array[startIndex .. endIndex] 를 array[startIndex] 를 기준으로 하여 분할한다.
    // array[startIndex] 보다 큰 요소들을 array[first] 의 오른쪽에 배치하고
    // 나머지 요소들을 array[startIndex] 의 왼쪽에 배치한다.
    private int partition(int[] array, int startIndex, int endIndex) {
        int nextIndex = startIndex + 1;
        int lastIndex = endIndex;
        int numberContainer;

        // 배열을 array[startIndex] 를 기준으로 하여 array[startIndex] 보다
        // 큰 요소는 배열의 오른쪽으로 옮기고 작거나 같은 요소는 배열의 왼쪽으로 옮긴다.
        while (nextIndex <= lastIndex) {
            if (array[nextIndex] <= array[startIndex]) {
                nextIndex++;
            } else if (array[startIndex] < array[lastIndex]) {
                lastIndex--;
            } else {
                numberContainer = array[nextIndex];
                array[nextIndex] = array[lastIndex];
                array[lastIndex] = numberContainer;
                nextIndex++;
                lastIndex--;
            }
        }

        // array[startIndex] 를 array[startIndex] 보다
        // 작거나 같은 요소들의 구역의 마지막 요소와 교환한다.
        numberContainer = array[startIndex];
        array[startIndex] = array[lastIndex];
        array[lastIndex] = numberContainer;

        return lastIndex;
    }

}
