package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class boj_2243 {

    static int MAX = 1000000;
    static long[] candies;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int count = Integer.parseInt(br.readLine());

        int S = 1;
        while (S < MAX) {
            S *= 2;
        }

        candies = new long[S * 2];


        for (int i = 0; i < count; i++) {

            st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());

            if (A == 1) {
                long B = Long.parseLong(st.nextToken());
                long candy = pop(1, S, 1, B);
                update(1, S, 1, candy, -1);
                bw.write(candy+"\n");
            } else {
                long B = Long.parseLong(st.nextToken());
                long C = Long.parseLong(st.nextToken());
                update(1, S, 1, B, C);
            }
        }
        bw.flush();
    }

    static void update(long left, long right, int node, long taste, long count) {
        if (left <= taste && right >= taste) {
            candies[node] += count;
            if (left != right) {
                long mid = (left + right) / 2;
                update(left, mid, node * 2, taste, count);
                update(mid + 1, right, node * 2 + 1, taste, count);
            }
        }
    }

    static long pop(long left, long right, int node, long taste) {
        if (left == right) {
            return left;
        }
        long mid = (left + right) / 2;
        if (candies[node * 2] >= taste) {
            return pop(left, mid, node * 2, taste);
        } else {
            return pop(mid + 1, right, node * 2 + 1, taste - candies[node * 2]);
        }
    }
}
