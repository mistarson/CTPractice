package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_2758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            long[][] dp = new long[n + 1][m + 1];
            for (int j = 0; j <= m; j++) {
                dp[0][j] = 1;
            }

            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= m; k++) {
                    dp[j][k] = dp[j - 1][k / 2] + dp[j][k - 1];
                }
            }
            sb.append(dp[n][m]).append("\n");
        }

        System.out.println(sb);
    }


}
