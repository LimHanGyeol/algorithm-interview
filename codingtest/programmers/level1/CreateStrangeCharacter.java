class Solution {

    public String solution(String input) {
        int noneSpace = 0;
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < input.length(); i++) {
            String character = input.substring(i, i + 1);
            noneSpace = parseCharacter(noneSpace, result, character);
        }

        return result.toString();
    }

    private int parseCharacter(int noneSpace, StringBuffer result, String character) {
        if (character.equals(" ")) {
            result.append(character);
            return 0;
        }
        if (!character.isEmpty()) {
            result.append(toUpdateCase(noneSpace, character));
            noneSpace++;
        }
        return noneSpace;
    }

    private String toUpdateCase(int noneSpace, String character) {
        if (noneSpace % 2 == 0) {
            return character.toUpperCase();
        }
        return character.toLowerCase();
    }
}