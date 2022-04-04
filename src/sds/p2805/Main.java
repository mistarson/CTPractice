package sds.p2805;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static long[] tree;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/sds/p2805/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new long[N];

        st = new StringTokenizer(br.readLine());
        long max = Integer.MIN_VALUE;


        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }

        long start = 0;
        long end = max;
        long result = 0;

        while (start <= end) {
            long sum = 0;
            long mid = (start + end) / 2;

            for (int i = 0; i < N; i++) {
                if (mid < tree[i]) {
                    sum += tree[i] - mid;
                }
            }

            if (sum >= M) {
                if (result < mid) {
                    result = mid;
                }
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        bw.write(String.valueOf(result));
        bw.flush();

    }
}
