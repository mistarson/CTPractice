package programmers.숫자게임;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution2 {
    public static void main(String[] args) {
        int[] A = {5, 1, 3, 7};
        int[] B = {2, 2, 6, 8};

        int solution = new Solution2().solution(A, B);
        System.out.println(solution);
    }
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : B) {
            pq.add(num);
        }

        loop:
        for (int numA : A) {
            while (true) {
                if (!pq.isEmpty()) {
                    Integer numB = pq.poll();
                    if (numA < numB) {
                        answer++;
                        break;
                    }
                }else break loop;
            }
        }
        return answer;
    }
}
