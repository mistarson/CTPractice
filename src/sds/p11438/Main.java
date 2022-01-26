package sds.p11438;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int K = 0;
    static List<Integer>[] graph;
    static int[][] parent;
    static int[] depthes;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i *= 2) {
            K++;
        }

        graph = new ArrayList[N + 1];
        depthes = new int[N + 1];
        parent = new int[K][N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

//        bfs(1);
        dfs(1, 0);
        fillParent();

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(lca(a, b)+"\n");
        }
        bw.flush();
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList();
        depthes[start] = 1;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int end : graph[current]) {
                if (depthes[end] == 0) {
                    depthes[end] = depthes[current] + 1;
                    parent[0][end] = current;
                    queue.add(end);
                }
            }
        }
    }


    static void dfs(int n, int dep) {
        depthes[n] = dep + 1;
        for (int next : graph[n]) {
            if (depthes[next] == 0) {
                parent[0][next] = n;
                dfs(next, depthes[n]);
            }
        }
    }

    static void fillParent() {
        for (int k = 1; k < K; k++) {
            for (int v = 1; v <= N; v++) {
                parent[k][v] = parent[k-1][parent[k-1][v]];
            }
        }
    }


    static int lca(int a, int b) {
        if (depthes[a] < depthes[b]) {
            return lca(b, a);
        }

        for (int i = 0; i < K ; i++) {
            if (((depthes[a] - depthes[b]) & (1 << i)) >= 1) {
                a = parent[i][a];
            }
        }

        if (a == b) {
            return a;
        }

        for (int i = K - 1; i >= 0; i--) {
            if (parent[i][a] != parent[i][b]) {
                a = parent[i][a];
                b = parent[i][b];
            }
        }
        return parent[0][a];
    }
}
