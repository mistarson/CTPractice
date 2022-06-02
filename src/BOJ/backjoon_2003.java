package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_2003 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static long M;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        seq = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        long sum = seq[0];

        int cnt = 0;
        while (end < N) {

            if (sum == M) {
                cnt++;
            }

            if (sum >= M) {
                sum -= seq[start++];
            } else {
                sum += seq[++end];
            }

        }

        System.out.println(cnt);
    }
}
