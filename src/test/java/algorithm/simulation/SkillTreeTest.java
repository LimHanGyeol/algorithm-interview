package algorithm.simulation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SkillTreeTest {

    @Test
    void testSkillTree() {
        // given
        String skill = "CBD";
        String[] skillTrees = new String[]{"BACDE", "CBADF", "AECB", "BDA"};

        // when
        int result = new SkillTree().solution(skill, skillTrees);

        // then
        assertThat(result).isEqualTo(2);
    }
}
