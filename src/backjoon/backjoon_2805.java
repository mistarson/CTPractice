package backjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjoon_2805 {

    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        tree = new long[N + 1];

        long top = Long.MIN_VALUE;
        long bottom = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            top = Math.max(top, tree[i]);
        }

        while (bottom <= top) {
            long mid = (top + bottom) / 2;
            long sum = 0;

            for (int i = 1; i <= N; i++) {
                if (tree[i] > mid) {
                    sum += tree[i] - mid;
                }
            }

            if (sum >= M) {
                bottom = mid + 1;
            } else {
                top = mid - 1;
            }
        }
        bw.write(top + "");
        bw.flush();
    }
}
