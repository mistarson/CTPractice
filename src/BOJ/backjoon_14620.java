package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_14620 {
    static int minCost = Integer.MAX_VALUE;
    static int N;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int[][] map;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isVisited = new boolean[N][N];
        findMinCost(0, 0);

        System.out.println(minCost);
    }

    static void findMinCost(int cnt, int cost) {
        if (cnt == 3) {
            minCost = Math.min(minCost, cost);
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (isRightPosition(i, j)) {
                    visitCheck(i, j, true);
                    findMinCost(cnt + 1, cost + sumCost(i, j));
                    visitCheck(i, j, false);
                }
            }
        }
    }

    static boolean isRightPosition(int r, int c) {


        if (isVisited[r][c]) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isVisited[nr][nc]) {
                return false;
            }
        }

        return true;
    }

    static int sumCost(int r, int c) {

        int sum = 0;
        sum += map[r][c];
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            sum += map[nr][nc];
        }

        return sum;
    }

    static void visitCheck(int r, int c, boolean trueOrFalse) {
        isVisited[r][c] = trueOrFalse;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            isVisited[nr][nc] = trueOrFalse;
        }
    }

}
