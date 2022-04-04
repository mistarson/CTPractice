package programmers.level2.카카오프렌즈컬러링북;

import java.util.*;

public class Solution {
    static int[] ty = {-1, 1, 0, 0};
    static int[] tx = {0, 0, -1, 1};

    public static void main(String[] args) {

        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[] solution = solution(m, n, picture);
        System.out.println(solution[0]);
        System.out.println(solution[1]);
    }

    static int[] solution(int m, int n, int[][] picture) {
        boolean[][] visited = new boolean[m][n];
        List<Area> list = new ArrayList<>();
        int[] answer = new int[2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    Queue<Position> queue = new LinkedList<>();
                    int target = picture[i][j];
                    int area = 1;
                    queue.add(new Position(i, j, target));
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        Position poll = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int ny = ty[k] + poll.y;
                            int nx = tx[k] + poll.x;
                            if (ny >= 0 && ny < m && nx >= 0 && nx < n && !visited[ny][nx] && picture[ny][nx] == target) {
                                visited[ny][nx] = true;
                                area++;
                                queue.add(new Position(ny, nx, target));
                            }
                        }
                    }
                    list.add(new Area(target, area));
                }
            }
        }

        Collections.sort(list);

        answer[0] = list.size();
        answer[1] = list.get(0).size;

        return answer;
    }

    static class Position {
        int y;
        int x;
        int target;

        public Position(int y, int x, int target) {
            this.y = y;
            this.x = x;
            this.target = target;
        }
    }

    static class Area implements Comparable<Area>{
        int number;
        int size;

        public Area(int number, int size) {
            this.number = number;
            this.size = size;
        }

        @Override
        public int compareTo(Area o) {
            return Integer.compare(o.size, size);
        }
    }

}
