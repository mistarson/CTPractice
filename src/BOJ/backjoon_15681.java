package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class backjoon_15681 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, R, Q;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] parentArr;
    static int[] size;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        parentArr = new int[N + 1];
        size = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            graph.get(U).add(V);
            graph.get(V).add(U);
        }

        countSubTree(R, 0);

        for (int i = 0; i < Q; i++) {
            int query = Integer.parseInt(br.readLine());
            sb.append(size[query]).append("\n");
        }

        System.out.println(sb);

    }

    static void countSubTree(int current, int parent) {
        size[current] = 1;
        for (int next : graph.get(current)) {
            if (next != parent) {
                parentArr[next] = current;
                countSubTree(next, current);
                size[current] += size[next];
            }
        }
    }

}
