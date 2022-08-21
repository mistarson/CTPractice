package programmers.거리두기확인하기;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] solution = new Solution().solution(places);
        System.out.println(Arrays.toString(solution));
    }
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {

            boolean keepDistanceFlag = true;
            for (int j = 0; j < 5; j++) {
                String place = places[i][j];
                for (int k = 0; k < 5; k++) {
                    char c = place.charAt(k);
                    if (c == 'P') {
                        if (!keepDistance(j, k, places[i])) {
                            keepDistanceFlag = false;
                        }
                    }
                }
            }
            answer[i] = keepDistanceFlag ? 1 : 0;
        }

        return answer;
    }

    static boolean keepDistance(int y, int x, String[] map) {

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(y, x));

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = current.y + dy[i];
                int nx = current.x + dx[i];

                if (!inRange(ny, nx) || (ny == y && nx == x)) {
                    continue;
                }

                int md = Math.abs(y - ny) + Math.abs(x - nx);

                // 맨허튼 거리 2안에 P가 있다면 실패
                if (map[ny].charAt(nx) == 'P' && md <= 2) {
                    return false;
                }

                // 맨허튼 거리 1에 테이블이 있다면 한번 더 봐야함.
                else if (map[ny].charAt(nx) == 'O' && md == 1) {
                    queue.add(new Position(ny, nx));
                }
            }
        }
        return true;
    }

    static class Position {
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static boolean inRange(int y, int x) {
        return y >= 0 && y < 5 && x >= 0 && x < 5;
    }
}
