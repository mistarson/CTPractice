package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_1149 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] dp;
    static int[][] cost;

    final static int RED = 0;
    final static int GREEN = 1;
    final static int BLUE = 2;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        cost = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i][RED] = Integer.parseInt(st.nextToken());
            cost[i][GREEN] = Integer.parseInt(st.nextToken());
            cost[i][BLUE] = Integer.parseInt(st.nextToken());
        }

        dp[0][RED] = cost[0][RED];
        dp[0][GREEN] = cost[0][GREEN];
        dp[0][BLUE] = cost[0][BLUE];

        int answer = Math.min(getMinCost(N -1, RED), Math.min(getMinCost(N - 1, GREEN), getMinCost(N - 1, BLUE)));

        System.out.println(answer);

    }

    static int getMinCost(int n, int color) {
        if (dp[n][color] == 0) {
            switch (color) {
                case RED:
                    dp[n][RED] = Math.min(getMinCost(n - 1, GREEN), getMinCost(n - 1, BLUE)) + cost[n][RED];
                    break;
                case GREEN:
                    dp[n][GREEN] = Math.min(getMinCost(n - 1, RED), getMinCost(n - 1, BLUE)) + cost[n][GREEN];
                    break;
                case BLUE:
                    dp[n][BLUE] = Math.min(getMinCost(n - 1, RED), getMinCost(n - 1, GREEN)) + cost[n][BLUE];
                    break;
            }
        }
        return dp[n][color];
    }
}
