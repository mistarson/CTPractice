package BOJ;

import java.io.*;
import java.util.*;

public class backjoon_2615 {
    static int[] ty = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] tx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static String[][] map = new String[19][19];
    static boolean isWin = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //맵 그리기
        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                map[i][j] = st.nextToken();
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) { // 모든 맵 돌기 for문 2개
                if (!map[i][j].equals("0")) {
                    String target = map[i][j];
                    for (int k = 0; k < 8; k++) { // 0이 아니면 여덟방향 갈수 있는지 검사해서 갈수 있으면 dfs 돌림
                        int ny = ty[k] + i;
                        int nx = tx[k] + j;
                        if (canGo(ny, nx, target)) {
                            if (k >= 4) {
                                if (canGo(ty[k - 4] + i, tx[k - 4] + j, target)) {
                                    continue;
                                }
                            } else {
                                if (canGo(ty[k + 4] + i, tx[k + 4] + j, target)) {
                                    continue;
                                }
                            }
                            dfs(i, j, 1, k, target, i, j);
                            if (isWin) {
                                return;
                            }
                        }
                    }
                }
            }
        }

        if (!isWin) {
            System.out.println(0);
        }

    }

    static void dfs(int y, int x, int length, int direction, String target, int startY, int startX) {

        int ny = ty[direction] + y;
        int nx = tx[direction] + x;

        if (length == 5) {
            //더 넘는지 확인
            if (canGo(ny, nx, target)) {
                return;
            }
            if (target.equals("1")) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
            isWin = true;
            StringBuilder sb = new StringBuilder();
            sb.append(startY + 1);
            sb.append(" ");
            sb.append(startX + 1);
            System.out.println(sb.toString());
            return;
        }

        if (canGo(ny, nx, target)) {
            if (nx < startX) {
                startX = nx;
                startY = ny;
            }
            dfs(ny, nx, length + 1, direction, target, startY, startX);
        }
    }

    static boolean canGo(int y, int x, String target) {
        if (y >= 0 && y < 19 && x >= 0 && x < 19 && (map[y][x].equals(target))) {
            return true;
        }
        return false;
    }
}
