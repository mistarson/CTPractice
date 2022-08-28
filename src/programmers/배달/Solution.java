package programmers.배달;

import java.util.*;

public class Solution {
    static List<List<Town>> graph = new ArrayList<>();
    static boolean[] isVisited;
    static int[] possibleDelivery;

    public static void main(String[] args) {
        int N = 6;
        int[][] road = {{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};
        int K = 4;

        int solution = new Solution().solution(N, road, K);
        System.out.println(solution);

    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        possibleDelivery = new int[N + 1];
        isVisited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < road.length; i++) {
            int start = road[i][0];
            int end = road[i][1];
            int dist = road[i][2];

            graph.get(start).add(new Town(end, dist));
            graph.get(end).add(new Town(start, dist));
        }

        Arrays.fill(possibleDelivery, Integer.MAX_VALUE);
        isVisited[1] = true;
        possibleDelivery[1] = 0;

        findDelivery(1, 0, K);

        for (int time : possibleDelivery) {
            if (time <= K) {
                answer++;
            }
        }

        return answer;
    }

    static void findDelivery(int town, int dist, int K) {

        for (Town next : graph.get(town)) {

            if (possibleDelivery[next.end] < dist + next.dist) {
                continue;
            }

            if (!isVisited[next.end] && dist + next.dist <= K) {
                possibleDelivery[next.end] = dist + next.dist;
                isVisited[next.end] = true;
                findDelivery(next.end, dist + next.dist, K);
                isVisited[next.end] = false;
            }

        }
    }

    static class Town {
        int end;
        int dist;

        public Town(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }
    }
}
