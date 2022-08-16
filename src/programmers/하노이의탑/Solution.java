package programmers.하노이의탑;

public class Solution {
    static int k = 0;
    static void hanoi(int n, int from, int mid, int to, int[][] answer) {
        if (n == 1) {
            answer[k][0] = from;
            answer[k++][1] = to;
            return;
        }
        hanoi(n - 1, from, to, mid, answer);
        answer[k][0] = from;
        answer[k++][1] = to;
        hanoi(n - 1, mid, from, to, answer);
    }

    static int[][] solution(int n) {
        int[] sizeArr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                sizeArr[i] = 1;
            }
            sizeArr[i] = (sizeArr[i - 1] * 2) + 1;
        }
        int[][] answer = new int[sizeArr[n]][2];

        hanoi(n, 1, 2, 3, answer);

        return answer;

    }
}