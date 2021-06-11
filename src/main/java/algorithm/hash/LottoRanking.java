package algorithm.hash;

import java.util.*;

/**
 * Programmers
 * Level1
 * 로또의 최고 순위와 최저 순위
 */
public class LottoRanking {

    public int[] solution(int[] lottos, int[] win_nums) {
        Map<Integer, Integer> lottoRank = initLottoRanking();

        int winCount = 0;
        int zeroCount = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount++;
                continue;
            }
            for (int winNum : win_nums) {
                if (lotto == winNum) {
                    winCount++;
                }
            }
        }

        if (zeroCount == 0 && winCount == 0) {
            return new int[]{6, 6};
        }
        if (zeroCount == 6) {
            return new int[]{1, 6};
        }

        int minRank = getMinRank(lottoRank, winCount);
        int maxRank = getMaxRank(lottoRank, winCount, zeroCount);

        return new int[]{maxRank, minRank};
    }

    private int getMinRank(Map<Integer, Integer> lottoRank, int winCount) {
        if (lottoRank.containsValue(winCount)) {
            return lottoRank.get(winCount);
        }
        return 6; // 반례를 위해 6등 설정
    }

    private int getMaxRank(Map<Integer, Integer> lottoRank, int winCount, int zeroCount) {
        int mayBeMaxRank = winCount + zeroCount;
        if (lottoRank.containsValue(mayBeMaxRank)) {
            return lottoRank.get(mayBeMaxRank);
        }
        return 6; // 반례를 위해 6등 설정
    }

    /**
     * 알 수 있는 정보는 맞춘 번호인데
     * key에 rank를 value에 맞춘 번호를 설정할 경우 key를 구하기 위한 추가 연산이 필요함.
     * Ex)
     * map.get(key) - 몇 등인지 파악해야 하는 반복분 필요
     * map.containsKey(key) - 몇 등인지 파악해야 하는 반복문 필요
     * map.containsValue(value) - boolean 타입이여서 key를 파악해야 하는 반복문 필요
     *
     * 위의 이유로 key에 맞춘 숫자를, value에 rank를 설정하여 상수 시간 복잡도로 접근하도록 생각한다.
     * key : 맞춘 숫자
     * value : 등 수
     */
    private Map<Integer, Integer> initLottoRanking() {
        Map<Integer, Integer> lottoRank = new HashMap<>();
        lottoRank.put(6, 1);
        lottoRank.put(5, 2);
        lottoRank.put(4, 3);
        lottoRank.put(3, 4);
        lottoRank.put(2, 5);
        lottoRank.put(1, 6);
        return lottoRank;
    }
}
