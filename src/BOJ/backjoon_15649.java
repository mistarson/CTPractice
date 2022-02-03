package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class backjoon_15649 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isVisited = new boolean[N + 1];

        dfs(0);

        bw.flush();
    }

    static void dfs(int length) throws IOException {
        if (length == M) {
            for (int i = 0; i < sb.length(); i++) {
                bw.write(sb.charAt(i)+ " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!isVisited[i]) {
                sb.append(i);
                isVisited[i] = true;
                dfs(length + 1);
                isVisited[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
