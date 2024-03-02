package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_1421 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int max = 0;

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long answer = 0;
        for (int i = 1; i <= max; i++) {
            long sum = 0;
            for (int j = 0; j < N; j++) {
                int cnt = 0;
                if (arr[j] >= i) {
                    cnt += arr[j] / i;
                    if (arr[j] % i == 0) {
                        cnt -= 1;
                    }
                }
                int cost = (arr[j] / i * i * W) - (cnt * C);
                if (cost > 0) {
                    sum += cost;
                }
            }
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }
}
