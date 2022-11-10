package programmers.등굣길;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int n = 3;
        int m = 4;
        int[][] puddles = {{2, 2}};
        new Solution().solution(m, n, puddles);
    }
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < puddles.length; i++) {
            dp[puddles[i][0]][puddles[i][1]] = -1;
        }

        // 맨왼쪽 줄 채우기
        for (int i = 1; i < n; i++) {
            if (dp[i][0] == -1) {
                continue;
            }
            dp[i][0] += dp[i - 1][0] != -1 ? dp[i - 1][0] : 0;
        }

        // 맨 윗줄 채우기
        for (int i = 1; i < m; i++) {
            if (dp[0][i] == -1) {
                continue;
            }
            dp[0][i] += dp[0][i - 1] != -1 ? dp[0][i - 1] : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (dp[i][j] == -1) {
                    continue;
                }
                dp[i][j] += dp[i - 1][j] != -1 ? dp[i - 1][j] : 0;
                dp[i][j] += dp[i][j - 1] != -1 ? dp[i][j - 1] : 0;
            }
        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }


        return answer;
    }
}
