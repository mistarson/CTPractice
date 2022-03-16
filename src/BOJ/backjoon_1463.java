package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class backjoon_1463 {
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new Integer[n + 1];
        dp[0] = dp[1] = 0;

        int minCnt = findMinCnt(n);

        System.out.println(minCnt);
    }

    static int findMinCnt(int n) {

        if (dp[n] == null) {
            if (n % 6 == 0) {
                dp[n] = Math.min(findMinCnt(n-1),Math.min(findMinCnt(n/3),findMinCnt(n/2))) + 1;
            } else if (n % 3 == 0) {
                dp[n] = Math.min(findMinCnt(n / 3), findMinCnt(n - 1)) + 1;
            } else if (n % 2 == 0) {
                dp[n] = Math.min(findMinCnt(n / 2), findMinCnt(n - 1)) + 1;
            } else {
                dp[n] = findMinCnt(n - 1) + 1;
            }
        }
        return dp[n];
    }
}
