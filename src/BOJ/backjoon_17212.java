package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_17212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cost = Integer.parseInt(br.readLine());

        int[] dp = new int[cost + 1];

        for (int i = 1; i <= cost; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i >= 2) {
                dp[i] = dp[i - 2] + 1;
            }
            if (i >= 5) {
                dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            }
            if (i >= 7) {
                dp[i] = Math.min(dp[i], dp[i - 7] + 1);
            }
        }

        System.out.println(dp[cost]);

    }
}
