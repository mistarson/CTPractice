package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class backjoon_10423 {
    static int N, M, K;
    static int[] uf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        uf = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            uf[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int powerPlant = Integer.parseInt(st.nextToken());
            uf[powerPlant] = -1;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Edge(nodeA, nodeB, cost));
        }

        int cost = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (find(edge.nodeA) != find(edge.nodeB)) {
                cost += edge.cost;
                union(edge.nodeA, edge.nodeB);
            }

            boolean isAllConnect = true;
            for (int i = 1; i <= N; i++) {
                if (uf[i] != -1) {
                    isAllConnect = false;
                }
            }

            if (isAllConnect) {
                break;
            }
        }

        System.out.println(cost);

    }

    static void union(int A, int B) {
        A = find(A);
        B = find(B);

        if (A != B) {
            if (A == -1) {
                uf[B] = A;
            } else if (B == -1) {
                uf[A] = B;
            } else {
                if (A == -1 && B == -1) {
                    return;
                } else {
                    uf[B] = A;
                }
            }
        }

    }

    static int find(int node) {
        if (uf[node] == -1) {
            return -1;
        }

        if (uf[node] == node) {
            return node;
        }

        return uf[node] = find(uf[node]);

    }

    static class Edge implements Comparable<Edge> {
        int nodeA;
        int nodeB;
        int cost;

        public Edge(int nodeA, int nodeB, int cost) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(cost, o.cost);
        }
    }
}
