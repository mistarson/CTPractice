package programmers.공이동시뮬레이션;

public class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        long answer = -1;

        long max_x = x;
        long max_y = y;
        long min_x = x;
        long min_y = y;
        for (int i = queries.length - 1; i >= 0; i--) {
            int dir = queries[i][0];
            int dist = queries[i][1];

            switch (dir) {
                case 0:
                    max_y += dist;
                    if (max_y > m - 1) {
                        max_y = m - 1;
                    }
                    if (min_y != 0) {
                        min_y += dist;
                    }
                    break;
                case 1:
                    min_y -= dist;
                    if (min_y < 0) {
                        min_y = 0;
                    }
                    if (max_y != m - 1) {
                        max_y -= dist;
                    }
                    break;
                case 2:
                    max_x += dist;
                    if (max_x > n - 1) {
                        max_x = n - 1;
                    }
                    if (min_x != 0) {
                        min_x += dist;
                    }
                    break;
                case 3:
                    min_x -= dist;
                    if (min_x < 0) {
                        min_x = 0;
                    }
                    if (max_x != n - 1) {
                        max_x -= dist;
                    }
                    break;
            }
            if (min_y > m - 1 || max_y < 0 || min_x > n - 1 || max_x < 0) {
                return answer;
            } else {
                answer = (max_y - min_y + 1) * (max_x - min_x + 1);
            }
        }

        return answer;
    }
}
