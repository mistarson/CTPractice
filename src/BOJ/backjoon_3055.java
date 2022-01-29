package BOJ;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon_3055 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] my = {0, -1, 0, 1};
    static int[] mx = {-1, 0, 1, 0};
    static char map[][];
    static int dist[][];
    static Queue<Point> queue = new LinkedList<>();
    static Point hed;


    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        dist = new int[R][C];

        for (int i = 0; i < R; i++) {
            String mapStr = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = mapStr.charAt(j);
                if (map[i][j] == '*') {
                    queue.add(new Point(i, j, '*'));
                } else if (map[i][j] == 'S') {
                    hed = new Point(i, j, 'S');
                }
            }
        }
        queue.add(hed);
        int result = 0;
        while (queue.size() > 0) {

            Point object = queue.poll();

            if (object.type == 'D') {
                result = dist[object.y][object.x];
            }

            for (int i = 0; i < 4; i++) {
                int nextY = object.y + my[i];
                int nextX = object.x + mx[i];

                if (nextY >= 0 && nextY < R && nextX >= 0 && nextX < C) {
                    if (object.type == 'S' || object.type == '.') {
                        if ((map[nextY][nextX] == '.' || map[nextY][nextX] == 'D') && dist[nextY][nextX] == 0) {
                            dist[nextY][nextX] = dist[object.y][object.x] + 1;
                            queue.add(new Point(nextY, nextX, map[nextY][nextX]));
                        }
                    } else if (object.type == '*') {
                        if (map[nextY][nextX] == '.' || map[nextY][nextX] == 'S') {
                            map[nextY][nextX] = '*';
                            queue.add(new Point(nextY, nextX, '*'));
                        }
                    }
                }
            }
        }

        if (result == 0) {
            bw.write("KAKTUS");
        } else {
            bw.write(result + "");
        }
        bw.flush();
    }

    static class Point {
        int y;
        int x;
        char type;

        public Point(int y, int x, char type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }

    }

}
