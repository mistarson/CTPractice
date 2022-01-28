package backjoon;

import java.io.*;
import java.util.*;

public class backjoon_5719 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, M, S, D;
    static List<Node>[] graph;
    static List<Integer>[] tracking;
    static int[] dist;
    static boolean[][] isShortPath;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        while (true) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }

            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N + 1];
            dist = new int[N + 1];
            tracking = new ArrayList[N + 1];
            isShortPath = new boolean[N + 1][N + 1];

            for (int i = 0; i <= N; i++) {
                graph[i] = new ArrayList<>();
                tracking[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int U = Integer.parseInt(st.nextToken());
                int V = Integer.parseInt(st.nextToken());
                int P = Integer.parseInt(st.nextToken());

                graph[U].add(new Node(V, P));
            }

            findShortestPath(S);

            if (dist[D] == INF) {
                bw.write("-1\n");
                continue;
            }
            findShortestEdge(D, S);
            findShortestPath(S);

            if (dist[D] == INF) {
                bw.write("-1\n");
            } else {
                bw.write(dist[D] + "\n");
            }
        }
        bw.flush();
    }

    static class Node implements Comparable<Node> {
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

    static void findShortestPath(int start) {
        Arrays.fill(dist,INF);
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.distance > dist[current.node]) {
                continue;
            }

            for (Node next : graph[current.node]) {
                if (isShortPath[current.node][next.node] == true) {
                    continue;
                }
                if (dist[next.node] > current.distance + next.distance) {
                    tracking[next.node].clear();
                    tracking[next.node].add(current.node);
                    dist[next.node] = current.distance + next.distance;
                    queue.add(new Node(next.node, dist[next.node]));
                }
                if (dist[next.node] == current.distance + next.distance) {
                    tracking[next.node].add(current.node);
                }
            }
        }
    }

    static void findShortestEdge(int start, int end) {
        if (start == end) {
            return;
        }

        for (int next : tracking[start]) {
            if (isShortPath[next][start] == false) {
                isShortPath[next][start] = true;
                findShortestEdge(next, end);
            }
        }
    }

}
