package programmers.HIndex;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};

        int solution = solution(citations);

        System.out.println(solution);

    }
    static int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }
}
