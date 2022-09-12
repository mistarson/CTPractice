package programmers.숫자블록;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        long begin = 999999 * 10000;
        long end = 1000000 * 10000;
        int[] solution = new Solution().solution(1, 10);

        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin + 1)];
        for (long i = begin; i <= end; i++) {
            if (i == 1) {
                continue;
            }
            long max = 1;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    if (i / j != i) {
                        if (i / j <= 10000000)
                            max = Math.max(max, i / j);
                    }
                }
            }
            answer[(int) (i - begin)] = (int) max;
        }

        return answer;
    }
}
