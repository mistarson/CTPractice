package programmers.야간전술보행;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int distance = 12;
        int[][] scope = {{7, 8}, {4, 6}, {11, 10}};
        int[][] times = {{2, 2}, {2, 4}, {3, 3}};
        int solution = new Solution().solution(distance, scope, times);
        System.out.println(solution);
    }

    public int solution(int distance, int[][] scope, int[][] times) {
        int answer = 1;

        List<Guard> guardList = new ArrayList<>();
        for (int i = 0; i < scope.length; i++) {
            int from = Math.min(scope[i][0], scope[i][1]);
            int to = Math.max(scope[i][0], scope[i][1]);
            guardList.add(new Guard(from, to, times[i][0], times[i][1]));
        }

        Collections.sort(guardList);

        int idx = 0;
        while (idx < guardList.size()) {
            if (answer >= guardList.get(idx).from && answer <= guardList.get(idx).to) {
                int guardCycle = guardList.get(idx).workTime + guardList.get(idx).restTime;
                int mod = answer % guardCycle;
                if (mod > 0 && mod <= guardList.get(idx).workTime) {
                    break;
                } else {
                    answer++;
                    if (answer > guardList.get(idx).to) {
                        idx++;
                    }
                }
            } else {
                answer++;
            }

        }
        return answer;
    }

    static class Guard implements Comparable<Guard> {
        int from;
        int to;
        int workTime;
        int restTime;

        public Guard(int from, int to, int workTime, int restTime) {
            this.from = from;
            this.to = to;
            this.workTime = workTime;
            this.restTime = restTime;
        }

        @Override
        public int compareTo(Guard o) {
            return Integer.compare(from, o.from);
        }
    }
}
