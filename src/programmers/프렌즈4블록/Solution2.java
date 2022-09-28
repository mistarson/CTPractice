package programmers.프렌즈4블록;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    static int bombCnt = 0;
    public static void main(String[] args) {
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        int solution = new Solution2().solution(4, 5, board);
        System.out.println(solution);
    }
    public int solution(int m, int n, String[] board) {

        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        while (bomb(map)) {
            arrange(map);
        }
        return bombCnt;
    }

    public boolean bomb(char[][] map) {

        boolean bombFlag = false;

        Queue<Position> removeQueue = new LinkedList<>();
        for (int i = 0; i < map.length - 1; i++) {
            for (int j = 0; j < map[i].length - 1; j++) {
                char b1 = map[i][j];
                if (b1 == 0) {
                    continue;
                }
                char b2 = map[i][j + 1];
                char b3 = map[i + 1][j];
                char b4 = map[i + 1][j + 1];

                if (b1 == b2 && b1 == b3 && b1 == b4) {
                    bombFlag = true;
                    removeQueue.add(new Position(i, j));
                }
            }
        }

        for (Position position : removeQueue) {
            if (map[position.x][position.y] != 0) {
                bombCnt++;
                map[position.x][position.y] = 0;
            }
            if (map[position.x][position.y + 1] != 0) {
                bombCnt++;
                map[position.x][position.y + 1] = 0;
            }
            if (map[position.x + 1][position.y] != 0) {
                bombCnt++;
                map[position.x + 1][position.y] = 0;
            }
            if (map[position.x + 1][position.y + 1] != 0) {
                bombCnt++;
                map[position.x + 1][position.y + 1] = 0;
            }
        }

        return bombFlag;
    }

    public void arrange(char[][] map) {
        char[][] temp = new char[map.length][map[0].length];

        for (int i = 0; i < map[0].length; i++) {
            int tempIdx = map.length - 1;
            for (int j = map.length - 1; j >= 0; j--) {
                if (map[j][i] != 0) {
                    temp[tempIdx--][i] = map[j][i];
                }
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = temp[i][j];
            }
        }

    }

    public class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
