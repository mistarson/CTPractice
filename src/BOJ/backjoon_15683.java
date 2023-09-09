package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjoon_15683 {
    static int N, M;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static List<CCTV> CCTVList = new ArrayList<>();
    static int[] permutation;
    static int[][] map;
    static int minSquareArea = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    CCTVList.add(new CCTV(i, j, map[i][j]));
                }
            }
        }

        permutation = new int[CCTVList.size()];
        findMinSquareArea(0);

        System.out.println(minSquareArea);

    }

    public static void findMinSquareArea(int cnt) {
        if (cnt == CCTVList.size()) {
            checkSquareArea();
            return;
        }

        for (int i = 0; i < 4; i++) {
            permutation[cnt] = i;
            findMinSquareArea(cnt + 1);
        }
    }

    public static void checkSquareArea() {
        int[][] copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < CCTVList.size(); i++) {
            CCTV cctv = CCTVList.get(i);
            setCCTVDir(cctv, permutation[i], copyMap);
        }

        int squareArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    squareArea++;
                }
            }
        }

        minSquareArea = Math.min(minSquareArea, squareArea);

    }

    public static void setCCTVDir(CCTV cctv, int rotate, int[][] copyMap) {
        if (cctv.type == 1) {
            colorCCTVSight(cctv, rotate, copyMap);
        } else if (cctv.type == 2) {
            if (rotate == 0 || rotate == 2) {
                colorCCTVSight(cctv, 0, copyMap);
                colorCCTVSight(cctv, 2, copyMap);
            } else {
                colorCCTVSight(cctv, 1, copyMap);
                colorCCTVSight(cctv, 3, copyMap);
            }

        } else if (cctv.type == 3) {
            if (rotate == 0) {
                colorCCTVSight(cctv, 0, copyMap);
                colorCCTVSight(cctv, 3, copyMap);
            } else if (rotate == 1) {
                colorCCTVSight(cctv, 0, copyMap);
                colorCCTVSight(cctv, 1, copyMap);
            } else if (rotate == 2) {
                colorCCTVSight(cctv, 1, copyMap);
                colorCCTVSight(cctv, 2, copyMap);
            } else {
                colorCCTVSight(cctv, 2, copyMap);
                colorCCTVSight(cctv, 3, copyMap);
            }
        } else if (cctv.type == 4) {
            if (rotate == 0) {
                colorCCTVSight(cctv, 0, copyMap);
                colorCCTVSight(cctv, 2, copyMap);
                colorCCTVSight(cctv, 3, copyMap);
            } else if (rotate == 1) {
                colorCCTVSight(cctv, 0, copyMap);
                colorCCTVSight(cctv, 1, copyMap);
                colorCCTVSight(cctv, 3, copyMap);
            } else if (rotate == 2) {
                colorCCTVSight(cctv, 0, copyMap);
                colorCCTVSight(cctv, 1, copyMap);
                colorCCTVSight(cctv, 2, copyMap);
            } else {
                colorCCTVSight(cctv, 1, copyMap);
                colorCCTVSight(cctv, 2, copyMap);
                colorCCTVSight(cctv, 3, copyMap);
            }
        } else {
            colorCCTVSight(cctv, 0, copyMap);
            colorCCTVSight(cctv, 1, copyMap);
            colorCCTVSight(cctv, 2, copyMap);
            colorCCTVSight(cctv, 3, copyMap);
        }
    }

    public static void colorCCTVSight(CCTV cctv, int dir, int[][] copyMap) {
        Queue<CCTV> queue = new LinkedList<>();
        queue.add(cctv);
        while (!queue.isEmpty()) {
            CCTV current = queue.poll();

            int nr = current.r + dr[dir];
            int nc = current.c + dc[dir];

            if (inRange(nr, nc) && map[nr][nc] != 6) {
                copyMap[nr][nc] = 7;
                queue.add(new CCTV(nr, nc, current.type));
            }
        }
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    static class CCTV{
        int r;
        int c;
        int type;

        public CCTV(int r, int c, int type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }
    }
}
