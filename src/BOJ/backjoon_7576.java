package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjoon_7576 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] tx = {0, 0, -1, 1};
    static int[] ty = {-1, 1, 0, 0};
    static int[][] map;
    static Queue<Position> queue = new LinkedList<>();
    static int N, M;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        // 안익은 토마토가 없는 경우를 위한 flag
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.add(new Position(i, j, 0));
                } else if (map[i][j] == 0) {
                    flag = true;
                }
            }
        }

        // 안익은 토마토가 하나도 없다면 0 출력
        if (!flag) {
            System.out.println(0);
            return;
        }

        while (!queue.isEmpty()) {
            Position current = queue.poll();
            int x = current.x;
            int y = current.y;
            int day = current.day;

            //연결된곳을순회
            for (int i = 0; i < 4; i++) {
                int ny = y + ty[i];
                int nx = x + tx[i];
                //갈수있는가 (맵밖으로 벗어나지, 0(토마토)인가?)
                if (CanGo(ny, nx) && map[ny][nx] == 0) {
                    //간다
                    //체크인
                    map[ny][nx] = day + 1;
                    queue.add(new Position(ny, nx, day + 1));
                }

            }
        }

        int max = Integer.MIN_VALUE;
        for (int[] ints : map) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, anInt);
            }

        }
        System.out.println(max);

    }

    static boolean CanGo(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }

    static class Position {
        int y;
        int x;
        int day;

        public Position(int y, int x, int day) {
            this.y = y;
            this.x = x;
            this.day = day;
        }
    }
}
