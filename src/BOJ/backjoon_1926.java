package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon_1926 {
    static int maxSize = 0;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        boolean[][] isVisited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isVisited[i][j] && map[i][j] == 1) {
                    cnt++;
                    Queue<Position> queue = new LinkedList<>();
                    queue.add(new Position(i, j));
                    isVisited[i][j] = true;
                    int size = 1;
                    while (!queue.isEmpty()) {
                        Position position = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nr = position.r + dr[k];
                            int nc = position.c + dc[k];

                            if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                                if (!isVisited[nr][nc] && map[nr][nc] == 1) {
                                    size++;
                                    isVisited[nr][nc] = true;
                                    queue.add(new Position(nr, nc));
                                }
                            }
                        }

                    }
                    maxSize = Math.max(maxSize, size);
                }
            }
        }

        System.out.println(cnt);
        System.out.println(maxSize);

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
