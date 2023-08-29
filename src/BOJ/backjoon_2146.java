package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjoon_2146 {
    static int N;
    static int[][] map;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int minDist = Integer.MAX_VALUE;

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

        // 구역별로 색칠하기
        int areaIdx = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    colorArea(i, j, areaIdx);
                    areaIdx++;
                }
            }
        }

        //바다 찾기 (사실 N^2이지만 한번만 돌아간다)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] >= 2) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(minDist - 1);

    }

    static void bfs(int r, int c) {
        boolean[][] isVisited = new boolean[N][N];
        isVisited[r][c] = true;
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(r, c, 0));
        while (!queue.isEmpty()) {
            Position current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if (inRange(nr, nc) && !isVisited[nr][nc]) {
                    isVisited[nr][nc] = true;
                    if (map[nr][nc] == 0) {
                        queue.add(new Position(nr, nc, current.dist + 1));
                        continue;
                    }
                    if (map[nr][nc] != map[r][c]) {
                        minDist = Math.min(minDist, current.dist + 1);
                    }
                }
            }
        }
    }

    static void colorArea(int r, int c, int areaIdx) {
        map[r][c] = areaIdx;
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(r, c));
        while (!queue.isEmpty()) {
            Position current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if (inRange(nr, nc) && map[nr][nc] == 1) {
                    map[nr][nc] = areaIdx;
                    queue.add(new Position(nr, nc));
                }
            }
        }
    }

    static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    static class Position {
        int r;
        int c;
        int dist;

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Position(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
}
