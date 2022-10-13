package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class backjoon_21937 {
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        boolean[] isVisited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
        }

        int X = Integer.parseInt(br.readLine());

        dfs(X, graph, isVisited);

        System.out.println(cnt);
    }

    static void dfs(int node, List<List<Integer>> graph, boolean[] isVisited) {
        isVisited[node] = true;
        List<Integer> list = graph.get(node);
        for (int i = 0; i < list.size(); i++) {
            if (!isVisited[list.get(i)]) {
                cnt++;
                dfs(list.get(i), graph, isVisited);
            }
        }
    }
}
