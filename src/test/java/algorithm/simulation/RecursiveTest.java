package algorithm.simulation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RecursiveTest {

    @Test
    @DisplayName("계산할 수 있는 경우의 수 횟수를 구하는 식")
    void recursiveCall() {
        // given
        int n = 5;

        // when
        int result = new Recursive().recursive(n);

        // then
        assertThat(result).isEqualTo(13);
    }

    @Test
    @DisplayName("재귀를 이용한 팩토리얼")
    void factorial_recursive() {
        // given
        int n = 10;

        // when
        int result = new Recursive().factorial(n);

        // then
        assertThat(result).isEqualTo(55);
    }

    @Test
    @DisplayName("DP를 이용한 팩토리얼")
    void factorial_dynamic() {
        // given
        int n = 10;

        // when
        int result = new Recursive().dynamicFactorial(n);

        // then
        assertThat(result).isEqualTo(55);
    }
}
