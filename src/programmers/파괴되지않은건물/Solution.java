package programmers.파괴되지않은건물;

public class Solution {

    public static void main(String[] args) {
        int[][] board = {{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}};
        int[][] skill = {{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}};

        int solution = solution(board, skill);
    }

    static int solution(int[][] board, int[][] skill) {
        int answer = 0;

        int N = board.length;
        int M = board[0].length;
        int[][] temp = new int[N + 1][M + 1];

        for (int i = 0; i < skill.length; i++) {
            int type = skill[i][0];
            int startRow = skill[i][1];
            int startCol = skill[i][2];
            int endRow = skill[i][3];
            int endCol = skill[i][4];
            int degree = skill[i][5];

            if (type == 1) {
                degree = -degree;
            }

            temp[startRow][startCol] += degree;
            temp[endRow + 1][endCol + 1] += degree;
            temp[startRow][endCol + 1] += -degree;
            temp[endRow + 1][startCol] += -degree;

        }

        // 위에서 아래로
        for (int i = 0; i < M; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += temp[j][i];
                temp[j][i] = sum;
            }
        }

        // 왼쪽에서 오른쪽
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += temp[i][j];
                temp[i][j] = sum;
                if (board[i][j] + temp[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
