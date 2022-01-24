package backjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjoon_2243 {

    static int n;
    static int S = 1;
    static final int MAX = 1000000;
    static long[] candies;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (S < MAX) {
            S *= 2;
        }
        candies = new long[S * 2];

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());

            if (A == 2) {
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                insertCandies(1, S, 1, B, C);

            } else {
                int B = Integer.parseInt(st.nextToken());
                int target = takeOutCandy(1, S, 1, B);
                insertCandies(1,S,1,target, -1);
                bw.write(target+"\n");
            }
        }
        bw.flush();
    }

    static void insertCandies(int left, int right, int node, int target, int plus) {
        int mid = (left + right) / 2;
        if (left <= target && right >= target) {
            if (left != right) {
                insertCandies(left, mid, node * 2, target, plus);
                insertCandies(mid + 1, right, node * 2 + 1, target, plus);
            }
            candies[node] += plus;
        }
    }

    static int takeOutCandy(int left, int right, int node, long target) {
        int mid = (left + right) / 2;
        if (left == right) {
            return left;
        }
        if (target <= candies[node * 2]) {
            return takeOutCandy(left, mid, node * 2, target);
        } else {
            return takeOutCandy(mid +1 , right, node * 2 + 1, target-candies[node * 2]);
        }
    }

//    static void updateCandy(int left, int right, int node, int target) {
//        int mid = (left + right) / 2;
//        if (left <= target && right >= target) {
//            if (left != right) {
//                insertCandies(left, mid, node * 2, target, -1);
//                insertCandies(mid + 1, right, node * 2 + 1, target, -1);
//            }
//            candies[node] += -1;
//        }
//    }
}

