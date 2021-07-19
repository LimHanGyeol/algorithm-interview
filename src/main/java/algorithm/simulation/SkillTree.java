package algorithm.simulation;

/**
 * programmers
 * Level2 - Simulation
 * 스킬트리
 */
public class SkillTree {

    // CBD
    // BACDE, CBADF, AECB, BDA
    public int solution(String skill, String[] skillTrees) {
        int count = skillTrees.length;

        for (String skillTree : skillTrees) {
            // 배워야할 스킬의 첫번째 스킬이 존재하는 위치 확인
            int prevSkillIndex = skillTree.indexOf(skill.charAt(0));

            for (int j = 1; j < skill.length(); j++) { // 배워야할 스킬의 두번째 스킬부터 탐색
                // indexOf를 사용할때 검색하는 값이 없을 경우 -1이 반환된다.
                int currentSkillIndex = skillTree.indexOf(skill.charAt(j));

                if (currentSkillIndex != -1 && prevSkillIndex > currentSkillIndex) {
                    count--;
                    break;
                }

                // 스킬 트리에서 선행 스킬을 배우지 않았는데(-1), 다음 스킬을 배운 경우
                if (prevSkillIndex == -1 && currentSkillIndex != -1) {
                    count--;
                    break;
                }
                prevSkillIndex = currentSkillIndex;
            }
        }
        return count;
    }
}
