package programmers.level1.이천십육년;

public class Solution {
    public static void main(String[] args) {
        int a = 5;
        int b = 24;

        System.out.println(solution(a, b));

    }

    static String solution(int a, int b) {
        String answer = "";
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int total = 0;
        for (int i = 0; i < a - 1; i++) {
            total += months[i];
        }
        total += b;
        if (total % 7 == 0) {
            return "THU";
        }
        return answer = days[(total % 7) - 1];
    }
}
