package programmers.더맵게;

import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        int[] scoville = {1, 2};

        int solution = solution(scoville, 7);

        System.out.println(solution);
    }
    static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int source : scoville) {
            minHeap.add(source);
        }

        while (true) {
            boolean needCheck = false;

            for (int source : minHeap) {
                if (source < K) {
                    needCheck = true;
                    break;
                }
            }
            if (needCheck) {
                if (minHeap.size() == 1) {
                    return -1;
                }
                answer++;
                int newSource = minHeap.poll() + minHeap.poll() * 2;
                minHeap.add(newSource);
            } else {
                break;
            }
        }
        return answer;
    }
}
