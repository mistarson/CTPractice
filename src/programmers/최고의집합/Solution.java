package programmers.최고의집합;

public class Solution {
    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }
        int[] answer = new int[n];
        int extra = s % n;

        for (int i = 0; i < n; i++) {
            answer[i] = s / n;
            if (i >= n - extra) {
                answer[i]++;
            }
        }

        return answer;
    }
}
