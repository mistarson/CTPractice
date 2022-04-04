package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_9095 {
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp = new Integer[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(findSum(n));
        }
    }

    static Integer findSum(int n) {
        if (dp[n] == null) {
            for (int i = 4; i <= n; i++) {
                dp[n] = findSum(n - 1) + findSum(n - 2) + findSum(n - 3);
            }
        }
        return dp[n];
    }
}
