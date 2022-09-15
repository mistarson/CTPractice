package programmers.줄서는방법;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int n = 3;
        long k = 1;

        int[] solution = new Solution().solution(n, k);
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(int n, long k) {
        List<Integer> list = new ArrayList<>();
        int[] answer = new int[n];
        long[] facDp = new long[n + 1];
        
        // 팩토리얼 구하기
        facDp[0] = 1;
        for (int i = 1; i <= n; i++) {
            facDp[i] = facDp[i - 1] * i;
            list.add(i);
        }

        // k-1 / n-1!(팩토리얼) = 몇번째부터 시작하는지 알 수 있음
        int idx = 0;
        k--;
        for (int i = n; i > 0; i--) {
            long first = k / facDp[i - 1];
            answer[idx++] = list.get((int) first);
            list.remove((int) first);
            k %= facDp[i - 1];
        }

        return answer;
    }

}
