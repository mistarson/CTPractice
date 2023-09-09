package programmers.등대;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int n = 10;
        int[][] lighthouse = {{4, 1}, {5, 1}, {5, 6}, {7, 6}, {1, 2}, {1, 3}, {6, 8}, {2, 9}, {9, 10}};
        new Solution().solution(n, lighthouse);
    }
    public int solution(int n, int[][] lighthouse) {
        if (n == 2) {
            return 1;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < lighthouse.length; i++) {
            graph.get(lighthouse[i][0]).add(lighthouse[i][1]);
            graph.get(lighthouse[i][1]).add(lighthouse[i][0]);
        }

        Set<Integer> lightHouses = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            //리프 노드면
            if (graph.get(i).size() == 1) {
                lightHouses.add(graph.get(i).get(0));
            }
        }

        Queue<Integer> queue = new LinkedList<>(lightHouses);
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            for (Integer other : graph.get(current)) {
                //현재 이어진 곳이 불이 안켜진 곳이라면
                if (!lightHouses.contains(other)) {
                    for (Integer another : graph.get(other)) {
                        if (!lightHouses.contains(another)) {
                            lightHouses.add(another);
                            queue.add(another);
                        }
                    }
                }
            }
        }


        System.out.println(lightHouses);


        return 1;
    }
}
