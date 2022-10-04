package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjoon_20056 {
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<FireBall> queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            queue.add(new FireBall(r, c, m, s, d));
        }

        for (int i = 0; i < K; i++) {
            Map<String, List<FireBall>> map = new HashMap<>();
            // 모든 파이어볼 이동
            while (!queue.isEmpty()) {
                FireBall fireBall = queue.poll();
                int nr = (fireBall.r + (dr[fireBall.d] * fireBall.s)) % N;
                int nc = (fireBall.c + (dc[fireBall.d] * fireBall.s)) % N;

                if (nr < 0) {
                    nr = N + nr;
                }

                if (nc < 0) {
                    nc = N + nc;
                }

                String rc = nr + " " + nc;
                if (!map.containsKey(rc)) {
                    map.put(rc, new ArrayList<>());
                }
                map.get(rc).add(new FireBall(nr, nc, fireBall.m, fireBall.s, fireBall.d));
            }

            for (String key : map.keySet()) {
                List<FireBall> fireBallList = map.get(key);
                if (fireBallList.size() > 1) {
                    int sumM = 0;
                    int sumS = 0;
                    boolean oddFlag = false;
                    String totalOddEven = "";
                    for (int j = 0; j < fireBallList.size(); j++) {
                        if (j == 0) {
                            totalOddEven = fireBallList.get(j).d % 2 == 0 ? "even" : "odd";
                        } else {
                            if (!oddFlag) {
                                String oddEven = fireBallList.get(j).d % 2 == 0 ? "even" : "odd";
                                if (!totalOddEven.equals(oddEven)) {
                                    oddFlag = true;
                                }
                            }
                        }
                        sumM += fireBallList.get(j).m;
                        sumS += fireBallList.get(j).s;
                    }

                    if (sumM / 5 == 0) {
                        continue;
                    }
                    int d = 0;
                    if (oddFlag) {
                        d = 1;
                    }


                    st = new StringTokenizer(key);
                    int r = Integer.parseInt(st.nextToken());
                    int c = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < 4; j++) {
                        queue.add(new FireBall(r, c, sumM / 5, sumS / fireBallList.size(), d));
                        d += 2;
                    }
                } else {
                    queue.add(fireBallList.get(0));
                }
            }

        }

        int sum = 0;
        while (!queue.isEmpty()) {
            FireBall fireBall = queue.poll();
            sum += fireBall.m;

        }

        System.out.println(sum);


    }

    static class FireBall {
        int r;
        int c;
        int m;
        int d;
        int s;

        public FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.d = d;
            this.s = s;
        }
    }

}
