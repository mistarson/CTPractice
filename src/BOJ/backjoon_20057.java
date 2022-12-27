package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_20057 {
    static int N;
    static int[][] A;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};
    static int outSand = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int dir = 0;
        int current_r = N / 2;
        int current_c = N / 2;
        int move = 1;
        int moveCnt = 0;
        for (int i = 0; i < (N * N) - 1; i++) {

            moveSand(dir, current_r, current_c);

            current_r += dr[dir];
            current_c += dc[dir];
            moveCnt++;

            if (move == moveCnt) {
                if (dir == 1 || dir == 3) {
                    move++;
                }
                dir = (dir + 1) % 4;
                moveCnt = 0;
            }
        }

        System.out.println(outSand);
    }

    static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    static void moveSand(int dir, int hurri_r, int hurri_c) {

        int sand_r = hurri_r + dr[dir];
        int sand_c = hurri_c + dc[dir];
        int right_dir = (dir + 4 - 1) % 4;
        int left_dir = (dir + 1) % 4;
        int totalSand = A[sand_r][sand_c];
        int accumulateSand = 0;

        // 직선 5%
        int area1_r = hurri_r + dr[dir] * 3;
        int area1_c = hurri_c + dr[dir] * 3;
        accumulateSand += isOutElseAddSand(area1_r, area1_c, sand_r, sand_c, 0.05);

        // 오른쪽 10%
        int area2_r = hurri_r + (dr[dir] * 2) + dr[right_dir];
        int area2_c = hurri_c + (dc[dir] * 2) + dc[right_dir];
        accumulateSand += isOutElseAddSand(area2_r, area2_c, sand_r, sand_c, 0.1);

        // 오른쪽 7%
        int area3_r = hurri_r + dr[dir] + dr[right_dir];
        int area3_c = hurri_c + dc[dir] + dc[right_dir];
        accumulateSand += isOutElseAddSand(area3_r, area3_c, sand_r, sand_c, 0.07);

        // 오른쪽 2%
        int area4_r = hurri_r + dr[dir] + (dr[right_dir] * 2);
        int area4_c = hurri_c + dc[dir] + (dc[right_dir] * 2);
        accumulateSand += isOutElseAddSand(area4_r, area4_c, sand_r, sand_c, 0.02);

        // 오른쪽 1%
        int area5_r = hurri_r + dr[right_dir];
        int area5_c = hurri_c + dc[right_dir];
        accumulateSand += isOutElseAddSand(area5_r, area5_c, sand_r, sand_c, 0.01);

        // 왼쪽 10%
        int area6_r = hurri_r + (dr[dir] * 2) + dr[left_dir];
        int area6_c = hurri_c + (dc[dir] * 2) + dc[left_dir];
        accumulateSand += isOutElseAddSand(area6_r, area6_c, sand_r, sand_c, 0.1);

        // 왼쪽 7%
        int area7_r = hurri_r + dr[dir] + dr[left_dir];
        int area7_c = hurri_c + dc[dir] + dc[left_dir];
        accumulateSand += isOutElseAddSand(area7_r, area7_c, sand_r, sand_c, 0.07);

        // 왼쪽 2%
        int area8_r = hurri_r + dr[dir] + (dr[left_dir] * 2);
        int area8_c = hurri_c + dc[dir] + (dc[left_dir] * 2);
        accumulateSand += isOutElseAddSand(area8_r, area8_c, sand_r, sand_c, 0.02);

        // 왼쪽 1%
        int area9_r = hurri_r + dr[left_dir];
        int area9_c = hurri_c + dc[left_dir];
        accumulateSand += isOutElseAddSand(area9_r, area9_c, sand_r, sand_c, 0.01);

        // 나머지 모래
        int area10_r = hurri_r + (dr[dir] * 2);
        int area10_c = hurri_c + (dc[dir] * 2);
        int extraSand = totalSand - accumulateSand;
        if (inRange(area10_r, area10_c)) {
            A[area10_r][area10_c] += extraSand;
        } else outSand += extraSand;

        A[sand_r][sand_c] = 0;

    }

    static int isOutElseAddSand(int r, int c, int sand_r, int sand_c, double percent) {
        int sand = (int) (A[sand_r][sand_c] * percent);
        if (inRange(r, c)) {
            A[r][c] += sand;
        } else outSand += sand;

        return sand;
    }
}
