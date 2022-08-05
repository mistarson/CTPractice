package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_2156 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] wines;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        wines = new int[n];
        dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = wines[0];

        if (n == 1) {
            System.out.println(dp[1]);
            return;
        }

        dp[2] = dp[1] + wines[1];

        if (n == 2) {
            System.out.println(dp[2]);
            return;
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 3] + wines[i - 2] + wines[i - 1];
            dp[i] = Math.max(dp[i], dp[i - 2] + wines[i - 1]);
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }

        System.out.println(dp[n]);

    }

}
