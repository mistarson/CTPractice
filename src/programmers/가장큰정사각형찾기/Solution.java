package programmers.가장큰정사각형찾기;

public class Solution {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 1, 1}, {1, 1, 1, 1}};
        int solution = new Solution().solution(board);
        System.out.println(solution);
    }

    public int solution(int [][]board)
    {
        int answer = 0;

        int row = board.length;
        int col = board[0].length;

        int[][] dp = new int[row][col];

        // 맨윗줄 채우기
        for (int i = 0; i < col; i++) {
            dp[0][i] = board[0][i];
        }

        // 왼쪽 첫번째 열 채우기
        for (int i = 0; i < row; i++) {
            dp[i][0] = board[i][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (board[i][j] == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                int left = dp[i][j - 1];
                int top = dp[i-1][j];
                int cross = dp[i - 1][j - 1];
                if (left == 0 || top == 0 || cross == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(left, Math.min(top, cross)) + 1;
                }
            }
        }

        for (int[] ints : dp) {
            for (int anInt : ints) {
                answer = Math.max(answer, anInt);
            }
        }

        return answer * answer;
    }

}
