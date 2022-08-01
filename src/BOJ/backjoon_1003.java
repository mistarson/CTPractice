package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_1003 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int T;
    static int[][] answer = new int[41][2];

    public static void main(String[] args) throws IOException {

        answer[0][0] = 1;
        answer[1][1] = 1;
        for (int i = 2; i <= 40; i++) {
            answer[i][0] = answer[i - 1][0] + answer[i - 2][0];
            answer[i][1] = answer[i - 1][1] + answer[i - 2][1];
        }

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(answer[N][0]).append(" ").append(answer[N][1]).append("\n");
        }

        System.out.println(sb);

    }

}
