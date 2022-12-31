package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjoon_14675 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            switch (t) {
                // k번 정점이 단절점인지
                case 1:
                    // 리프노드이외에 모든 노드는 단절점이다.
                    if (isBreakPoint(k, graph)) {
                        sb.append("yes");
                    } else sb.append("no");
                    sb.append("\n");
                    break;

                // k번째 간선이 단절선인지
                case 2:
                    // 트리 구조에서 모든 선은 단절선이다.
                    sb.append("yes");
                    break;
            }
        }

        System.out.println(sb);
    }

    static boolean isBreakPoint(int k, List<List<Integer>> graph) {
        return graph.get(k).size() > 1;
    }
}
