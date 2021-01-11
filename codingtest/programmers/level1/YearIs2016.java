/**
 * 프로그래머스
 * Level1
 * 2016 년
 */
class Solution {

    public static void main(String[] args) {
        int month = 5;
        int day = 24;
        System.out.println(getDayOfWeek2016(month, day)); // TUE
    }

    private String getDayOfWeek2016(int month, int day) {
        String[] days = new String[]{"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] monthDays = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int totalDays = calculateTotalDays(monthDays, month, day);

        int daysIndex = (totalDays % 7) - 1;

        if (daysIndex == -1) {
            daysIndex = 6;
        }

        return days[daysIndex];
    }

    private int calculateTotalDays(int[] monthDays, int month, int day) {
        int monthIndex = month - 1;
        int remainingDays = monthDays[monthIndex] - day;
        int totalDays = 0;

        for (int i = 0; i <= monthIndex; i++) {
            totalDays += monthDays[i];
        }

        totalDays -= remainingDays;
        return totalDays;
    }

}
