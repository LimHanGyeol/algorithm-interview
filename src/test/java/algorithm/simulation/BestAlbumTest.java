package algorithm.simulation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BestAlbumTest {

    @Test
    void test() {
        // given
        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[]{500, 600, 150, 800, 2500};

        // when
        int[] results = new BestAlbum().solution(genres, plays);

        // then
        assertThat(results).containsExactly(4, 1, 3, 0);
    }
}
