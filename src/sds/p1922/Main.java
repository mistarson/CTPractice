package sds.p1922;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static PriorityQueue<Node> nodesSortByDistance = new PriorityQueue<>();
    static int[] nodes;
    static int[] edges;
    static int edgeCount = 0;
    static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        nodes = new int[N + 1];
        edges = new int[M + 1];

        for (int i = 1; i <= N; i++) {
            nodes[i] = i;
        }


        for (int i = 0; i < M; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            nodesSortByDistance.add(new Node(node1, node2, distance));

        }

        while (true) {
            if (edgeCount == N - 1) {
                break;
            }
            Node node = nodesSortByDistance.poll();
            if (union(node.node1, node.node2)) {
                edgeCount++;
                result += node.distance;
            }
        }

        bw.write(result + "");
        bw.flush();

    }

    static class Node implements Comparable<Node>{
        int node1;
        int node2;
        int distance;

        public Node(int node1, int node2, int distance) {
            this.node1 = node1;
            this.node2 = node2;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(distance, o.distance);
        }
    }

    static int find(int a) {
        if (nodes[a] == a) {
            return a;
        } else {
            return nodes[a] = find(nodes[a]);
        }
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot != bRoot) {
            nodes[aRoot] = bRoot;
            return true;
        } else {
            return false;
        }
    }
}
