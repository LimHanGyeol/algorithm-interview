package algorithm.stringhandleing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveMateTest {

    @Test
    void testRemoveMate() {
        // given
        String s = "baabaa";

        // when
        int result = new RemoveMate().calculate(s);

        // then
        assertThat(result).isOne();
    }

    @Test
    void invalidRemoveMate() {
        // given
        String s = "cdcd";

        // when
        int result = new RemoveMate().calculate(s);

        // then
        assertThat(result).isZero();
    }
}
