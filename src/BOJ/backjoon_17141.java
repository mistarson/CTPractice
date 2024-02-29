package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon_17141 {

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N, M;
    static int[][] map;
    static int minTime = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        List<Position> virusList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virusList.add(new Position(i, j));
                    map[i][j] = 0;
                }
            }
        }

        tryAllCase(0, virusList, 0);

        if (minTime == Integer.MAX_VALUE) {
            minTime = -1;
        }
        System.out.println(minTime);
    }

    static void tryAllCase(int depth, List<Position> virusList, int start) {
        if (depth == M) {
            int time = spreadVirus();
            minTime = Math.min(minTime, time);
            return;
        }

        for (int i = start; i < virusList.size(); i++) {
            Position virus = virusList.get(i);
            map[virus.r][virus.c] = 2;
            tryAllCase(depth + 1, virusList, start + 1);
            map[virus.r][virus.c] = 0;
        }
    }

    static int spreadVirus() {
        Queue<Position> queue = new LinkedList<>();
        int[][] copyMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copyMap[i][j] = map[i][j];
                if (copyMap[i][j] == 2) {
                    queue.add(new Position(i, j, 0));
                }
            }
        }
        while (!queue.isEmpty()) {
            Position current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if (inRange(nr, nc) && copyMap[nr][nc] != 1) {
                    if (copyMap[nr][nc] > current.dist + 1 || copyMap[nr][nc] == 0) {
                        copyMap[nr][nc] = current.dist + 1;
                        queue.add(new Position(nr, nc, current.dist + 1));
                    }
                }
            }
        }

        int time = -1;
        loop:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (copyMap[i][j] == 0) {
                    time = -1;
                    break loop;
                }
                time = Math.max(time, copyMap[i][j]);
            }
        }

        if (time == -1) {
            time = Integer.MAX_VALUE;
        }

        return time;
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
