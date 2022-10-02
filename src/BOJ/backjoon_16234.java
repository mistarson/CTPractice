package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjoon_16234 {
    static int N, L, R;
    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        while (isUnited()) {
            cnt++;
        }

        System.out.println(cnt);

    }
    static boolean isUnited() {

        boolean[][] isVisited = new boolean[N][N];
        boolean isUnited = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j]) {
                    if (findUnited(i, j, isVisited)) {
                        isUnited = true;
                    }
                }
            }
        }

        return isUnited;
    }

    static boolean inRange(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < N;
    }

    static boolean findUnited(int y, int x, boolean[][] isVisited) {

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        List<Position> list = new ArrayList<>();
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(y, x));
        list.add(new Position(y, x));
        isVisited[y][x] = true;

        int sum = A[y][x];
        while (!queue.isEmpty()) {
            Position current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = current.y + dy[i];
                int nx = current.x + dx[i];

                if (inRange(ny, nx) && !isVisited[ny][nx]) {
                    int diff = Math.abs(A[current.y][current.x] - A[ny][nx]);
                    if (diff >= L && diff <= R) {
                        sum += A[ny][nx];
                        isVisited[ny][nx] = true;
                        list.add(new Position(ny, nx));
                        queue.add(new Position(ny, nx));
                    }
                }

            }

        }

        if (list.size() == 1) {
            return false;
        }

        int avg = sum / list.size();
        for (Position position : list) {
            A[position.y][position.x] = avg;
        }

        return true;

    }

    static class Position {
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
