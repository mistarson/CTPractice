package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon_14442 {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int N, M, K;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = chars[j] - '0';
            }
        }

        int[][][] dist = new int[N][M][K + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        dist[0][0][0] = 1;
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0, 0, 1));
        while (!queue.isEmpty()) {
            Position current = queue.poll();

            if (dist[current.r][current.c][current.crashWall] < current.dist) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if (inRange(nr, nc)) {
                    if (map[nr][nc] == 0) {
                        if (dist[nr][nc][current.crashWall] > current.dist + 1) {
                            dist[nr][nc][current.crashWall] = current.dist + 1;
                            queue.add(new Position(nr, nc, current.crashWall, current.dist + 1));
                        }
                    } else {
                        if (current.crashWall < K) {
                            if (dist[nr][nc][current.crashWall + 1] > current.dist + 1) {
                                dist[nr][nc][current.crashWall + 1] = current.dist + 1;
                                queue.add(new Position(nr, nc, current.crashWall + 1, current.dist + 1));
                            }
                        }
                    }
                }
            }
        }

        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i <= K; i++) {
            minDist = Math.min(minDist, dist[N - 1][M - 1][i]);
        }

        if (minDist == Integer.MAX_VALUE) {
            minDist = -1;
        }

        System.out.println(minDist);
    }

    static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    static class Position {
        int r;
        int c;
        int crashWall;
        int dist;

        public Position(int r, int c, int crashWall, int dist) {
            this.r = r;
            this.c = c;
            this.crashWall = crashWall;
            this.dist = dist;
        }
    }
}
