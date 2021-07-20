package algorithm.simulation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PhoneNumberListTest {

    @Test
    void testPhoneNumberListV1() {
        // given
        String[] phoneBook = new String[]{"119", "97674223", "1195524421"};

        // when
        boolean result = new PhoneNumberList().solution(phoneBook);

        // then
        assertThat(result).isFalse();
    }

    @Test
    void testPhoneNumberListV2() {
        // given
        String[] phoneBook = new String[]{"123", "456", "789"};

        // when
        boolean result = new PhoneNumberList().solution(phoneBook);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void testPhoneNumberListV3() {
        // given
        String[] phoneBook = new String[]{"12","123","1235","567","88"};

        // when
        boolean result = new PhoneNumberList().solution(phoneBook);

        // then
        assertThat(result).isFalse();
    }

    @Test
    void testPhoneNumberListV4() {
        // given
        String[] phoneBook = new String[]{"1234", "1235", "567"};

        // when
        boolean result = new PhoneNumberList().solution(phoneBook);

        // then
        assertThat(result).isTrue();
    }
}
