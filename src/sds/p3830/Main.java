//package sds.p3830;
//
//import java.io.*;
//import java.util.StringTokenizer;
//
//public class Main {
//
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    static StringTokenizer st;
//    static int N, M;
//    static int a, b;
//    static int[] samples;
//    static int[] weightDiff;
//
//    public static void main(String[] args) throws IOException {
//
//        st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        samples = new int[N + 1];
//        weightDiff = new int[N + 1];
//        for (int i = 1; i <= N; i++) {
//            samples[i] = i;
//        }
//
//
//        for (int i = 0; i < M ; i++) {
//            st = new StringTokenizer(br.readLine());
//            if (st.nextToken() == "!") {
//
//            } else {
//
//            }
//        }
//
//
//
//    }
//
//    static void unionFind(int a, int b, int diff) {
//        int aRoot = find(a);
//        int bRoot = find(b);
//
//
//    }
//
//    static int find(int n) {
//        if (samples[n] == n) {
//            return n;
//        } else {
//            int parentIndex = find(samples[n]);
//            weightDiff[n] += weightDiff[parentIndex];
//            samples[n] = parentIndex;
//        }
//    }
//
//}
