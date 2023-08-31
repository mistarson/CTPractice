package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjoon_1939 {
    static int N, M, S, E;
    static int maxWeight = 0;
    static List<List<Bridge>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weightLimit = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Bridge(to, weightLimit));
            graph.get(to).add(new Bridge(from, weightLimit));
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int[] maxWeightArr = new int[N + 1];

        PriorityQueue<Bridge> queue = new PriorityQueue<>();
        queue.add(new Bridge(S, Integer.MAX_VALUE));
        while (!queue.isEmpty()) {
            Bridge current = queue.poll();

            if (current.to == E) {
                maxWeight = Math.max(maxWeight, current.weightLimit);
                continue;
            }

            if (maxWeightArr[current.to] > current.weightLimit) {
                continue;
            }

            for (Bridge next : graph.get(current.to)) {
                int weight = Math.min(next.weightLimit, current.weightLimit);
                if (maxWeightArr[next.to] < weight) {
                    maxWeightArr[next.to] = weight;
                    queue.add(new Bridge(next.to, weight));
                }
            }
        }

        System.out.println(maxWeight);

    }

    static class Bridge implements Comparable<Bridge> {
        int to;
        int weightLimit;

        public Bridge(int to, int weightLimit) {
            this.to = to;
            this.weightLimit = weightLimit;
        }

        @Override
        public int compareTo(Bridge o) {
            return o.weightLimit - weightLimit;
        }
    }
}
