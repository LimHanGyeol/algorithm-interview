// 자바로 쉽게 배우는 알고리즘
// 힙 정렬 (추가 공부 필요)
class Solution {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 6, 4, 8, 7};
        // 오름차순으로 정렬된 배열
        System.out.println(Arrays.toString(heapSort(array))); // [1, 2, 4, 6, 7, 8]
    }

    /**
     * 힙 정렬 알고리즘의 입력의 크기는 배열의 크기인 array.length 이다.
     * 힙 정렬의 시간 복잡도는 O(n log n) 이다.
     */
    private int[] heapSort(int[] array) {
        int endHeap = array.length - 1;

        // 주어진 배열을 Heap 으로 만든다.
        createHeap(array, endHeap);

        // Heap 에서 최대값을 제거하고 남은 트리를 다시 Heap 으로 만든다.
        while (endHeap > 1) {
            // array[1] 과 array[endHeap] 을 교환한다.
            int container = array[1];
            array[1] = array[endHeap];
            array[endHeap] = container;

            // Heap 에서 최대값을 제거한다.
            endHeap = endHeap - 1;

            // 남은 트리를 다시 Heap 으로 만든다.
            pushDown(array, 1, endHeap);
        }
        return array;
    }

    // array[1 . . endHeap] 을 Heap 으로 만든다.
    private void createHeap(int[] array, int endHeap) {
        int baseNode = (array.length - 1) / 2 + 1;

        while (baseNode > 1) {
            baseNode = baseNode - 1;
            int x = baseNode;

            // x 에서 Heap 조건이 만족될 때까지 array[x] 를 트리의 아래 층으로 내려보낸다.
            pushDown(array, x, endHeap);
        }
    }

    // array[x]를 Heap 조건이 만족될 때까지 트리의 아래층으로 내려보낸다.
    private void pushDown(int[] array, int x, int endHeap) {
        int y = findLarger(array, x, endHeap);

        while (array[x] < array[y]) {
            int container = array[x];
            array[x] = array[y];
            array[y] = container;

            x = y;
            y = findLarger(array, x, endHeap);
        }
    }

    // array[x] 보다 더 큰 값을 가지는 x 의 자식 노드의 지수를 구한다.
    private int findLarger(int[] array, int x, int endHeap) {
        int y = 0;

        if (2 * x + 1 <= endHeap) {
            // 자식 노드가 둘 다 있는 경우
            y = bothChildNodes(array, x, endHeap, y);
        }
        return y;
    }

    private int bothChildNodes(int[] array, int x, int endHeap, int y) {
        if (array[2 * x] > array[x] || array[2 * x + 1] > array[x]) {
            // array[x] 보다 더 큰 값을 가지는 자식 노드의 지수를 구한다.
            y = getNodeGreaterThanX(array, x);
        }
        if (2 * x <= endHeap && array[2 * x] > array[x]) { // 자식 노드가 하나만 있는 경우
            y = 2 * x;
        }
        return y;
    }

    private int getNodeGreaterThanX(int[] array, int x) {
        if (array[2 * x] >= array[2 * x + 1]) {
            return 2 * x;
        }
        return 2 * x + 1;
    }

}
