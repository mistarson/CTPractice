package programmers.삼각달팽이;

import java.util.Arrays;

public class Solution {
    static int[] dr = {1, 0, -1,};
    static int[] dc = {0, 1, -1};

    public static void main(String[] args) {
        int n = 4;
        int[] solution = new Solution().solution(n);
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(int n) {

        if (n == 1) {
            return new int[]{1};
        }

        int[] answer = new int[(n * (n + 1) / 2)];
        int[][] map = new int[n][n];

        int r = 0;
        int c = 0;
        int dir = 0;
        int value = 1;
        while (map[r][c] == 0) {
            map[r][c] = value++;

            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (!inRange(nr, nc, n) || map[nr][nc] != 0) {
                dir = (dir + 1) % 3;
                nr = r + dr[dir];
                nc = c + dc[dir];
            }

            r = nr;
            c = nc;
        }

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                answer[idx++] = map[i][j];
            }
        }
        return answer;
    }

    static boolean inRange(int r, int c, int n) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}
