package sds.p1717;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[] set;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        set = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            set[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);

            } else {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                isUnion(a, b);

            }

        }
    }

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        set[aRoot] = bRoot;
    }

    static int find(int a) {
        if (set[a] == a) {
            return a;
        } else {
            return set[a] = find(set[a]);
        }
    }

    static void isUnion(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
