package programmers.게임맵최단거리;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static int m, n;

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int solution = new Solution().solution(maps);
        System.out.println(solution);
    }

    public int solution(int[][] maps) {

        n = maps.length;
        m = maps[0].length;

        if (n == 1 && m == 1) {
            return maps[0][0];
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int answer = -1;

        Queue<Position> queue = new LinkedList<>();

        queue.add(new Position(0, 0));
        while (!queue.isEmpty()) {
            Position current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (inRange(nx, ny) && maps[ny][nx] == 1) {
                    if (ny == n - 1 && nx == m - 1) {
                        return maps[current.y][current.x] + 1;
                    }
                    maps[ny][nx] = maps[current.y][current.x] + 1;
                    queue.add(new Position(ny, nx));
                }
            }

        }

        return answer;
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    static class Position {
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
