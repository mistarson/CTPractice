package sds.p11438;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, K = 1;
    static int[][] tree;
    static int[] depth;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        depth = new int[N + 1];

        int cnt = 0;
        while (N > K) {
            K *= 2;
            cnt++;
        }

        tree = new int[K][N + 1];

        while (true) {
            String str = br.readLine();
            if (str.length() == 0) {
                break;
            } else {
                StringTokenizer st = new StringTokenizer(str);
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                tree

            }

        }
    }
}
