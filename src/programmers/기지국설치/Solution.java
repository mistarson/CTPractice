package programmers.기지국설치;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int n = 16;
        int[] stations = {9};
        int w = 2;

        int solution = new Solution().solution(n, stations, w);
        System.out.println(solution);

    }

    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int range = w * 2 + 1;
        int start = 1;
        for (int i = 0; i < stations.length; i++) {
            int end = stations[i] - w - 1;
            if (end < start) {
                start = stations[i] + w + 1;
                continue;
            }
            int length = end - start + 1;
            answer += length / range;
            if (length % range != 0) {
                answer++;
            }
            start = stations[i] + w + 1;
        }

        if (start <= n) {
            int length = n - start + 1;
            answer += length / range;
            if (length % range != 0) {
                answer++;
            }
        }


        return answer;
    }


}
