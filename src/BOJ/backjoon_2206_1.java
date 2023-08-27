package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon_2206_1 {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int[][] map;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = chars[j] - '0';
            }
        }

        int[][][] dist = new int[N][M][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        dist[0][0][0] = 1;
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0, 1, 0));
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
                            queue.add(new Position(nr, nc, current.dist + 1, current.crashWall));
                        }
                    }

                    // 벽일 때
                    else {
                        if (current.crashWall == 0) {
                            if (dist[nr][nc][1] > current.dist + 1) {
                                dist[nr][nc][1] = current.dist + 1;
                                queue.add(new Position(nr, nc, current.dist + 1, 1));
                            }
                        }
                    }
                }
            }
        }

        int minDist = Math.min(dist[N - 1][M - 1][0], dist[N - 1][M - 1][1]);
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
        int dist;
        int crashWall;

        public Position(int r, int c, int dist, int crashWall) {
            this.r = r;
            this.c = c;
            this.dist = dist;
            this.crashWall = crashWall;
        }
    }
}
