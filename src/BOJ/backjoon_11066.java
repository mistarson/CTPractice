package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_11066 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine());
            int[] files = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                files[j] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[N][N];

            for (int j = 1; j < N; j++) {
                for (int k = j - 1; k >= 0; k--) {
                    dp[k][j] = Integer.MAX_VALUE;
                    for (int l = 0; l < j - k; l++) {

                        // ex) A,B,C,D ( A + BCD   ABC + D   AB + CD)
                        dp[k][j] = Math.min(dp[k][j], dp[k][k + l] + dp[l + k + 1][j]);
                    }
                    int sum = 0;
                    for (int l = k; l <= j; l++) {
                        sum += files[l];
                    }
                    dp[k][j] += sum;
                }
            }

            sb.append(dp[0][N - 1]).append("\n");
        }

        System.out.println(sb);
    }
}
