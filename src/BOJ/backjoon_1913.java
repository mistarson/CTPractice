package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_1913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int[][] map = new int[N][N];
        int dir = 3;
        int move = 1;
        int currentMove = 0;
        int r = N / 2;
        int c = r;
        int value = 1;
        int answer_r = 0;
        int answer_c = 0;
        for (int i = 0; i < N * N; i++) {

            // 주어진 자연수가 적힌 좌표 값을 찾기 위한 값 저장
            if (value == target) {
                answer_r = r + 1;
                answer_c = c + 1;
            }

            map[r][c] = value++;

            r += dr[dir];
            c += dc[dir];
            currentMove++;

            // 지정된 거리를 모두 움직였을 때
            if (currentMove == move) {

                // 방향을 전에 바꾼 적이 있다면 움직이는 거리를 늘려줘야 함
                if (dir == 0 || dir == 2) {
                    move++;
                }

                dir = (dir + 1) % 4;
                currentMove = 0;
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        sb.append(answer_r).append(" ").append(answer_c);

        System.out.println(sb);

    }
}