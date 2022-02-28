package programmers.level1.예산;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

        int[] d = {2,2,3,3};
        int budget = 10;

        solution(d, budget);

    }

    static int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        for (int i = 0; i < d.length; i++) {
            if (d[i] <= budget) {
                answer++;
                budget -= d[i];
            } else {
                break;
            }
        }

        return answer;
    }
}
