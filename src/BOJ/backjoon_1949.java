package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class backjoon_1949 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] town;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        town = new int[N + 1];
        dp = new int[N + 1][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            town[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        getTownSum(1, 0);

        System.out.println(Math.max(dp[1][0], dp[1][1]));

    }

    static void getTownSum(int node, int parent) {
        for (Integer next : graph.get(node)) {
            if (next != parent) {
                getTownSum(next, node);
                dp[node][0] += Math.max(dp[next][0], dp[next][1]);
                dp[node][1] += dp[next][0];
            }
        }
        dp[node][1] += town[node];
    }

}
