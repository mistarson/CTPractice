package programmers.방문길이;

import java.util.*;

public class Solution {
    public int solution(String dirs) {
        int[] dr = {0, 0, 1, -1};
        int[] dc = {-1, 1, 0, 0};
        char[] dirNum = new char[128];
        dirNum['U'] = 0;
        dirNum['D'] = 1;
        dirNum['R'] = 2;
        dirNum['L'] = 3;

        int r = 0;
        int c = 0;
        Set<String> visitedSet = new HashSet<>();
        for (int i = 0; i < dirs.length(); i++) {
            int dir = dirNum[dirs.charAt(i)];

            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (inRange(nr, nc)) {
                String path = String.valueOf(r) + c + nr + nc;
                String reversPath = String.valueOf(nr) + nc + r + c;
                r = nr;
                c = nc;
                visitedSet.add(path);
                visitedSet.add(reversPath);

            }

        }

        return visitedSet.size() / 2;
    }

    public boolean inRange(int r, int c) {
        return r >= -5 && r <= 5 && c >= -5 && c <= 5;
    }
}
