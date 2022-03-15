import java.util.*;

public class Solution {
    static int[] ty = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] tx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int answer = 0;
    public static void main(String[] args) {

        int h1 = 7;
        int w1 = 9;
        int n1 = 4;
        String[] board1 = {"111100000", "000010011", "111100011", "111110011", "111100011", "111100010", "111100000"};

        int h2 = 5;
        int w2 = 5;
        int n2 = 5;
        String[] board2 = {"11111","11111","11111","11111","11111"};

        System.out.println(solution(h2, w2, n2, board2));
        System.out.println(solution(h2, w2, n2, board2));
    }

    static int solution(int h, int w, int n, String[] board) {
        int[][] map = new int[h][w];

        //맵 그리기
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                map[i][j] = board[i].charAt(j) - '0';
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) { // 모든 맵 돌기 for문 2개
                if (map[i][j] == 1) {
                    for (int k = 0; k < 8; k++) { // 1이면 여덟방향 갈수 있는지 검사해서 갈수 있으면 dfs 돌림
                        int ny = ty[k] + i;
                        int nx = tx[k] + j;
                        if (canGo(ny, nx, h, w, map)) {
                            if (k >= 4) {
                                if (canGo(ty[k - 4] + i, tx[k - 4] + j, h, w, map)) {
                                    continue;
                                }
                            } else {
                                if (canGo(ty[k + 4] + i, tx[k + 4] + j, h, w, map)) {
                                    continue;
                                }
                            }
                            dfs(i, j, 1, map, n, k, h, w);
                        }
                    }
                }
            }
        }

        return answer/2;
    }

    static void dfs(int y, int x, int length, int[][] map, int target, int direction, int h, int w) {

        int ny = ty[direction] + y;
        int nx = tx[direction] + x;

        if (length == target) {
            //더 넘는지 확인
            if (canGo(ny, nx, h, w, map)) {
                return;
            }
            answer++;
        }

        if (canGo(ny, nx, h, w, map)) {
            dfs(ny, nx, length + 1, map, target, direction, h, w);
        }
    }

    static boolean canGo(int y, int x, int h, int w, int[][] map) {
        if (y >= 0 && y < h && x >= 0 && x < w && map[y][x] == 1) {
            return true;
        }
        return false;
    }





}
