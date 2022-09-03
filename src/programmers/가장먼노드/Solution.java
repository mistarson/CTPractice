package programmers.가장먼노드;

import java.util.*;

public class Solution {
    static int solution(int n, int[][] edge) {
        int answer = 0;

        int[] dist = new int[n + 1];
        boolean[] isVisited = new boolean[n + 1];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            int start = edge[i][0];
            int end = edge[i][1];

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        int maxDist = Integer.MIN_VALUE;
        isVisited[1] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0));
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (Integer next : graph.get(current.node)) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    dist[next] = current.dist + 1;
                    maxDist = Math.max(maxDist, dist[next]);
                    queue.add(new Node(next, current.dist + 1));
                }
            }
        }

        for (int i : dist) {
            if (i == maxDist) {
                answer++;
            }
        }

        return answer;
    }

    static class Node {
        int node;
        int dist;

        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
}
