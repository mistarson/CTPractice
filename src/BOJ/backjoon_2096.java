package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_2096 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] map;
    static int[][] maxDp;
    static int[][] minDp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        maxDp = new int[N][3];
        maxDp[N - 1][0] = map[N - 1][0];
        maxDp[N - 1][1] = map[N - 1][1];
        maxDp[N - 1][2] = map[N - 1][2];

        minDp = new int[N][3];
        minDp[N - 1][0] = map[N - 1][0];
        minDp[N - 1][1] = map[N - 1][1];
        minDp[N - 1][2] = map[N - 1][2];

        for (int i = N - 2; i >= 0; i--) {
            maxDp[i][0] = Math.max(maxDp[i + 1][0], maxDp[i + 1][1]) + map[i][0];
            maxDp[i][1] = Math.max(maxDp[i + 1][0], Math.max(maxDp[i + 1][1], maxDp[i + 1][2])) + map[i][1];
            maxDp[i][2] = Math.max(maxDp[i + 1][1], maxDp[i + 1][2]) + map[i][2];

            minDp[i][0] = Math.min(minDp[i + 1][0], minDp[i + 1][1]) + map[i][0];
            minDp[i][1] = Math.min(minDp[i + 1][0], Math.min(minDp[i + 1][1], minDp[i + 1][2])) + map[i][1];
            minDp[i][2] = Math.min(minDp[i + 1][1], minDp[i + 1][2]) + map[i][2];
        }

        sb.append(Math.max(maxDp[0][0], Math.max(maxDp[0][1], maxDp[0][2]))).append(" ");
        sb.append(Math.min(minDp[0][0], Math.min(minDp[0][1], minDp[0][2])));

        System.out.println(sb);

    }


}
