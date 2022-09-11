package programmers.삼xn타일링;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        if (n % 2 != 0) {
            return answer;
        }
        long[] dp = new long[5001];
        dp[0] = 1;
        dp[2] = 3;

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 2] * 3;
            for (int j = i - 4; j >= 0; j--) {
                dp[i] += dp[j] * 2;
            }
            dp[i] %= 1000000007;
        }

        return answer = (int)dp[n];
    }
}
