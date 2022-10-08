package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon_2206 {
    static int N, M;
    static int minDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = 0;
                    minDist = Math.min(minDist, getMinDist(map));
                    map[i][j] = 1;
                }
            }
        }

        if (minDist == Integer.MAX_VALUE) {
            minDist = -1;
        }

        System.out.println(minDist);

    }

    static int getMinDist(int[][] map) {

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        boolean[][] isVisited = new boolean[N][M];
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0, 1));
        isVisited[0][0] = true;

        int minDist = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Position current = queue.poll();

            if (current.r == N - 1 && current.c == M - 1) {
                minDist = current.dist;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if (inRange(nr, nc) && !isVisited[nr][nc] && map[nr][nc] == 0) {
                    isVisited[nr][nc] = true;
                    queue.add(new Position(nr, nc, current.dist + 1));
                }
            }
        }
        return minDist;
    }

    static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    static class Position {
        int r;
        int c;
        int dist;

        public Position(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
}
