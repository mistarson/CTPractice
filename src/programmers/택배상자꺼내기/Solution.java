package programmers.택배상자꺼내기;

public class Solution {
    public int solution(int n, int w, int num) { // 13 3 6
        int answer = 1;
        int targetW = calculateW(w, num);
        for (int i = num + 1; i <= n ; i++) {
            if (calculateW(w, i) == targetW) {
                answer++;
            }
        }
        return answer;
    }

    int calculateW(int w, int num) {
        int r = (num - 1) / w;
        int col = (num - 1) % w;
        if (r % 2 != 0) {
            col = (w - 1) - col;
        }

        return col;
    }
}
