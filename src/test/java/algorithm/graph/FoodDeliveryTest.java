package algorithm.graph;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FoodDeliveryTest {

    @Test
    void testFoodDeliveryV1() {
        // given
        int n = 5;
        int[][] road = new int[][]{ // 0, 1은 도로가 연결하는 두 마을의 번호 2는 걸리는 시간
                {1, 2, 1},
                {2, 3, 3},
                {5, 2, 2},
                {1, 4, 2},
                {5, 3, 1},
                {5, 4, 2}
        };
        int k = 3;

        // when
        int result = new FoodDelivery().solution(n, road, k);

        // then
        assertThat(result).isEqualTo(4);
    }

    @Test
    void testFoodDeliveryV2() {
        // given
        int n = 6;
        int[][] road = new int[][]{
                {1, 2, 1},
                {1, 3, 2},
                {2, 3, 2},
                {3, 4, 3},
                {3, 5, 2},
                {3, 5, 3},
                {5, 6, 1}
        };
        int k = 4;

        // when
        int result = new FoodDelivery().solution(n, road, k);

        // then
        assertThat(result).isEqualTo(4);
    }
}
