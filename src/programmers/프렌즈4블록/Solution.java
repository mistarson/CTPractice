package programmers.프렌즈4블록;

import java.util.Arrays;

public class Solution {
    static int bombBlockCnt = 0;

    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        int solution = new Solution().solution(m, n, board);
        System.out.println(bombBlockCnt);
    }

    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            String str = board[i];
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        while (find2x2blockAndBomb(map, m, n)) {
            drop(map, m, n);
        }

        return bombBlockCnt;
    }

    static boolean find2x2blockAndBomb(char[][] map, int m, int n) {

        int[][] bombMap = new int[m][n];

        int[] dx = {1, 1, 0};
        int[] dy = {0, 1, 1};

        // 터뜨릴게 있나 찾기
        boolean bomb = false;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                int cnt = 1;
                char stdBlock = map[i][j];
                if (stdBlock == 0) {
                    continue;
                }
                for (int k = 0; k < 3; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];

                    if (stdBlock == map[ny][nx]) {
                        cnt++;
                    } else break;
                }
                if (cnt == 4) {
                    bomb = true;
                    bombMap[i][j] = 1;
                    for (int k = 0; k < 3; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        bombMap[ny][nx] = 1;
                    }
                }
            }
        }

        if (!bomb) {
            return false;
        }

        // 터뜨리기
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (bombMap[i][j] == 1) {
                    map[i][j] = 0;
                    bombBlockCnt++;
                }
            }
        }

        return bomb;
    }

    static void drop(char[][] map, int m, int n) {

        //떨어뜨리기
        char[][] temp = new char[m][n];
        for (int i = 0; i < n; i++) {
            int tempIdx = m - 1;
            for (int j = m - 1; j >= 0; j--) {
                if (map[j][i] != 0) {
                    temp[tempIdx--][i] = map[j][i];
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = temp[i][j];
            }
        }
    }
}
