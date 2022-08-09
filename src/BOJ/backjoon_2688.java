package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_2688 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int T;
    static long[][] dp = new long[66][11];

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 0; i < 10; i++) {
            dp[2][i] = 10 - i;
        }

        for (int i = 3; i <= 65; i++) {
            for (int j = 9; j >= 0; j--) {
                dp[i][j] = dp[i][j+1] + dp[i - 1][j];
            }
        }

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            sb.append(dp[n + 1][0]).append("\n");
        }

        System.out.println(sb);
    }
}
