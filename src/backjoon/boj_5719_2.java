package backjoon;

import java.io.*;
import java.util.*;

public class boj_5719_2 {
    static class info implements Comparable<info> {
        int node;
        int distance;
        boolean isShortest;

        public info(int node, int distance) {
            this.node = node;
            this.distance = distance;
            this.isShortest = false;
        }

        @Override
        public int compareTo(info o) {
            return Integer.compare(distance, o.distance);
        }
    }

    static int N, M;
    static ArrayList<info> [] Map;
    static ArrayList<Integer> [] Tracking;
    static int [] Distance;
    static int Start, Destination;
    static final int INF = Integer.MAX_VALUE;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws NumberFormatException, IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if(N == 0 && M == 0) {
                break;
            }

            st = new StringTokenizer(br.readLine(), " ");
            Start = Integer.parseInt(st.nextToken());
            Destination = Integer.parseInt(st.nextToken());

            Map = new ArrayList [N + 1];
            Tracking = new ArrayList [N + 1];
            Distance = new int [N + 1];
            for(int i = 0 ; i < N ; i++) {
                Map[i] = new ArrayList<>();

            }

            int u, v, p;
            for(int i = 1 ; i <= M ;i++) {
                st = new StringTokenizer(br.readLine(), " ");
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                p = Integer.parseInt(st.nextToken());
                Map[u].add(new info(v, p));
            }

            findShortestPath(Start);

            // 최단 경로가 없는 경우.
            if(Distance[Destination] == INF) {
                bw.write(-1 + "\n");
                continue;
            }

            findShortestEdge(Destination, Start);
            findShortestPath(Start);

            if(Distance[Destination] == INF) {
                bw.write(-1 + "\n");
            } else {
                bw.write(Distance[Destination] + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    private static void findShortestEdge(int now, int end) {
        if(now == end) {
            return;
        }

        for(int next : Tracking[now]) {
            for(int i = 0 ; i < Map[next].size() ; i++) {
                if(Map[next].get(i).node == now && Map[next].get(i).isShortest == false) {
                    Map[next].get(i).isShortest = true;
                    findShortestEdge(next, end);
                }
            }
        }
    }

    // 다익스트라 알고리즘
    private static void findShortestPath(int start) {
        for(int i = 0 ; i < N ; i++) {
            Tracking[i] = new ArrayList<>();
        }
        Arrays.fill(Distance, INF);
        PriorityQueue<info> pq = new PriorityQueue<>();
        Distance[start] = 0;
        pq.add(new info(start,0));

        while(pq.isEmpty() == false) {
            info now = pq.poll();

            if(now.distance > Distance[now.node]) {
                continue;
            }

            for(info next : Map[now.node]) {
                if(next.isShortest == true) {
                    continue;
                }
                if(Distance[next.node] == Distance[now.node] + next.distance) {
                    Tracking[next.node].add(now.node);
                }
                if(Distance[next.node] > Distance[now.node] + next.distance) {
                    Tracking[next.node].clear();
                    Tracking[next.node].add(now.node);
                    Distance[next.node] = Distance[now.node] + next.distance;
                    pq.add(new info(next.node, Distance[next.node]));
                }
            }
        }
    }
}
