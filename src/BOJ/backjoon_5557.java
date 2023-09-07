package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[N][21];
        dp[0][numbers[0]] = 1;
        for (int i = 1; i < N - 1; i++) {
            for (int j = 0; j < 21; j++) {
                if (dp[i - 1][j] >= 1) {
                    int plus = j + numbers[i];
                    int minus = j - numbers[i];

                    if (plus >= 0 && plus <= 20) {
                        dp[i][plus] += dp[i-1][j];
                    }
                    if (minus >= 0 && minus <= 20) {
                        dp[i][minus] += dp[i-1][j];
                    }
                }
            }
        }

        System.out.println(dp[N-2][numbers[N-1]]);
    }
}
