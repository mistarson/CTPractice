package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjoon_18405 {
    static int N, K;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] virusMap = new int[N][N];
        List<Virus> virusList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                virusMap[i][j] = Integer.parseInt(st.nextToken());
                if (virusMap[i][j] != 0) {
                    virusList.add(new Virus(i, j, virusMap[i][j]));
                }
            }
        }

        Collections.sort(virusList);
        Queue<Virus> queue = new LinkedList<>(virusList);

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken()) - 1;
        int Y = Integer.parseInt(st.nextToken()) - 1;

        while (S-- > 0) {
            spreadVirus(virusMap, queue);
        }

        System.out.println(virusMap[X][Y]);

    }

    static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    static void spreadVirus(int[][] virusMap, Queue<Virus> queue) {
        int size = queue.size();
        for (int i = 0; i < size ; i++) {
            Virus virus = queue.poll();

            for (int j = 0; j < 4; j++) {
                int nr = virus.r + dr[j];
                int nc = virus.c + dc[j];

                if (inRange(nr, nc) && virusMap[nr][nc] == 0) {
                    queue.add(new Virus(nr, nc, virus.num));
                    virusMap[nr][nc] = virus.num;
                }
            }
        }

    }

    static class Virus implements Comparable<Virus>{
        int r;
        int c;
        int num;

        public Virus(int r, int c, int num) {
            this.r = r;
            this.c = c;
            this.num = num;
        }

        @Override
        public int compareTo(Virus o) {
            return Integer.compare(num, o.num);
        }
    }
}
