package programmers.level2.행렬테두리회전하기;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};

        int[] solution = solution(rows, columns, queries);

        System.out.println(Arrays.toString(solution));

    }

    static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows + 1][columns + 1];

        // 맵 초기화
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                map[i][j] = (i - 1) * columns + j;
            }
        }

        for (int i = 0; i < queries.length; i++) {

            int sr = Math.min(queries[i][0], queries[i][2]);
            int sc = Math.min(queries[i][1], queries[i][3]);
            int er = Math.max(queries[i][0], queries[i][2]);
            int ec = Math.max(queries[i][1], queries[i][3]);

            int min = map[sr][sc];
            int temp = map[sr][sc];

            //왼쪽 변
            for (int j = sr; j < er; j++) {
                map[j][sc] = map[j + 1][sc];
                min = Math.min(min, map[j][sc]);
            }

            //밑변
            for (int j = sc; j < ec; j++) {
                map[er][j] = map[er][j + 1];
                min = Math.min(min, map[er][j]);
            }

            //오른쪽 변
            for (int j = er; j > sr; j--) {
                map[j][ec] = map[j - 1][ec];
                min = Math.min(min, map[j][ec]);
            }

            //윗변
            for (int j = ec; j > sc+1; j--) {
                map[sr][j] = map[sr][j - 1];
                min = Math.min(min, map[sr][j]);
            }
            map[sr][sc + 1] = temp;

            for (int[] arr : map) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println();

            answer[i] = min;

        }

        return answer;
    }
}
