package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon_2206 {
    static int N, M;

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

        int minDist = getMinDist(map);

        if (minDist == Integer.MAX_VALUE) {
            minDist = -1;
        }

        System.out.println(minDist);

    }

    static int getMinDist(int[][] map) {

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int[][][] dist = new int[N][M][2];
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[i].length; j++) {
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

                // 격자를 벗어나지 않고
                if (inRange(nr, nc)) {
                    // 벽을 부순 적이 있다면
                    if (current.crashWall == 1) {
                        if (map[nr][nc] == 0) {
                            if (current.dist + 1 < dist[nr][nc][1]) {
                                dist[nr][nc][1] = current.dist + 1;
                                queue.add(new Position(nr, nc, 1, current.dist + 1));
                            }
                        }
                    }
                    //벽을 부순 적이 없다면
                    else {
                        // 다음 위치가 벽이라면
                        if (map[nr][nc] == 1) {
                            if (current.dist + 1 < dist[nr][nc][1]) {
                                dist[nr][nc][1] = current.dist + 1;
                                queue.add(new Position(nr, nc, 1, current.dist + 1));
                            }
                        } else {
                            if (current.dist + 1 < dist[nr][nc][0]) {
                                dist[nr][nc][0] = current.dist + 1;
                                queue.add(new Position(nr, nc, 0, current.dist + 1));
                            }
                        }
                    }
                }
            }
        }

        return Math.min(dist[N - 1][M - 1][0], dist[N - 1][M - 1][1]);
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
