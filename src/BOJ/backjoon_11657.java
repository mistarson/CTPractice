package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class backjoon_11657 {

    static int N, M;
    static Route[] route;
    static long[] distance;
    static StringBuilder sb = new StringBuilder();
    static final int INF = 500 * 100_000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        route = new Route[M + 1];
        distance = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            distance[i] = INF;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            route[i] = new Route(A, B, C);
        }

        if (bellmanFort()) {
            for (int i = 2; i <= N; i++) {
                if (distance[i] == INF) {
                    sb.append("-1"+"\n");
                } else {
                    sb.append(distance[i] + "\n");
                }
            }
        }else {
            sb.append("-1"+"\n");
        }

        bw.write(sb.toString());
        bw.flush();

    }

    static class Route {
        int start;
        int end;
        int distance;

        public Route(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }

    static boolean bellmanFort() {
        distance[1] = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= M; j++) {
                Route bus =  route[j];

                if (distance[bus.start] != INF && distance[bus.end] > distance[bus.start] + bus.distance) {
                    distance[bus.end] = distance[bus.start] + bus.distance;
                }
            }
        }

        for (int i = 1; i <= M ; i++) {
            Route bus = route[i];

            if (distance[bus.start] != INF && distance[bus.end] > distance[bus.start] + bus.distance) {
                return false;
            }
        }
        return true;
    }

}
