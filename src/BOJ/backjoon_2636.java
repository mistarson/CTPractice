package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon_2636 {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int[][] map = new int[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        boolean existCheese = false;
        int cheeseCnt = 0;
        int hour = 0;
        do {
            boolean[][] isVisited = new boolean[R + 1][C + 1];
            hour++;
            int cheeseCntForWhile = 0;
            existCheese = false;

            Queue<Position> queue = new LinkedList<>();
            queue.add(new Position(0, 0));
            isVisited[0][0] = true;
            while (!queue.isEmpty()) {
                Position current = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = current.r + dr[i];
                    int nc = current.c + dc[i];

                    if (inArea(nr, nc) && !isVisited[nr][nc]) {
                        isVisited[nr][nc] = true;
                        if (map[nr][nc] == 0) {
                            queue.add(new Position(nr, nc));
                        }else if (map[nr][nc] == 1) {
                            map[nr][nc] = 0;
                            cheeseCntForWhile++;
                            existCheese = true;
                        }
                    }
                }
            }
            if (existCheese) {
                cheeseCnt = cheeseCntForWhile;
            }


        } while (existCheese);

        System.out.println(hour - 1);
        System.out.println(cheeseCnt);

    }

    static boolean inArea(int r, int c) {
        return r >= 0 && r <=R && c >= 0 && c <= C;
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
