package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon_1303 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String mapStr = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = mapStr.charAt(j);
            }
        }

        int W_Score = 0;
        int B_Score = 0;
        boolean[][] isVisited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isVisited[i][j]) {
                    int score = findTeam(i, j, map[i][j], map, isVisited);
                    if (map[i][j] == 'W') {
                        W_Score += Math.pow(score, 2);
                    } else B_Score += Math.pow(score, 2);
                }
            }
        }

        System.out.println(W_Score + " " + B_Score);
    }

    static int findTeam(int r, int c, char team, char[][] map, boolean[][] isVisited) {

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(r, c));
        isVisited[r][c] = true;

        int cnt = 1;
        while (!queue.isEmpty()) {
            Position current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if (inRange(nr, nc) && !isVisited[nr][nc] && map[nr][nc] == team) {
                    cnt++;
                    isVisited[nr][nc] = true;
                    queue.add(new Position(nr, nc));
                }
            }

        }

        return cnt;
    }

    static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
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
