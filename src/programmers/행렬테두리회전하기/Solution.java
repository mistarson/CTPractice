package programmers.행렬테두리회전하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        new Solution().solution(rows, columns, queries);
    }

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int answerIdx = 0;
        int[][] map = new int[rows + 1][columns + 1];

        int value = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                map[i][j] = value++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int startRow = queries[i][0];
            int startColumn = queries[i][1];
            int endRow = queries[i][2];
            int endColumn = queries[i][3];

            int y = startRow;
            int x = startColumn;

            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};
            int dir = 0;
            int temp = map[startRow][startColumn];
            int min = temp;

            while (true) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                min = Math.min(min, map[ny][nx]);

                map[y][x] = map[ny][nx];
                y = ny;
                x = nx;

                if (y == endRow && x == startColumn) {
                    dir++;
                }
                if (y == endRow && x == endColumn) {
                    dir++;
                }
                if (y == startRow && x == endColumn) {
                    dir++;
                }
                if (y == startRow && x == startColumn + 1) {
                    map[y][x] = temp;
                    break;
                }
            }
            answer[answerIdx++] = min;
        }
        return answer;
    }
}
