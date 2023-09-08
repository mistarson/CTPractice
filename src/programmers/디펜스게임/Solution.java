package programmers.디펜스게임;

import java.util.*;

public class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int answer = 0;
        int sum = 0;
        for (int i = 0; i < enemy.length; i++) {
            sum += enemy[i];
            pq.add(enemy[i]);
            if (sum > n) {
                if (k == 0) {
                    break;
                }
                if (!pq.isEmpty()) {
                    sum -= pq.poll();
                } else {
                    sum -= enemy[i];
                }
                k--;
            }
            answer++;
        }
        return answer;
    }
}
