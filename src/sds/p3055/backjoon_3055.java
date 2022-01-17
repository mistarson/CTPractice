package sds.p3055;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon_3055 {

    //좌, 우, 위, 아래
    static final int[] MX = {-1, 1, 0, 0};
    static final int[] MY = {0, 0, -1, 1};

    static int R, C; // 상수로 받은 맵 크기
    static char[][] map; // 맵
    static int[][] dp; // 고슴도치가 이동한 거리를 알기 위한 map과 똑같은 크기의 배열
    static Queue<Point> queue = new LinkedList<>();
    static boolean foundAnswer; // 결국 방법이 없을 경우를 위한 변수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); // 행
        C = Integer.parseInt(st.nextToken()); // 열

        map = new char[R][C];
        dp = new int[R][C];

        //맵 초기화
        Point start = null;
        for (int i = 0; i < map.length; i++) {
            String mapStr = br.readLine();
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = mapStr.charAt(j);
                if (map[i][j] == 'S') {
                    start = new Point(i, j, 'S');
                } else if (map[i][j] == '*') {
                    queue.add(new Point(i, j, '*'));
                }
            }
        }

        queue.add(start);

        while (!queue.isEmpty()) {
            // 1.큐에서 꺼내옴 -> S, ., D, * (이렇게 네가지가 들어옴)
            Point p = queue.poll();
            // 2. 목적지인가? -> D
            if (p.type == 'D') {
                bw.write(String.valueOf(dp[p.y][p.x]));
                foundAnswer = true;
                break;
            }
            // 3. 연결된 곳을 순회 -> 좌, 우, 위, 아래
            for (int i = 0; i < 4; i++) {
                int ty = p.y + MY[i];
                int tx = p.x + MX[i];

                //4. 갈 수 있는가? (물: 맵을 벗어나지 않고, .)
                // 4. 갈수 있는가? - > 맵을 벗어나지 않고
                if (0 <= ty && ty < R && 0 <= tx && tx < C) {
                    if (p.type == '.' || p.type == 'S') {

                        // 4. 갈 수 있는가? (고슴도치: . or D, 방문하지 않은 곳)
                        if ((map[ty][tx] == '.' || map[ty][tx] == 'D') && dp[ty][tx] == 0) {
                            //5. 체크인 -> db에 현재 +1을 기록
                            dp[ty][tx] = dp[p.y][p.x] + 1;
                            //6. 큐에 넣음
                            queue.add(new Point(ty, tx, map[ty][tx]));
                        }

                    } else if (p.type == '*') {
                        // 4. 갈 수 있는가? (물: .)
                        if (map[ty][tx] == '.' || map[ty][tx] == 'S') {
                            //5. 체크인 -> 지도에 * 표기
                            map[ty][tx] = '*';
                            //6. 큐에 넣음
                            queue.add(new Point(ty, tx, '*'));
                        }
                    }
                }
            }
        }
        if (!foundAnswer) {
            bw.write("KAKTUS");
        }
        bw.flush();
    }

}

class Point {
    int y;
    int x;
    char type;

    public Point(int y, int x, char type) {
        super();
        this.y = y;
        this.x = x;
        this.type = type;
    }
}
