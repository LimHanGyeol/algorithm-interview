package algorithm.structure.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxHeap {

    public static void main(String[] args) {
        Heap heap = new Heap(15);
        heap.insert(10);
        heap.insert(8);
        heap.insert(5);
        heap.insert(4);
        System.out.println(heap);

        heap.insert(20);
        System.out.println(heap);

        heap.pop();
        System.out.println(heap);
    }

    static class Heap {
        private List<Integer> heapList;

        public Heap(int data) {
            heapList = new ArrayList<>();

            heapList.add(null);
            heapList.add(data);
        }

        private boolean insert(int data) {
            if (heapList == null) {
                heapList = new ArrayList<>();

                heapList.add(null);
                heapList.add(data);
                return true;
            }

            heapList.add(data);
            int insertedIndex = heapList.size() - 1;
            while (isMoveUp(insertedIndex)) {
                int parentIndex = insertedIndex / 2;
                Collections.swap(heapList, insertedIndex, parentIndex);
                insertedIndex = parentIndex;
            }
            return true;
        }

        private boolean isMoveUp(int insertedIndex) {
            if (insertedIndex <= 1) {
                return false;
            }
            int parentIndex = insertedIndex / 2;
            return heapList.get(insertedIndex) > heapList.get(parentIndex);
        }

        public Integer pop() {
            if (heapList == null) {
                return null;
            }
            int returnedData = heapList.get(1);
            int lastIndex = heapList.size() - 1;
            heapList.set(1, heapList.get(lastIndex));
            heapList.remove(lastIndex);
            int poppedIndex = 1;

            while (isMoveDown(poppedIndex)) {
                int leftChildPoppedIndex = poppedIndex * 2;
                int rightChildPoppedIndex = (poppedIndex * 2) + 1;

                // CASE2: 오른쪽 자식 노드만 없을 때
                if (rightChildPoppedIndex >= heapList.size()) {
                    if (heapList.get(poppedIndex) < heapList.get(lastIndex)) {
                        Collections.swap(heapList, poppedIndex, lastIndex);
                        poppedIndex = leftChildPoppedIndex;
                    }
                } else { // CASE3: 왼쪽, 오른쪽 자식 노드가 모두 있을 때
                    if (heapList.get(leftChildPoppedIndex) > heapList.get(rightChildPoppedIndex)) {
                        if (heapList.get(poppedIndex) < heapList.get(leftChildPoppedIndex)) {
                            Collections.swap(heapList, poppedIndex, leftChildPoppedIndex);
                            poppedIndex = leftChildPoppedIndex;
                        }
                    } else {
                        if (heapList.get(poppedIndex) < heapList.get(rightChildPoppedIndex)) {
                            Collections.swap(heapList, poppedIndex, rightChildPoppedIndex);
                            poppedIndex = rightChildPoppedIndex;
                        }
                    }
                }
            }
            return returnedData;
        }

        private boolean isMoveDown(int poppedIndex) {
            int leftChildPoppedIndex = poppedIndex * 2;
            int rightChildPoppedIndex = (poppedIndex * 2) + 1;

            // CASE1: 왼쪽 자식 노드도 없을 때 (자식 노드가 하나도 없을 때)
            if (leftChildPoppedIndex >= heapList.size()) {
                return false;
            }
            // CASE2: 오른쪽 자식 노드만 없을 때
            if (rightChildPoppedIndex >= heapList.size()) {
                return heapList.get(poppedIndex) < heapList.get(leftChildPoppedIndex);
            }
            // CASE3: 왼쪽, 오른쪽 자식 노드가 모두 있을 때
            if (heapList.get(leftChildPoppedIndex) > heapList.get(rightChildPoppedIndex)) {
                return heapList.get(poppedIndex) < heapList.get(leftChildPoppedIndex);
            } else {
                return heapList.get(poppedIndex) < heapList.get(rightChildPoppedIndex);
            }
        }

        @Override
        public String toString() {
            return "Heap{" +
                    "heapList=" + heapList +
                    '}';
        }
    }
}
