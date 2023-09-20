package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjoon_17835 {
    static int N, M, K;
    static List<List<City>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.get(V).add(new City(U, C));
        }

        // 모든 면접장을 어우르는 가상의 면접장 만들기
        st = new StringTokenizer(br.readLine());
        Set<Integer> interviewSet = new HashSet<>();
        for (int i = 0; i < K; i++) {
            int interview = Integer.parseInt(st.nextToken());
            interviewSet.add(interview);
            graph.get(0).add(new City(interview, 0));
        }

        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.add(new City(0, 0));
        while (!pq.isEmpty()) {
            City currentCity = pq.poll();

            if (dist[currentCity.number] < currentCity.dist) {
                continue;
            }

            List<City> cityList = graph.get(currentCity.number);
            for (City nextCity : cityList) {
                if (dist[nextCity.number] > currentCity.dist + nextCity.dist) {
                    dist[nextCity.number] = currentCity.dist + nextCity.dist;
                    pq.add(new City(nextCity.number, dist[nextCity.number]));
                }
            }
        }


        int maxDistCity = 0;
        long max = 0;
        for (int i = 1; i <= N; i++) {
            if (interviewSet.contains(i)) {
                continue;
            }
            if (max < dist[i]) {
                maxDistCity = i;
                max = dist[i];
            }
        }

        System.out.println(maxDistCity);
        System.out.println(max);
    }

    static class City implements Comparable<City> {
        int number;
        long dist;

        public City(int number, long dist) {
            this.number = number;
            this.dist = dist;
        }

        @Override
        public int compareTo(City o) {
            return (int) (dist - o.dist);
        }
    }
}
