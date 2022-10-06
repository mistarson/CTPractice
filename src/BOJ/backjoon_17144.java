package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjoon_17144 {
    static int R, C, T;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        // 초기화
        int refresherRow = 0;
        int[][] map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    refresherRow = i;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < T; i++) {
            expandDust(map);
            refreshAir(map, refresherRow);
            answer = getDustAmount(map);
        }

        for (int[] ints : map) {
            System.out.println(Arrays.toString(ints));
        }

        System.out.println(answer);

    }

    static boolean inRange(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }

    static void expandDust(int[][] map) {

        Queue<Dust> queue = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] / 5 > 0) {
                    queue.add(new Dust(i, j, map[i][j]));
                }
            }
        }

        while (!queue.isEmpty()) {
            Dust dust = queue.poll();

            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                int nr = dust.r + dr[i];
                int nc = dust.c + dc[i];

                if (inRange(nr, nc) && map[nr][nc] != -1) {
                    map[nr][nc] += dust.amount / 5;
                    cnt++;
                }
            }
            map[dust.r][dust.c] -= (dust.amount / 5) * cnt;
        }

    }

    static void refreshAir(int[][] map, int refresherRow) {
        //상단 공기 순환
        int top_r = refresherRow - 2;
        int top_c = 0;
        int top_dir = 3;
        while (!(top_r == refresherRow - 1 && top_c == 1)) {

            int nr = top_r + dr[top_dir];
            int nc = top_c + dc[top_dir];

            if (inRange(nr, nc) && nr < refresherRow) {
                map[top_r][top_c] = map[nr][nc];
                top_r = nr;
                top_c = nc;
            } else {
                top_dir = (top_dir + 1) % 4;
            }
        }

        map[top_r][top_c] = 0;

        //하단 공기 순환
        int bottom_r = refresherRow + 1;
        int bottom_c = 0;
        int bottom_dir = 1;
        while (!(bottom_r == refresherRow && bottom_c == 1)) {

            int nr = bottom_r + dr[bottom_dir];
            int nc = bottom_c + dc[bottom_dir];

            if (inRange(nr, nc) && nr > refresherRow - 1) {
                map[bottom_r][bottom_c] = map[nr][nc];
                bottom_r = nr;
                bottom_c = nc;
            } else {
                bottom_dir = (bottom_dir - 1 + 4) % 4;
            }
        }

        map[bottom_r][bottom_c] = 0;
    }

    static int getDustAmount(int[][] map) {

        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != -1) {
                    answer += map[i][j];
                }
            }
        }
        return answer;
    }

    static class Dust {
        int r;
        int c;
        int amount;

        public Dust(int r, int c, int amount) {
            this.r = r;
            this.c = c;
            this.amount = amount;
        }
    }
}
