package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon_1743 {
    static int N;
    static int M;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][M + 1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = 1;
        }

        int maxSize = 0;
        boolean[][] isVisited = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 1 && !isVisited[i][j])
                    maxSize = Math.max(maxSize, findFoodTrash(i, j, map, isVisited));
            }
        }

        System.out.println(maxSize);
    }

    static boolean inRange(int r, int c) {
        return r > 0 && r <= N && c > 0 && c <= M;
    }

    static int findFoodTrash(int r, int c, int[][] map, boolean[][] isVisited) {

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int size = 0;
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(r, c));
        isVisited[r][c] = true;

        while (!queue.isEmpty()) {
            size++;
            Position current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if (inRange(nr, nc) && map[nr][nc] == 1 && !isVisited[nr][nc]) {
                    isVisited[nr][nc] = true;
                    queue.add(new Position(nr, nc));
                }
            }

        }

        return size;
    }

    static class Position {
        int r;
        int c;

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
