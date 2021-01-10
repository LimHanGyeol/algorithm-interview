import java.util.*;

/**
 * 프로그래머스
 * Level1
 * 체육복
 */
class Solution {

    public static void main(String[] args) {
        int n = 5;
        int[] lost = new int[]{2, 4};
        int[] reserve = new int[]{1, 3, 5};
        System.out.println(lostClothes(n, lost, reserve));
    }

    public int lostClothes(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        answer = sameStudentOfLostAndReserve(lost, reserve, answer);

        return lendGymClothes(lost, reserve, answer);
    }

    private int sameStudentOfLostAndReserve(int[] lost, int[] reserve, int answer) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int lostStudent = 0; lostStudent < lost.length; lostStudent++) {
            for (int reserveStudent = 0; reserveStudent < reserve.length; reserveStudent++) {
                if (lost[lostStudent] == reserve[reserveStudent]) {
                    reserve[reserveStudent] = 31;
                    lost[lostStudent] = 31;
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }

    private int lendGymClothes(int[] lost, int[] reserve, int answer) {
        for (int lostStudent : lost) {
            answer = lend(reserve, answer, lostStudent);
        }
        return answer;
    }

    private int lend(int[] reserve, int answer, int lostStudent) {
        for (int student = 0; student < reserve.length; student++) {
            if (reserve[student] - lostStudent == 1 || lostStudent - reserve[student] == 1) {
                answer++;
                reserve[student] = 31;
                break;
            }
        }
        return answer;
    }

}
