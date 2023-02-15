package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class backjoon_2583 {
    static int M, N, K;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int areaCnt = 0;
    static int area = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    map[k][j] = true;
                }
            }
        }

        List<Integer> areaList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!map[i][j]) {
                    areaCnt++;
                    dfs(i, j, map);
                    areaList.add(area);
                    area = 0;
                }
            }
        }

        Collections.sort(areaList);

        StringBuilder sb = new StringBuilder();
        sb.append(areaCnt).append("\n");
        for (int i = 0; i < areaCnt; i++) {
            sb.append(areaList.get(i)).append(" ");
        }

        System.out.println(sb);
    }

    static void dfs(int x, int y, boolean[][] map) {

        area++;

        map[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (inRange(nx, ny) && !map[nx][ny]) {
                dfs(nx, ny, map);
            }
        }

    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }
}
