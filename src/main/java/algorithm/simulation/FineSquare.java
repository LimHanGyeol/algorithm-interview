package algorithm.simulation;

/**
 * Programmers
 * Level2
 * 멀쩡한 사각형
 */
public class FineSquare {

    public long solution(int w, int h) {
        long width = w;
        long height = h;
        return width * height - width - height + calculateGCD(width, height);
    }

    // 최대 공약수
    public long calculateGCD(long first, long second) {
        if (second == 0) {
            return first;
        }
        return calculateGCD(second, first % second);
    }
}
