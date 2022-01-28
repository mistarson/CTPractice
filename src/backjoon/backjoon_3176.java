package backjoon;

import java.io.*;
import java.util.*;

public class backjoon_3176 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, M;
    static int K = 0;
    static List<Node>[] graph;
    static int[] depth;
    static int[][] parent;
    static int[][] minLength;
    static int[][] maxLength;
    static int minResult;
    static int maxResult;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        for (int i = 1; i < N; i *= 2) {
            K++;
        }

        graph = new ArrayList[N + 1];
        parent = new int[K + 1][N + 1];
        depth = new int[N + 1];
        minLength = new int[K + 1][N + 1];
        maxLength = new int[K + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph[A].add(new Node(B, C));
            graph[B].add(new Node(A, C));
        }

        bfs(1);

        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                parent[i][j] = parent[i - 1][parent[i - 1][j]];
                minLength[i][j] = Math.min(minLength[i - 1][j], minLength[i - 1][parent[i - 1][j]]);
                maxLength[i][j] = Math.max(maxLength[i - 1][j], maxLength[i - 1][parent[i - 1][j]]);
            }
        }

        for (int[] arr : minLength) {
            System.out.println(Arrays.toString(arr));
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            findLCA(D, E);
            bw.write(minResult + " " + maxResult + "\n");
        }
        bw.flush();
    }

    static void bfs(int root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        depth[root] = 1;
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (Node nextNode : graph[currentNode]) {
                if (depth[nextNode.node] == 0) {
                    depth[nextNode.node] = depth[currentNode] + 1;
                    parent[0][nextNode.node] = currentNode;
                    minLength[0][nextNode.node] = nextNode.distance;
                    maxLength[0][nextNode.node] = nextNode.distance;
                    queue.add(nextNode.node);
                }
            }
        }

    }

    static int findLCA(int D, int E) {
        if (depth[D] < depth[E]) {
            return findLCA(E, D);
        }

        minResult = Integer.MAX_VALUE;
        maxResult = Integer.MIN_VALUE;

        for (int i = 0; i <= K; i++) {
            if(((depth[D] - depth[E]) & (1 << i)) >= 1) {
                minResult = Math.min(minResult, minLength[i][D]);
                maxResult = Math.max(maxResult, maxLength[i][D]);
                D = parent[i][D];
            }
        }

        if (D == E) {
            return D;
        }

        for (int i = K; i >= 0; i--) {
            if (parent[i][D] != parent[i][E]) {
                minResult = Math.min(minResult, Math.min(minLength[i][D], minLength[i][E]));
                maxResult = Math.max(maxResult, Math.max(maxLength[i][D], maxLength[i][E]));
                D = parent[i][D];
                E = parent[i][E];
            }
        }
        minResult = Math.min(minResult, Math.min(minLength[0][D], minLength[0][E]));
        maxResult = Math.max(maxResult, Math.max(maxLength[0][D], maxLength[0][E]));

        return parent[0][D];
    }

    static class Node {
        int node;
        int distance;

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

}
