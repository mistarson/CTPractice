package backjoon;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon_1260 {

    static int N, M, V;
    static boolean[][] map;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        map = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = map[y][x] = true;
        }

        dfs(V);
        sb.append("\n");
        Arrays.fill(visited, false);
        bfs(V) ;

        System.out.println(sb.toString());
    }

    static void dfs(int node) {

        visited[node] = true;
        sb.append(node + " ");

        for (int i = 1; i < N + 1; i++) {
            if (map[node][i] && !visited[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int node) {
        queue.add(node);
        visited[node] = true;
        sb.append(node + " ");
        while (queue.size() != 0) {
            Integer poll = queue.poll();
            for (int i = 1; i < N + 1; i++) {
                if (map[poll][i] && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    sb.append(i + " ");
                }
            }
        }
    }

}
