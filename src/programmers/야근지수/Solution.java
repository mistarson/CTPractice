package programmers.야근지수;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < works.length; i++) {
            pq.add(works[i]);
        }

        while (n-- > 0) {
            Integer poll = pq.poll();
            if (poll <= 0) {
                poll = 1;
            }
            pq.add(poll - 1);
        }

        while (!pq.isEmpty()) {
            Integer extrajob = pq.poll();
            answer += Math.pow(extrajob, 2);
        }
        return answer;
    }
}
