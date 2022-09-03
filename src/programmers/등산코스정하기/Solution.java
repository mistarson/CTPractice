package programmers.등산코스정하기;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int n = 7;
        int[][] paths = {{1, 2, 5}, {1, 4, 1}, {2, 3, 1}, {2, 6, 7}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}};
        int[] gates = {3, 7};
        int[] summits = {1, 5};

        int[] solution = solution(n, paths, gates, summits);

        System.out.println(Arrays.toString(solution));

    }

    static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];

        Set<Integer> summitSet = new HashSet<>();
        for (int summit : summits) {
            summitSet.add(summit);
        }

        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < paths.length; i++) {
            int start = paths[i][0];
            int end = paths[i][1];
            int dist = paths[i][2];

            graph.get(start).add(new Node(end, dist));
            graph.get(end).add(new Node(start, dist));
        }

        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);

        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < gates.length; i++) {
            intensity[gates[i]] = 0;
            queue.add(new Node(gates[i], 0));
        }
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (summitSet.contains(current.end) || current.dist > intensity[current.end]) {
                continue;
            }

            for (Node next : graph.get(current.end)) {
                if (intensity[next.end] > Math.max(intensity[current.end], next.dist)) {
                    intensity[next.end] = Math.max(intensity[current.end], next.dist);
                    queue.add(new Node(next.end, intensity[next.end]));
                }
            }
        }

        Arrays.sort(summits);

        int minSummit = 0;
        int minIntensity = Integer.MAX_VALUE;
        for (int i = 0; i < summits.length; i++) {
            if (intensity[summits[i]] < minIntensity) {
                minSummit = summits[i];
                minIntensity = intensity[summits[i]];
            }
        }

        answer[0] = minSummit;
        answer[1] = minIntensity;

        return answer;
    }

    static class Node {
        int end;
        int dist;

        public Node(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }
    }
}
