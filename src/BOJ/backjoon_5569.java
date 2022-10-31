package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_5569 {
    static final int MOD = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][][] dp = new int[W + 1][H + 1][2][2];
        for (int i = 2; i <= W; i++) {
            dp[i][1][0][0] = 1;
        }
        for (int i = 2; i <= H; i++) {
            dp[1][i][1][0] = 1;
        }

        for (int i = 2; i <= W; i++) {
            for (int j = 2; j <= H; j++) {
                //오른쪽으로 가야하고, 1칸만 이동하는 경우
                dp[i][j][0][0] = (dp[i - 1][j][0][0] + dp[i - 1][j][0][1]) % MOD;

                //오른쪽으로 가야하고, 2칸을 이동해야 하는 경우
                dp[i][j][0][1] = dp[i - 1][j][1][0];

                // 아래쪽으로 가야하고, 1칸만 이동하는 경우
                dp[i][j][1][0] = (dp[i][j - 1][1][0] + dp[i][j - 1][1][1]) % MOD;

                // 아래쪽으로 가야하고, 2칸만 이동하는 경우
                dp[i][j][1][1] = dp[i][j - 1][0][0];
            }
        }
        int answer = (dp[W][H][0][0] + dp[W][H][0][1] + dp[W][H][1][0] + dp[W][H][1][1]) % MOD;

        System.out.println(answer);
    }
}
