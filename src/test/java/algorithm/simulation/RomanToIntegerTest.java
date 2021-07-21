package algorithm.simulation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RomanToIntegerTest {

    @Test
    void testRomanToIntegerV1() {
        // given
        String input = "III";

        // when
        int result = new RomanToInteger().romanToInt(input);

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void testRomanToIntegerV2() {
        // given
        String input = "IV";

        // when
        int result = new RomanToInteger().romanToInt(input);

        // then
        assertThat(result).isEqualTo(4);
    }

    @Test
    void testRomanToIntegerV3() {
        // given
        String input = "IX";

        // when
        int result = new RomanToInteger().romanToInt(input);

        // then
        assertThat(result).isEqualTo(9);
    }

    @Test
    void testRomanToIntegerV4() {
        // given
        String input = "LVIII";

        // when
        int result = new RomanToInteger().romanToInt(input);

        // then
        assertThat(result).isEqualTo(58);
    }

    @Test
    void testRomanToIntegerV5() {
        // given
        String input = "MCMXCIV";

        // when
        int result = new RomanToInteger().romanToInt(input);

        // then
        assertThat(result).isEqualTo(1994);
    }
}
