package programmers.징검다리건너기;

public class Solution {
    public int solution(int[] stones, int k) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < stones.length; i++) {
            min = Math.min(min, stones[i]);
            max = Math.max(max, stones[i]);
        }

        int left = min;
        int right = max;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (canCross(mid, stones, k)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;

    }

    public boolean canCross(int passCnt, int[] stones, int k) {
        int zeroCnt = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] - passCnt <= 0) {
                zeroCnt++;
                if (zeroCnt >= k) {
                    return false;
                }
            } else zeroCnt = 0;
        }
        return true;
    }
}