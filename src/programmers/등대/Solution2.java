package programmers.등대;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {
        int n = 10;
        int[][] lighthouse = {{4, 1}, {5, 1}, {5, 6}, {7, 6}, {1, 2}, {1, 3}, {6, 8}, {2, 9}, {9, 10}};
        int solution = new Solution2().solution(n, lighthouse);
        System.out.println(solution);
    }
    public int solution(int n, int[][] lighthouse) {
        int answer = 0;
        List<Set<Integer>> list = new ArrayList<>();
        for(int idx = 0; idx <= n; idx++) {
            list.add(new HashSet<>());
        }
        for(int[] lh : lighthouse) {
            list.get(lh[0]).add(lh[1]);
            list.get(lh[1]).add(lh[0]);
        }
        int[] visit = new int[n + 1];
        dfs(list, 1, visit);

        for(int v : visit) {
            if(v == 2) {
                answer++;
            }
        }
        return answer;
    }
    public void dfs(List<Set<Integer>> list, int pos, int[] visit) {
        visit[pos] = 1;
        for(int way : list.get(pos)) {
            if(visit[way] == 0) {
                dfs(list, way, visit);
                if(visit[way] == 1) {
                    visit[pos] = 2;
                }
            }
        }
    }

}
