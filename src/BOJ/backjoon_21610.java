package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon_21610 {
    static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] cross_r = {-1, -1, 1, 1};
    static int[] cross_d = {-1, 1, 1, -1};
    static int[][] A;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Cloud> queue = new LinkedList<>();
        queue.add(new Cloud(N - 1, 0));
        queue.add(new Cloud(N - 1, 1));
        queue.add(new Cloud(N - 2, 0));
        queue.add(new Cloud(N - 2, 1));

        for (int i = 0; i < M; i++) {
            boolean[][] isVisited = new boolean[N][N];

            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());

            Queue<Cloud> afterMovingCloud = new LinkedList<>();
            // 구름 이동
            while (!queue.isEmpty()) {

                Cloud cloud = queue.poll();
                int nr = (cloud.r + dr[d] * s) % N;
                int nc = (cloud.c + dc[d] * s) % N;

                if (nr < 0) {
                    nr = N + nr;
                }
                if (nc < 0) {
                    nc = N + nc;
                }

                afterMovingCloud.add(new Cloud(nr, nc));
                A[nr][nc]++;
                isVisited[nr][nc] = true;
            }

            // 대각선 확인하고 물복사
            while (!afterMovingCloud.isEmpty()) {
                Cloud cloud = afterMovingCloud.poll();
                for (int j = 0; j < 4; j++) {
                    int nr = cloud.r + cross_r[j];
                    int nc = cloud.c + cross_d[j];

                    if (inRange(nr, nc) && A[nr][nc] > 0) {
                        A[cloud.r][cloud.c]++;
                    }
                }
            }

            // 물의 양이 2 이상인 칸에 구름 생성
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (A[j][k] >= 2 && !isVisited[j][k]) {
                        A[j][k] -= 2;
                        queue.add(new Cloud(j, k));
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += A[i][j];
            }
        }

        System.out.println(sum);
    }

    static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    static class Cloud {
        int r;
        int c;

        public Cloud(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
