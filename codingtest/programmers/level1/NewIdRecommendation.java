/**
 * 프로그래머스
 * Level1. 2021 카카오 블라인드 채용
 * 신규 아이디 추천
 */
class Solution {

    public static void main(String[] args) {
        String input = "...!@BaT#*..y.abcdefghijklm";
        System.out.println(getRecommendationId(input)); // bat.y.abcdefghi
    }

    public String getRecommendationId(String inputId) {
        String firstResult = validateFirstConvention(inputId);
        String secondResult = validateSecondConvention(firstResult);
        String thirdResult = validateThirdConvention(secondResult);
        String fourthResult = validateFourthConvention(thirdResult);
        String fifthResult = validateFifthConvention(fourthResult);
        String sixthResult = validateSixthConvention(fifthResult);
        return validateSeventhConvention(sixthResult);
    }

    private String validateFirstConvention(String inputId) {
        return inputId.toLowerCase();
    }

    private String validateSecondConvention(String firstResult) {
        char[] idElements = firstResult.toCharArray();
        StringBuilder result = new StringBuilder();

        for (char element : idElements) {
            if (element == 45 || element == 46 || element == 95) {
                result.append(element);
            }
            if (element >= 97 && element <= 122) {
                result.append(element);
            } else if (element >= 48 && element <= 57) {
                result.append(element);
            }
        }
        return result.toString();
    }

    private String validateThirdConvention(String secondResult) {
        char[] idElements = secondResult.toCharArray();
        StringBuilder result = new StringBuilder();
        int dotCount = 0;

        for (char element : idElements) {
            if (element == 46) {
                dotCount++;
                continue;
            }
            if (dotCount > 1 || dotCount == 1) {
                result.append(".");
                dotCount = 0;
            }
            if (dotCount == 0) {
                result.append(element);
            }
        }
        return result.toString();
    }

    private String validateFourthConvention(String thirdResult) {
        int lastIndex = thirdResult.length() - 1;
        char[] idElements = thirdResult.toCharArray();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < thirdResult.length(); i++) {
            if ((i == 0 && idElements[i] == 46) || (i == lastIndex && newId.charAt(i) == 46)) {
                continue;
            }
            result.append(idElements[i]);
        }
        return result.toString();
    }

    private String validateFifthConvention(String fourthResult) {
        if (fourthResult.length() == 0) {
            return "a";
        }
        return fourthResult;
    }

    private String validateSixthConvention(String fifthResult) {
        String result = fifthResult;
        if (result.length() > 15) {
            result = fifthResult.substring(0, 15);

            int lastIndex = result.length() - 1;

            if (result.charAt(lastIndex) == 46) {
                result = result.substring(0, 14);
            }
        }
        return result;
    }

    private String validateSeventhConvention(String sixthResult) {
        int length = sixthResult.length();
        if (sixthResult.length() < 3) {
            if (length == 2) {
                String firstCharacter = String.valueOf(sixthResult.charAt(0));
                String lastCharacter = String.valueOf(sixthResult.charAt(1));
                return firstCharacter + lastCharacter + lastCharacter;
            }
            if (length == 1) {
                String lastCharacter = String.valueOf(sixthResult.charAt(0));
                return lastCharacter + lastCharacter + lastCharacter;
            }
        }
        return sixthResult;
    }

}
