package programmers.예상대진표;

public class Solution {
    public static void main(String[] args) {
        int n = 8;
        int a = 8;
        int b = 7;

        int solution = new Solution().solution(n, a, b);
        System.out.println(solution);
    }
    public int solution(int n, int a, int b) {
        int answer = 0;

        while (a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        }

        return answer;
    }
}
