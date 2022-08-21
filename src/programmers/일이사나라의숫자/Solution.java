package programmers.일이사나라의숫자;

public class Solution {
    public static void main(String[] args) {
        int n = 15;
        String solution = new Solution().solution(n);
        System.out.println(solution);
    }
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        int[] num = {4, 1, 2};

        while (n != 0) {
            int mod = n % 3;
            answer.insert(0, num[mod]);
            n /= 3;
            if (mod == 0) {
                n -= 1;
            }
        }
        return answer.toString();
    }
}
