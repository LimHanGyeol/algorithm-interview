/**
 * 쉽게 풀어보는 코딩 테스트 기출문제
 * String & Array
 * MeetingRoom, MergeInterval 문제를 풀기 위한 객체
 */
class Interval {

    private int start;
    private int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return start + " " + end;
    }

}
