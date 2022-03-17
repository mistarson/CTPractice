package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class backjoon_15988 {
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(findSum(n) % 1000000009);
        }
    }

    static long findSum(int n) {
        if (dp[n] == 0) {
            for (int i = 4; i <= n; i++) {
                if (dp[i] != 0) {
                    continue;
                }
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }
        return dp[n];
    }
}
