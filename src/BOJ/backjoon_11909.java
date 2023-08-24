package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_11909 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n + 1][n + 1];
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[1][1] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                // 출구에 도착한 경우
                if (i == n && j == n) {
                    break;
                }

                // 아래로 가는 경우
                if (i != n) {
                    int diff = 0;
                    if (map[i + 1][j] >= map[i][j]) {
                        diff = map[i + 1][j] - map[i][j] + 1;
                    }
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + diff);
                }

                // 오른쪽으로 가는 경우
                if (j != n) {
                    int diff = 0;
                    if (map[i][j + 1] >= map[i][j]) {
                        diff = map[i][j + 1] - map[i][j] + 1;
                    }
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + diff);
                }

            }
        }

        System.out.println(dp[n][n]);
    }
}
