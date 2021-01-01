import java.util.Arrays;
import java.util.Comparator;

/**
 * 쉽게 풀어보는 코딩 테스트 기출문제
 * String & Array
 * MeetingRoom
 */
class Solution {

    public static void main(String[] args) {
        Interval interval1 = new Interval(15, 20);
        Interval interval2 = new Interval(5, 10);
        Interval interval3 = new Interval(0, 30);

        Interval[] intervals = new Interval[]{interval1, interval2, interval3};
        System.out.println(solve(intervals));
    }

    private boolean solve(Interval[] intervals) {
        if (intervals == null) {
            return false;
        }

        sortIntervals(intervals);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1].getEnd() > intervals[i].getStart()) {
                return false;
            }
        }

        return true;
    }

    private void sortIntervals(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.getStart() - o2.getStart();
            }
        });
    }

}
