package algorithm.greedy;

/**
 * 이것이 취업을 위한 코딩 테스트다 with Python
 * Java
 * <p>
 * 거스름돈
 * Input
 * - 500, 100, 50, 10원 총 4가지의 동전이 있다.
 * - 손님에게 n원을 거슬러 줘야 한다.
 * Output
 * - 거슬러줘야할 동전의 최소 개수를 구하라.
 * - 단, 거슬러 줘야할 돈은 항상 10의 배수이다.
 * <p>
 * Ex
 * Input : 1260
 * Output : 6
 */
public class Change {

    public static void main(String[] args) {
        int n = 1260;
        int count = 0;
        int[] coinType = new int[]{500, 100, 50, 10};

        for (int coin : coinType) {
            count += n / coin;
            n %= coin;
        }
        System.out.println(count);
    }
}
