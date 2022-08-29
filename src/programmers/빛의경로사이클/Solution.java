package programmers.빛의경로사이클;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String[] grid = {"S", "S"};
        int[] solution = new Solution().solution(grid);

        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(String[] grid) {
        final int max_y = grid.length;
        final int max_x = grid[0].length();
        final int DIR_NUM = 4;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][][] isVisited = new boolean[max_y][max_x][DIR_NUM];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < DIR_NUM; i++) {
            for (int j = 0; j < max_y; j++) {
                for (int k = 0; k < max_x; k++) {
                    int cnt = 0;
                    if (!isVisited[j][k][i]) {
                        int y = j;
                        int x = k;
                        int dir = i;
                        while (!isVisited[y][x][dir]) {
                            cnt++;
                            isVisited[y][x][dir] = true;
                            char c = grid[y].charAt(x);
                            if (c == 'L') {
                                dir = (dir - 1 + 4) % 4;
                            } else if (c == 'R') {
                                dir = (dir + 1) % 4;
                            }
                            int ny = y + dy[dir];
                            int nx = x + dx[dir];

                            if (inRange(ny, nx, max_y, max_x)) {
                                y = ny;
                                x = nx;
                            } else {
                                switch (dir) {
                                    case 0:
                                        y = ny;
                                        x = 0;
                                        break;
                                    case 1:
                                        y = 0;
                                        x = nx;
                                        break;
                                    case 2:
                                        y = ny;
                                        x = max_x - 1;
                                        break;
                                    case 3:
                                        y = max_y - 1;
                                        x = nx;
                                }
                            }
                        }
                        list.add(cnt);
                    }
                }
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }
    static boolean inRange(int y, int x, int max_y, int max_x) {
        return y >= 0 && y < max_y && x >= 0 && x < max_x;
    }
}
