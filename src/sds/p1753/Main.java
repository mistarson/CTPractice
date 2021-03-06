package sds.p1753;

import java.io.*;
import java.util.*;

public class Main {

    static int V, E, start;
    static List<Node>[] nodes;
    static PriorityQueue<Node> route = new PriorityQueue<>();
    static int[] distance;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        distance = new int[V + 1];
        Arrays.fill(distance,INF);
        nodes = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            nodes[u].add(new Node(v, w));
        }

        findShortestPath(start);

        for(int i = 1 ; i<= V ; i++) {
            if(distance[i] != INF) {
                bw.write(distance[i] + "\n");
            } else {
                bw.write("INF" + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    static void findShortestPath(int startNode) {
        distance[start] = 0;
        route.add(new Node(startNode, 0));

        while (!route.isEmpty()) {
            Node currentNode = route.poll();

            if (currentNode.distance > distance[currentNode.node]) {
                continue;
            }

            for (Node next : nodes[currentNode.node]) {
                if (distance[next.node] > distance[currentNode.node] + next.distance) {
                    distance[next.node] = distance[currentNode.node] + next.distance;
                    route.add(new Node(next.node, distance[next.node]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int node;
        int distance;

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(distance, o.distance);
        }
    }
}
