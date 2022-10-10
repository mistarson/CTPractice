package programmers.멀리뛰기;

public class Solution {
    public static void main(String[] args) {

    }
    public long solution(int n) {
        long[] dp = new long[n + 1];

        dp[1] = 1;
        if (n == 1){
            return 1;
        }

        dp[2] = 2;
        if (n == 2) {
            return 2;
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }

        return dp[n];
    }
}
