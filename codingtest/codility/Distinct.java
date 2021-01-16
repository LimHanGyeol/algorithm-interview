/**
 * Codility
 * Sorting
 * Distinct
 */
class Solution {

    public static void main(String[] args) {
        int[] array = new int[]{2, 1, 1, 2, 3, 1};
        System.out.println(getDistinctArray(array));
    }

    public int getDistinctArray(int[] array) {
        Set<Integer> numbers = new HashSet<>();

        for (int number : array) {
            numbers.add(number);
        }

        return numbers.size();
    }

    /**
     * Stream API 이용 - 특정 inputCase 타임아웃 나옴
     */
    public int getDistinctArray(int[] array) {
        return (int) Arrays.stream(array)
                .distinct()
                .count();
    }

    /**
     * 정렬 이용
     */
    public int getDistinctArray(int[] array) {
        int count = 1;
        Arrays.sort(array);
        int length = array.length;

        for (int i = 1; i < length; i++) {
            if (array[i - 1] != array[i]) {
                count++;
            }
        }

        return count;
    }

}
