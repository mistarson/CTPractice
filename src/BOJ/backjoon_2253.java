//package BOJ;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class backjoon_2253 {
//    static int N;
//    static int M;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        int[] dp = new int[N + 1];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0] = 0;
//        dp[1] = 1;
//
//        for (int i = 0; i < M; i++) {
//            int impossible = Integer.parseInt(br.readLine());
//            dp[impossible] = -1;
//        }
//
//        for (int i = 2; i <= N; i++) {
//            dp[i] = Math.min()
//        }
//
//
//        System.out.println(dp[N]);
//    }
//}
