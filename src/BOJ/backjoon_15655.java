package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjoon_15655 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[] seq;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        seq = new int[N];
        isVisited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(seq);

        backTracking(0, "", 0);

        System.out.println(sb.toString());
    }

    static void backTracking(int length, String temp, int last) {
        if (length == M) {
            sb.append(temp.trim()).append("\n");
        }

        for (int i = 0; i < N; i++) {
            if (!isVisited[i] && last <= seq[i]) {
                isVisited[i] = true;
                backTracking(length + 1, temp + " " + seq[i], seq[i]);
                isVisited[i] = false;
            }
        }
    }
}
