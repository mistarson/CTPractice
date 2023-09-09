package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class backjoon_1922 {
    static int[] end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        end = new int[N + 1];
        for (int i = 1; i < end.length; i++) {
            end[i] = i;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.add(new Node(from, to, cost));
        }

        int edgeCnt = 0;
        int totalCost = 0;
        while (edgeCnt < N - 1) {
            Node connectionInfo = pq.poll();
            if (union(connectionInfo.from, connectionInfo.to)) {
                edgeCnt++;
                totalCost += connectionInfo.cost;
            }
        }

        System.out.println(totalCost);

    }

    private static boolean union(int from, int to) {
        int A = find(from);
        int B = find(to);

        if (A != B) {
            end[B] = A;
            return true;
        }
        return false;
    }

    private static int find(int node) {
        if (end[node] == node) {
            return node;
        }return end[node] = find(end[node]);
    }

    static class Node implements Comparable<Node>{
        int from;
        int to;
        int cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }


        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
}
