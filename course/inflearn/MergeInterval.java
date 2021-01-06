/**
 * 쉽게 풀어보는 코딩 테스트 기출문제
 * String & Array
 * MergeInterval
 */
class Solution {

    public static void main(String[] args) {
        Interval interval1 = new Interval(1, 3);
        Interval interval2 = new Interval(2, 6);
        Interval interval3 = new Interval(8, 10);
        Interval interval4 = new Interval(15, 18);

        List<Interval> list = new ArrayList<>();
        list.add(interval1);
        list.add(interval2);
        list.add(interval3);
        list.add(interval4);

        System.out.println(merge(list)); // (1, 6), (8, 10), (15, 18)
    }

    private List<Interval> getMergeInterval(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return intervals;
        }

        List<Interval> results = new ArrayList<>();

        intervals.sort((a, b) -> a.getStart() - b.getStart());

        Interval before = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            before = merge(results, before, current);
        }

        if (!results.contains(before)) {
            results.add(before);
        }

        return results;
    }

    private Interval merge(List<Interval> results, Interval before, Interval current) {
        if (current.getStart() <= before.getEnd()) {
            before.setEnd(Math.max(before.getEnd(),current.getEnd()));
            return before;
        }
        results.add(before);
        return current;
    }

}
