package programmers.전력망을둘로나누기;

import java.util.*;

public class Solution {
    static int minDiff = Integer.MAX_VALUE;

    public int solution(int n, int[][] wires) {
        int answer = -1;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < wires.length; i++) {
            int nodeA = wires[i][0];
            int nodeB = wires[i][1];

            graph.get(nodeA).add(nodeB);
            graph.get(nodeB).add(nodeA);
        }

        for (int i = 0; i < wires.length; i++) {
            int nodeA = wires[i][0];
            int nodeB = wires[i][1];

            minDiff = Math.min(minDiff, Math.abs(getNodeCnt(nodeA, nodeB, graph, n) - getNodeCnt(nodeB, nodeA, graph, n)));

        }

        return answer;
    }

    static int getNodeCnt(int node, int againstNode, List<List<Integer>> graph, int n) {
        int cnt = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        boolean[] isVisited = new boolean[n + 1];
        isVisited[node] = true;
        isVisited[againstNode] = true;
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            for (Integer next : graph.get(current)) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    queue.add(next);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
