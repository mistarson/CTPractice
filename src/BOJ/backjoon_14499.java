package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_14499 {

    static int N, M, x, y, K;
    static int[][] map;
    static int[] dr = {0, 1, -1, 0, 0};
    static int[] dc = {0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        int[][] dice = new int[4][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int dir = Integer.parseInt(st.nextToken());

            int nr = x + dc[dir];
            int nc = y + dr[dir];
            if (!inRange(nr, nc)) {
                continue;
            }
            x = nr;
            y = nc;

            rollDice(dir, dice);
            sb.append(dice[1][1]).append("\n");
        }

        System.out.println(sb);
    }

    static boolean inRange(int nr, int nc) {
        return nr >= 0 && nr < N && nc >= 0 && nc < M;
    }

    static void rollDice(int dir, int[][] dice) {
        switch (dir) {
            case 1 : {
                int temp = dice[1][2];
                dice[1][2] = dice[1][1];
                dice[1][1] = dice[1][0];
                dice[1][0] = dice[3][1];
                dice[3][1] = temp;
                break;
            }

            case 2 : {
                int temp = dice[1][0];
                dice[1][0] = dice[1][1];
                dice[1][1] = dice[1][2];
                dice[1][2] = dice[3][1];
                dice[3][1] = temp;
                break;
            }

            case 3 : {
                int temp = dice[0][1];
                dice[0][1] = dice[1][1];
                dice[1][1] = dice[2][1];
                dice[2][1] = dice[3][1];
                dice[3][1] = temp;
                break;
            }

            case 4 : {
                int temp = dice[3][1];
                dice[3][1] = dice[2][1];
                dice[2][1] = dice[1][1];
                dice[1][1] = dice[0][1];
                dice[0][1] = temp;
                break;
            }
        }

        if (map[x][y] == 0) {
            map[x][y] = dice[3][1];
        } else {
            dice[3][1] = map[x][y];
            map[x][y] = 0;
        }

    }

}
