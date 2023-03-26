package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_16922 {
    static int[] loma = {1, 5, 10, 50};
    static int N;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        boolean[] isVisited = new boolean[1001];

        findAnswer(0, 0, 0, isVisited);

        System.out.println(answer);
    }

    static void findAnswer(int cnt, int sum, int idx, boolean[] isVisited) {
        if (cnt >= N) {
            if (!isVisited[sum]) {
                isVisited[sum] = true;
                answer++;
            }
            return;
        }
        for (int i = idx; i < 4; i++) {
            findAnswer(cnt + 1, sum + loma[i], i, isVisited);
        }
    }
}
