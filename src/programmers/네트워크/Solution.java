package programmers.네트워크;

import java.util.*;

public class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++){
            List<Integer> list = graph.get(i);
            for (int j = 0; j < n; j++){
                if(i == j){
                    continue;
                }
                if(computers[i][j] == 1){
                    list.add(j);
                }
            }
        }

        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++){
            if(!isVisited[i]){
                answer++;
                dfs(i, graph, isVisited);
            }
        }

        return answer;
    }

    static void dfs(int node, List<List<Integer>> graph, boolean[] isVisited){
        for(int other : graph.get(node)){
            if(!isVisited[other]){
                isVisited[other] = true;
                dfs(other, graph, isVisited);
            }
        }
    }
}
