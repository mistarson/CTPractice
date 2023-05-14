package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjoon_1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 적어도 C명보다 많으면 되기 때문
        int[] dp = new int[C + 101];
        Arrays.fill(dp, 1000000);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());

            for (int j = people; j < dp.length; j++) {
                dp[j] = Math.min(dp[j], cost + dp[j - people]);
            }

        }

        int answer = dp[C];
        for (int i = C + 1; i < dp.length ; i++) {
            answer = Math.min(answer, dp[i]);
        }

        System.out.println(answer);

    }
}
