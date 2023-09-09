package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_20543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] bombMap = new int[N][N];
        for (int i = 0; i <= N - M; i++) {
            for (int j = 0; j <= N - M; j++) {
                recoveryGround(i, j, map, bombMap, M);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] ints : bombMap) {
            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void recoveryGround(int r, int c, int[][] map, int[][] bombMap, int M) {

        int max = Integer.MIN_VALUE;
        for (int i = r; i < r + M; i++) {
            for (int j = c; j < c + M; j++) {
                max = Math.max(max, map[i][j]);
            }
        }

        if (max == 0) {
            return;
        }

        for (int i = r; i < r + M; i++) {
            for (int j = c; j < c + M; j++) {
                map[i][j] += Math.abs(max);
            }
        }
        if (M == 1) {
            bombMap[r][c] += max;
        } else bombMap[r + (M / 2)][c + (M / 2)] += Math.abs(max);
    }
}
