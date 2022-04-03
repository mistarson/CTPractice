package BOJ;

import java.io.*;
import java.util.*;

public class backjoon_2667 {
    static int[] ty = {-1, 1, 0, 0};
    static int[] tx = {0, 0, -1, 1};
    static int estateCnt = 0;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        // 맵 초기화
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                if (s.charAt(j) == '1') {
                    map[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    list.add(bfs(new Position(i, j), map, visited, N));
                }
            }
        }

        Collections.sort(list);

        bw.write(estateCnt + "\n");
        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i) + "\n");
        }

        bw.flush();

    }

    static int bfs(Position position, int[][] map, boolean[][] visited, int N) {
        int cnt = 0;
        estateCnt++;
        Queue<Position> queue = new LinkedList<>();
        queue.add(position);
        while (!queue.isEmpty()) {

            Position current = queue.poll();
            visited[current.row][current.col] = true;
            cnt++;

            for (int i = 0; i < 4; i++) {
                int ny = ty[i] + current.row;
                int nx = tx[i] + current.col;

                // 맵 범위인가?
                if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                    if (!visited[ny][nx] && map[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        queue.add(new Position(ny, nx));
                    }
                }
            }

        }

        return cnt;
    }

    static class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
