package winter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
    static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
    static int N, M;

    public static void main(String[] args) {
        String[] worldmap = {"..XXX", "..XXX", "...XX", "X....", "XXX.."};
        int solution = new Solution3().solution(worldmap);
    }

    public int solution(String[] worldmap) {
        int answer = 0;

        N = worldmap.length;
        M = worldmap[0].length();

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = worldmap[i];
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        boolean[][] isVisited = new boolean[N][M];
        isVisited[0][0] = true;
        Queue<Boat> queue = new LinkedList<>();
        queue.add(new Boat(0, 0, 0));
        while (!queue.isEmpty()) {
            Boat current = queue.poll();

            int forward_r = current.r + dr[current.dir];
            int forward_c = current.c + dr[current.dir];
            if (map[forward_r][forward_c] != 'X' && !isVisited[forward_r][forward_c]) {
                queue.add(new Boat(forward_r, forward_c, current.dir));
            }


        }

        return answer;
    }



    static class Boat {
        int r;
        int c;
        int dir;

        public Boat(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }
}
