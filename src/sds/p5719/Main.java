package sds.p5719;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int start, end;
    static List<Place>[] graph;
    static List<Integer>[] route;
    static int[] dist;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        route = new ArrayList[N];
        dist = new int[N];
        Arrays.fill(dist, INF);

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
            route[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            graph[U].add(new Place(V, P));
        }

        daik(start);









    }

    static class Place implements Comparable<Place> {
        int place;
        int distance;

        public Place(int place, int distance) {
            this.place = place;
            this.distance = distance;
        }

        @Override
        public int compareTo(Place o) {
            return Integer.compare(distance, o.distance);
        }
    }

    static void daik(int start) {
        PriorityQueue<Place> queue = new PriorityQueue();
        dist[start] = 0;

    }

}
