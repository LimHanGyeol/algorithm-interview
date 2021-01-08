import java.util.*;

/**
 * 프로그래머스
 * Level1
 * 모의고사
 */
class Solution {

    public static void main(String[] args) {
        int[] answer = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(mockTest(answer)));
    }

    private int[] mockTest(int[] answers) {
        List<Integer> students = initStudents();

        getRightAnswer(answers, students);

        List<Integer> outstandingStudents = getOutstandingStudents(students);

        return getResults(outstandingStudents);
    }

    private List<Integer> initStudents() {
        List<Integer> students = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            students.add(0);
        }
        return students;
    }

    private void getRightAnswer(int[] answers, List<Integer> students) {
        int[] student1 = new int[]{1, 2, 3, 4, 5};
        int[] student2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == student1[i % 5]) {
                students.set(0, students.get(0) + 1);
            }
            if (answers[i] == student2[i % 8]) {
                students.set(1, students.get(1) + 1);
            }
            if (answers[i] == student3[i % 10]) {
                students.set(2, students.get(2) + 1);
            }
        }
    }

    private List<Integer> getOutstandingStudents(List<Integer> students) {
        int maximumScore = Collections.max(students);
        List<Integer> outstandingStudents = new ArrayList<>();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i) == maximumScore) {
                outstandingStudents.add(i + 1);
            }
        }
        return outstandingStudents;
    }

    private int[] getResults(List<Integer> outstandingStudents) {
        int studentNumber = outstandingStudents.size();
        int[] results = new int[studentNumber];

        for (int i = 0; i < studentNumber; i++) {
            results[i] = outstandingStudents.get(i);
        }
        return results;
    }

}
