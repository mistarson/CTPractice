package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon_4179 {
    static char[][] map;
    static int r, c, minTime = Integer.MAX_VALUE;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];

        Queue<Position> queue = new LinkedList<>();

        int jihoonR = 0, jihoonC = 0;
        for (int i = 0; i < r; i++) {
            String mapStr = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = mapStr.charAt(j);
                if (map[i][j] == 'J') {
                    jihoonR = i;
                    jihoonC = j;
                    map[i][j] = '.';
                }
                if (map[i][j] == 'F') {
                    queue.add(new Position(i, j, 'F'));
                }
            }
        }
        queue.add(new Position(jihoonR, jihoonC, 'J'));

        int[][] minLength = new int[r][c];
        for (int i = 0; i < r; i++) {
            Arrays.fill(minLength[i], Integer.MAX_VALUE);
        }
        minLength[jihoonR][jihoonC] = 0;

        if (canEscape(queue, minLength)) {
            System.out.println(minTime);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

    static boolean canEscape(Queue<Position> queue, int[][] minLength) {

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            // 탈출할수있는가?
            if (current.type == 'J') {
                if (current.r == 0 || current.r == r - 1 || current.c == 0 || current.c == c - 1) {
                    minTime = minLength[current.r][current.c] + 1;
                    return true;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if (inRange(nr, nc) && map[nr][nc] == '.') {
                    // 지훈이일땐 내자리+1 < 다음자리면 간다
                    if (current.type == 'F') {
                        map[nr][nc] = 'F';
                        queue.add(new Position(nr, nc, 'F'));
                    }
                    if (current.type == 'J') {
                        if (minLength[current.r][current.c] + 1 < minLength[nr][nc]) {
                            minLength[nr][nc] = minLength[current.r][current.c] + 1;
                            queue.add(new Position(nr, nc, 'J'));
                        }
                    }
                }
            }
        }

        return false;
    }

    static boolean inRange(int currentR, int currentC) {
        return currentR >= 0 && currentR < r && currentC >= 0 && currentC < c;
    }

    static class Position {
        int r;
        int c;
        char type;

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Position(int r, int c, char type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }
    }

}
