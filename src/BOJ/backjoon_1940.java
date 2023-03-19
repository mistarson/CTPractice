package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_1940 {
    static int N, M;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        getArmorCount(0, 0, arr, 0);

        System.out.println(answer);

    }

    static void getArmorCount(int sum, int cnt, int[] arr, int start) {
        if (cnt >= 2) {
            if (sum == M) {
                answer++;
            }
            return;
        }

        for (int i = start; i < N; i++) {
            getArmorCount(sum + arr[i], cnt + 1, arr, i + 1);
        }
    }
}
