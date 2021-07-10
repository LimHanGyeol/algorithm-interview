package algorithm.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * Merge Sort
 * 병합 정렬
 */
public class MergeSort {

    public static void main(String[] args) {
        // given
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add((int) (Math.random() * 100 + 1));
        }

        // when
        List<Integer> results = new MergeSort().mergeSplitList(numbers);

        // then
        System.out.println(results);
    }

    public List<Integer> mergeSplitList(List<Integer> numbers) {
        if (numbers.size() <= 1) {
            return numbers;
        }
        int medium = numbers.size() / 2;

        List<Integer> leftList = mergeSplitList(new ArrayList<>(numbers.subList(0, medium))); // 0 ~ medium - 1
        List<Integer> rightList = mergeSplitList(new ArrayList<>(numbers.subList(medium, numbers.size())));

        return mergeArray(leftList, rightList);
    }

    private List<Integer> mergeArray(List<Integer> leftList, List<Integer> rightList) {
        List<Integer> mergedList = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        // Case 1 : left, right 둘 다 있을 때
        while (leftList.size() > leftIndex && rightList.size() > rightIndex) {
            if (leftList.get(leftIndex) > rightList.get(rightIndex)) {
                mergedList.add(rightList.get(rightIndex));
                rightIndex += 1;
            } else {
                mergedList.add(leftList.get(leftIndex));
                leftIndex += 1;
            }
        }

        // Case 2 : right 데이터가 없을 때
        while (leftList.size() > leftIndex) {
            mergedList.add(leftList.get(leftIndex));
            leftIndex += 1;
        }

        // Case 3 : left 데이터가 없을 때
        while (rightList.size() > rightIndex) {
            mergedList.add(rightList.get(rightIndex));
            rightIndex += 1;
        }

        return mergedList;
    }
}
