/**
 * 프로그래머스
 * Level2
 * 스킬 트리
 */
class Solution {

    @Test
    void name() {
        String skill = "CBDK"; // B", "CBKD", "IJCB", "LMDK"]
        String[] skillTrees = new String[]{"CB", "CXYB", "BD", "AECD", "ABC", "AEX", "CDB", "CBKD", "IJCB", "LMDK"};
        System.out.println(solution(skill, skillTrees));
    }

    private int solution(String skill, String[] skill_trees) {
        int result = skill_trees.length;
        int beforeIndex = 0;
        int currentIndex = 0;

        for (String skill_tree : skill_trees) {
            beforeIndex = skill_tree.indexOf(skill.charAt(0));

            for (int i = 1; i < skill.length(); i++) {
                currentIndex = skill_tree.indexOf(skill.charAt(i));

                if ((beforeIndex > currentIndex && currentIndex != -1) || (beforeIndex == -1 && currentIndex != -1)) {
                    result--;
                    break;
                }
                beforeIndex = currentIndex;
            }
        }
        return result;
    }

}
